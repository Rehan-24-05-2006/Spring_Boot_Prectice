package com.springprectice.Spring.Boot.Prectice.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String id;
    private String email;

//    public User(String name, String id, String email) {
//        this.name = name;
//        this.id = id;
//        this.email = email;
//    }
}
