package com.springprectice.Spring.Boot.Prectice.service;

import com.springprectice.Spring.Boot.Prectice.repository.DetailRepository;
import com.springprectice.Spring.Boot.Prectice.users.Details;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailService {

    private final DetailRepository detailRepository;
    private final UserService userService;


    public List<Details> getAllDetails() {
        return userService.findByUserId();
    }


    public Details addContent(Details info) {
        return userService.addContent(info);
    }

    public List<Details> removeContent(String cId) {
        return userService.removeContent(cId);
    }

    public Details updateContent(String cId, Details info) {
        return userService.updateContent(cId, info);
    }
}
