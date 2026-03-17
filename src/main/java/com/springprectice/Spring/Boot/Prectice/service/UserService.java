package com.springprectice.Spring.Boot.Prectice.service;

import com.springprectice.Spring.Boot.Prectice.users.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User showUsers() {
        return new User("Rehan", "3271", "rehan@gmail.com");
    }
}
