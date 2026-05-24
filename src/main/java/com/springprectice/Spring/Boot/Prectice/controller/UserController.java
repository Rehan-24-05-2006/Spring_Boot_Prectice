package com.springprectice.Spring.Boot.Prectice.controller;

import com.springprectice.Spring.Boot.Prectice.dto.UserUpdateDTO;
import com.springprectice.Spring.Boot.Prectice.service.UserService;
import com.springprectice.Spring.Boot.Prectice.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateDTO user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }
}
