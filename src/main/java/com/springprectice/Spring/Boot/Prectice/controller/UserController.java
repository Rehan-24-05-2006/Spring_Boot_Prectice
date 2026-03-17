package com.springprectice.Spring.Boot.Prectice.controller;

import com.springprectice.Spring.Boot.Prectice.service.UserService;
import com.springprectice.Spring.Boot.Prectice.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/view")
    public ResponseEntity<User> getUsers() {
        return ResponseEntity.ok(userService.showUsers());
    }
}
