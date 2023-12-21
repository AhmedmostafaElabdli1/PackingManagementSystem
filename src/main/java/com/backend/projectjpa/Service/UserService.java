package com.backend.projectjpa.Service;

import com.backend.projectjpa.DTO.UserRegistrationRequest;
import com.backend.projectjpa.Entity.User;
import com.backend.projectjpa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository ;

    private final static String USER_NOT_FOUND ="user with username %s not found";
    public List<User>findAll(){

        return userRepository.findAll();
    }


    public User findById(Long id ){

        return userRepository.findById(id).orElseThrow();
    }
    public User findByNid(String nid ){

        return userRepository.findByNid(nid);
    }
    public List<User> findByFirst_nameAndLast_name(String firstname ,String lastname ){

        return userRepository.findByFirst_nameAndLast_name(firstname,lastname);
    }

    public User insert(User user){
        return userRepository.save(user);
    }
    public User update(User user){

        return  userRepository.save(user);
    }

    public User updateSalary(String nid , double salary){
        User user = userRepository.findByNid(nid);
        user.setSalary(salary);
        return  userRepository.save(user);
    }
//    public User updateSalaryByNid(String nid , double salary){
//        User user = userRepository.findByNid(nid);
//        user.setSalary(salary);
//        return  userRepository.save(user);
//    }
    public void delete(User user){
        userRepository.delete(user);

    }

    public void deleteAll(){
        userRepository.deleteAll();
    }


    public void registerUser(UserRegistrationRequest registrationRequest) {
        // Map attributes from UserRegistrationRequest to User entity
        User user = new User();

        if (findByNid(registrationRequest.getNid()) ==null) {


            user.setFirst_name(registrationRequest.getFirstName());
            user.setLast_name(registrationRequest.getLastName());
            user.setNid(registrationRequest.getNid());
            user.setUser_type(registrationRequest.getUserType());
            user.setAge(registrationRequest.getAge());
            user.setPhone(registrationRequest.getPhone());
            user.setAddress(registrationRequest.getAddress());
            user.setUser_name(registrationRequest.getUserName());


            // Save the user to the database
            userRepository.save(user);
        }
    }

}
