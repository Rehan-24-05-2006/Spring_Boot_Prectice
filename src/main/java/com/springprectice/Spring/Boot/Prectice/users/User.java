package com.springprectice.Spring.Boot.Prectice.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String id;
    private String email;
}
