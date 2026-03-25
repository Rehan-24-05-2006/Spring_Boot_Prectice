package com.springprectice.Spring.Boot.Prectice.service;

import com.springprectice.Spring.Boot.Prectice.repository.DetailRepository;
import com.springprectice.Spring.Boot.Prectice.users.Details;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailService {

    private final DetailRepository detailRepository;
    private final UserService userService;


    public List<Details> getAllDetails(String userId) {
        return userService.findByUserId(userId);
    }


    public Details addContent(String id, Details info) {
        return userService.addContent(id, info);
    }

    public List<Details> removeContent(String userId, String cId) {
        return userService.removeContent(userId, cId);
    }

    public Details updateContent(String cId, Details info) {
        return userService.updateContent(cId, info);
    }
}
