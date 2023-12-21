package com.backend.projectjpa.Controller;

import com.backend.projectjpa.Entity.User;
import com.backend.projectjpa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @PostMapping("/create")
    public User insert(@RequestBody User user){

        return userService.insert(user);
    }

    @GetMapping("/findAll")
    public List<User> findAll(){

        return userService.findAll();
    }
    @GetMapping("/findById")
    public User findById(@RequestParam Long user_id){

        return userService.findById(user_id);
    }



    @GetMapping("/findByNid")
    public User findByNid(@RequestParam String nid){
        return userService.findByNid(nid);
    }
//    public User findById(@RequestBody Map<String, Long> requestBody) {
//        Long userId = requestBody.get("user_id");
//        return userService.findById(userId);
//    }
        @GetMapping("/findByFirstAndLastName")
        public List<User> findByFirst_nameAndLast_name(@RequestParam String first_name ,@RequestParam String last_name ){

            return userService.findByFirst_nameAndLast_name(first_name,last_name);
        }



    @PutMapping("/update")
    public User updateSalary(@RequestBody User user){

        return userService.update(user);

    }



    @PutMapping("/updateSalary")
    public User updateSalary(@RequestParam String nid,@RequestParam double salary){
        return userService.updateSalary(nid,salary);
    }

}
