package com.example.project1.controller;

import com.example.project1.dto.UserDTO;
import com.example.project1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser(){

        return userService.getAllUsers();
    }


    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
       return userService.saveUser(userDTO);
    }
    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }


    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);

    }
    @GetMapping("/getUserByUserId/{userID}")
        public UserDTO getUserByUserId(@PathVariable String userID){
        return userService.getUserById(userID);
    }

    @GetMapping("/getUserByIdAndAddress/{userID}/{address}")
        public UserDTO getUserByIdAndAddress(@PathVariable String userID,@PathVariable String address){
        return userService.getUserByIdAndAddress(userID,address);
    }
}
