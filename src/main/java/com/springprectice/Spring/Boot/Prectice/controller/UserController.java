package com.springprectice.Spring.Boot.Prectice.controller;

import com.springprectice.Spring.Boot.Prectice.service.UserService;
import com.springprectice.Spring.Boot.Prectice.users.Details;
import com.springprectice.Spring.Boot.Prectice.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rehan")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.addUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<List<Details>> login(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.loginUser(user));
    }














//
//    @GetMapping("/view")
//    public ResponseEntity<User> getUser() {
//        return ResponseEntity.ok(userService.showUsers());
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<User> setUser(@RequestBody User user) {
//        return ResponseEntity.ok(userService.addUSer(user));
//    }
//
//    @GetMapping("/allusers")
//    public ResponseEntity<UserService> allUsers() {
//        return new ResponseEntity<>(userService, HttpStatus.OK);
//    }
//
//    @GetMapping("/info")
//    public String getInfo(@RequestHeader("User-Agent") String userAgent) {
//        return "User Agent : " + userAgent;
//    }

}
