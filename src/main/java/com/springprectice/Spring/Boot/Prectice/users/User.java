package com.springprectice.Spring.Boot.Prectice.users;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document(collection = "userData")
public class User {

    @Id
    private String id;

    @NotNull
    private String name;

    @Indexed(unique = true)
    @NotNull
    private String email;

    @NotNull
    private String password;

    @DBRef
    private List<Details> details = new ArrayList<>();
}
