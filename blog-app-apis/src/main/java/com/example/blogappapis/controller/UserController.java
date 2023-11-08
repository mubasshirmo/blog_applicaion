package com.example.blogappapis.controller;

import com.example.blogappapis.payloads.ApiResponse;
import com.example.blogappapis.payloads.UserDto;
import com.example.blogappapis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
     private UserService userService;
    //POST -create User
   @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto userDto){
       UserDto createUserDto=this.userService.createUser(userDto);
       return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
   }
    //PUT
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer userId){
       UserDto updatedUser=this.userService.updateUser(userDto,userId);
        return ResponseEntity.ok(updatedUser);
   }

    //DELETE
       @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
       this.userService.deleteUser(userId);
       return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully ",true),HttpStatus.OK);
       }
    //GET
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
       return  ResponseEntity.ok(this.userService.getAllUsers());
    }
    //GEt by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
       return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
