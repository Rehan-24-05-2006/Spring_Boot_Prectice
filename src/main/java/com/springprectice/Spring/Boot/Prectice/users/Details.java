package com.springprectice.Spring.Boot.Prectice.users;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "userDetails")
public class Details {

    @Id
    private String id;

    private String title;
    private String content;
}
