# Employee-Management-System
An employee management system built using Spring Boot and MongoDB

## How to Run

I am adding application.properties with the zip file, and no Database configuration needed as I have used MongoDB Atlas with public access.

### Java version : 
    java version "17.0.8" 2023-07-18 LTS

To Run the application use Intellij Idea and open this project and move to 

    ./src/main/java/com.employwiseTask.employwise
in project explorer.

Locate the file 
    
    EmploywiseApplication
 and run it, by either clicking on run icon in action bar or Right clicking on file name and then clicking on Run.

The project will be available on 

    http://localhost:8080/api/employees/

Go here to see a secret message.


## 1. Add Employee
### Endpoint: POST /api/employees/add

Input:

    {
        "employeeName": "John Doe",
        "phoneNumber": "+1 123-456-7890",
        "email": "john.doe@example.com",
        "reportsTo": "managerId",
        "profileImage": "http://example.com/image.jpg"
    }

Response:

    Employee added successfully with ID: --employee's UUID--
    


## 2. Get All Employees with Pagination and Sorting

### Endpoint: GET /api/employees/get

Parameters:

    page (default: 0) - Page number
    size (default: 10) - Page size
    sortBy (default: "employeeName") - Sorting criteria

Response:

    [
    {
        "id": "employeeId",
        "employeeName": "John Doe",
        "phoneNumber": "+1 123-456-7890",
        "email": "john.doe@example.com",
        "reportsTo": "managerId",
        "profileImage": "http://example.com/image.jpg"
    },
    // ... (other employees)
    ]

## 3. Delete Employee by ID

### Endpoint: DELETE /api/employees/delete/{employeeId}

Response:

    Employee deleted successfully

## 4. Update Employee by ID

### Endpoint: PUT /api/employees/update/{employeeId}

Input:

    {
    "employeeName": "Updated Name",
    "phoneNumber": "+1 987-654-3210",
    "email": "updated.email@example.com",
    "reportsTo": "updatedManagerId",
    "profileImage": "http://example.com/updated-image.jpg"
    }

Response:

    Employee updated successfully

## 5. Get nth Level Manager of an Employee

### Endpoint: GET /api/employees/manager/{employeeId}?level={n}

Parameters:

    level - Level of the manager

Response:
    
    {
        "id": "managerId",
        "employeeName": "Manager Name",
        "phoneNumber": "+1 111-222-3333",
        "email": "manager@example.com",
        "reportsTo": "grandManagerId",
        "profileImage": "http://example.com/manager-image.jpg"
    }


## Deployment

Due to some credit card issues I was not able to deploy, I was searching for options that don't ask for credit card but there were none that , if the one reading this has an option, please communicate it with me on paras18224827@gmail.com, It would be really appreciated.
