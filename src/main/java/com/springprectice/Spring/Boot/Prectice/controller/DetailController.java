package com.springprectice.Spring.Boot.Prectice.controller;

import com.springprectice.Spring.Boot.Prectice.service.DetailService;
import com.springprectice.Spring.Boot.Prectice.users.Details;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user/details")
public class DetailController {

    private final DetailService detailService;

    @PostMapping("/add")
    public ResponseEntity<Details> addInfo(@RequestBody Details info) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(detailService.addContent(info));
    }

    @DeleteMapping("/delete/{contentid}")
    public ResponseEntity<String> removeInfo(@PathVariable String contentid) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(detailService.removeContent(contentid));
    }
}
