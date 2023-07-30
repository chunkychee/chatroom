package com.example.chatserver.controller;

import com.example.chatserver.model.ChatDB;
import com.example.chatserver.view.UserDetails;
import com.example.chatserver.view.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000") // Add this line to enable CORS for all methods in this controller
@RestController
@RequestMapping("/inputdetails")

public class UserDetailsController {

    @Autowired
    private UserService userServiceVar;
    @Autowired
    private ChatDB chatDBvar;

    @GetMapping()
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Backend is running fine");
    }
    @PostMapping("/input")
    public ResponseEntity<UserDetails> CreateNewUser(@RequestBody UserDetails user){
        userServiceVar.createUser(user.getUsername(), user.getEmail(), user.getPassword());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
