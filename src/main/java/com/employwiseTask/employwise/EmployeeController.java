package com.employwiseTask.employwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String test() {
        return "Hello world!!";
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Map<String,Object> temp) {
        System.out.println(temp);
        EmployeeEntity employee = new EmployeeEntity((String) temp.get("employeeName"), (String) temp.get("phoneNumber"), (String) temp.get("email"), (String) temp.get("reportsTo"), (String) temp.get("profileImage"));
        String employeeId = employeeService.addEmployee(employee);
        return "Employee added successfully with ID: "+employeeId ;
    }

    @GetMapping("/get")
    public Page<EmployeeEntity> getAllEmployees(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(defaultValue = "employeeName") String sortBy){
        return employeeService.getAllEmployeesWithPagination(page, size, sortBy);
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployeeById(@PathVariable String employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "Employee deleted successfully";
    }

    @PutMapping("/update/{employeeId}")
    public String updateEmployeeById(@PathVariable String employeeId, @RequestBody EmployeeEntity updatedEmployee) {
        employeeService.updateEmployeeById(employeeId, updatedEmployee);
        return "Employee updated successfully";
    }

    @GetMapping("/manager/{employeeId}")
    public EmployeeEntity getNthLevelManager(@PathVariable String employeeId, @RequestParam int level) {
        return employeeService.getNthLevelManager(employeeId, level);
    }


}
