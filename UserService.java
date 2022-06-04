package com.example.project1.service;

import com.example.project1.dto.UserDTO;
import com.example.project1.entity.User;
import com.example.project1.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    public ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;

    }
    public List<UserDTO> getAllUsers(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }
    public UserDTO getUserById(String userId){
        User user = userRepo.getUserByUserId(userId);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO getUserByIdAndAddress(String userId, String address){
        User user = userRepo.getUserByIdAndAddress(userId, address);
        return modelMapper.map(user, UserDTO.class);
    }
}
