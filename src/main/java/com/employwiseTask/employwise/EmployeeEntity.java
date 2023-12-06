package com.employwiseTask.employwise;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class EmployeeEntity {

    @Id
    private String id;
    private String employeeName;
    private String phoneNumber;
    private String email;
    private String reportsTo;
    private String profileImage;

    public EmployeeEntity(String employeeName, String phoneNumber, String email, String reportsTo, String profileImage){
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.reportsTo = reportsTo;
        this.profileImage = profileImage;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }

    public void setEmployeeName(String name){
        this.employeeName = name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setReportsTo(String reportsTo){
        this.reportsTo = reportsTo;
    }
    public void setProfileImage(String employeeName){
        this.employeeName = employeeName;
    }

    public String getEmployeeName(){
        return this.employeeName;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getEmail(){
        return this.email;
    }
    public String getReportsTo(){
        return this.reportsTo;
    }
    public String getProfileImage(){
        return this.employeeName;
    }

}
