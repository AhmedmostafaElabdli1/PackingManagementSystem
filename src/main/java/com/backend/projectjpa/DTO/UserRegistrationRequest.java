package com.backend.projectjpa.DTO;

public class UserRegistrationRequest {

    private String first_name;
    private String last_name;
    private String nid;
    private String userType;
    private Integer age;

    private String email;

    private String salary;
    private String phone;
    private String address;
    private String userName;
    private String password;

    // Default constructor
    public UserRegistrationRequest() {
    }

    // Constructor with parameters
    public UserRegistrationRequest(String firstName, String last_name, String nid, String userType,
                                   Integer age, String phone, String address, String userName, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nid = nid;
        this.userType = userType;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.userName = userName;
        this.password = password;
    }

    // Getters and setters

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

