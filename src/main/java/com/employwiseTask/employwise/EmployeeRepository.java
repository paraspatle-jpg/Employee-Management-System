package com.employwiseTask.employwise;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {
    // Add custom queries if needed
}
