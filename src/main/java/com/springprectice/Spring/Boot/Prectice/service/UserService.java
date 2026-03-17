package com.springprectice.Spring.Boot.Prectice.service;

import com.springprectice.Spring.Boot.Prectice.users.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    Map<String, User> map = new HashMap<>();

    public User showUsers() {
        return new User("Rehan", "3271", "rehan@gmail.com");
    }

    public User addUSer(User user) {
        map.put(user.getId(), user);
        return new User();
    }


}
