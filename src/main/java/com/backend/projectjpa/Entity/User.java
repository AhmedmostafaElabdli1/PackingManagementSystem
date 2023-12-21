package com.backend.projectjpa.Entity;

import jakarta.persistence.*;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String first_name;

    private String last_name;

    //    @Column(name = "NID", unique = true, length = 20)
    private String nid;

    //    @Column(name = "UserType")
    private String user_type;  // admin or salesman

    //    @Column(name = "Age")
    private Integer age;

    //    @Column(name = "Phone", length = 11)
    private String phone;

    //    @Column(name = "Address")
    private String address;

    //    @Column(name = "Username")
    private String user_name;

    //    @Column(name = "Password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "user_id")
    private User manager_id;

    @OneToMany(mappedBy = "salesman")
    private List<Transaction> transactions;
    private Double salary;

    private String email;


    public Long getUser_id() {
        if (user_id == null){
            return 20L;
        }
        return user_id;
    }

    public void setUser_id(Long user_id) {

        this.user_id = user_id;
    }

    public String getFirst_name() {

        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getManager_id() {
        return manager_id;
    }

    public void setManager_id(User manager_id) {
        this.manager_id = manager_id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }



}

