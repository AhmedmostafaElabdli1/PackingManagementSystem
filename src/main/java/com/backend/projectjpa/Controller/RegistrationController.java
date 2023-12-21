package com.backend.projectjpa.Controller;

import com.backend.projectjpa.DTO.UserRegistrationRequest;
import com.backend.projectjpa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class RegistrationController {

    @Autowired
    private UserService userService;


//    @GetMapping("/error")  // Add this mapping
//    public String handleError() {
//        // Your error handling logic here
//        return "error"; // Return the name of your error page
//    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        userService.registerUser(registrationRequest);
        return ResponseEntity.ok("User registration successful");
    }

}
