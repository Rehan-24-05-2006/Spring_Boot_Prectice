package com.springprectice.Spring.Boot.Prectice.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "userDetails")
public class Details {

    @Id
    private String id;

    private String userId;
    private String title;
    private String content;
}
