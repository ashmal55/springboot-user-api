package com.ashmal.user_service.controller;


import com.ashmal.user_service.model.User;
import com.ashmal.user_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "*") // allow all origins (for dev)
@RestController
@RequestMapping("/users")
//@Tag(name = "User API", description = "CRUD operations for users")
public class UserController {

    @Autowired
    private UserService userService;

//    @Operation(summary = "Get all users")
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

//    @Operation(summary = "Create a new user")
    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }

//    @GetMapping("/email")
//    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
//        return userService.getUserByEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }


//    @Operation(summary = "Get user by email")
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//    @Operation(summary = "Get user by id")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//    @Operation(summary = "Update user by ID")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid User updatedUser) {
        return userService.updateUserById(id, updatedUser).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().<User>build());
    }


//    @Operation(summary = "Delete user by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        if(userService.deleteUser(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
