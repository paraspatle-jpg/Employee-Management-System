package com.employwiseTask.employwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String addEmployee(EmployeeEntity employee) {
        employee.setId(java.util.UUID.randomUUID().toString());
        EmployeeEntity savedEmployee = employeeRepository.save(employee);
        return savedEmployee.getId();
    }

    public Page<EmployeeEntity> getAllEmployeesWithPagination(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }

    public void deleteEmployeeById(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployeeById(String employeeId, EmployeeEntity updatedEmployee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        existingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
        existingEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setReportsTo(updatedEmployee.getReportsTo());
        existingEmployee.setProfileImage(updatedEmployee.getProfileImage());

        employeeRepository.save(existingEmployee);
    }

    public EmployeeEntity getNthLevelManager(String employeeId, int level) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()) {
            EmployeeEntity currentEmployee = employeeOptional.get();
            return getNthLevelManagerRecursive(currentEmployee, level);
        } else {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }
    }

    private EmployeeEntity getNthLevelManagerRecursive(EmployeeEntity employee, int level) {
        if (level == 0) {
            return employee;
        }

        String reportsToId = employee.getReportsTo();
        if (reportsToId == null || reportsToId.isEmpty()) {
            throw new RuntimeException("Manager not found for employee with ID: " + employee.getId());
        }

        Optional<EmployeeEntity> managerOptional = employeeRepository.findById(reportsToId);
        if (managerOptional.isPresent()) {
            return getNthLevelManagerRecursive(managerOptional.get(), level - 1);
        } else {
            throw new RuntimeException("Manager not found with ID: " + reportsToId);
        }
    }

    // Add other business logic as needed
}
