package com.springprectice.Spring.Boot.Prectice.controller;

import com.springprectice.Spring.Boot.Prectice.service.DetailService;
import com.springprectice.Spring.Boot.Prectice.users.Details;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user/details")
public class DetailController {

    private final DetailService detailService;

    //Get Add Details show of particular User
    @GetMapping("/allinfo/{userId}")
    public ResponseEntity<List<Details>> getAllDetailByUser(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(detailService.getAllDetails(userId));
    }

//    // Information Add By User ID
    @PostMapping("/add/{id}")
    public ResponseEntity<Details> addInfo(
            @PathVariable String id,
            @RequestBody Details info) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(detailService.addContent(id, info));
    }

}
