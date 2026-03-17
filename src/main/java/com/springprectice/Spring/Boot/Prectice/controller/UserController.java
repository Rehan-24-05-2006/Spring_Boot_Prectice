package com.springprectice.Spring.Boot.Prectice.controller;

import com.springprectice.Spring.Boot.Prectice.service.UserService;
import com.springprectice.Spring.Boot.Prectice.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/view")
    public ResponseEntity<User> getUser() {
        return ResponseEntity.ok(userService.showUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<User> setUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUSer(user));
    }

    @GetMapping("/allusers")
    public ResponseEntity<UserService> allUsers() {
        return new ResponseEntity<>(userService, HttpStatus.OK);
    }
}
