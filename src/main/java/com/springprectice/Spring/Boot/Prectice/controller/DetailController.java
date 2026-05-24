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
    @GetMapping("/allinfo")
    public ResponseEntity<List<Details>> getAllDetailByUser() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(detailService.getAllDetails());
    }

   // Information Add By User ID
    @PostMapping("/add")
    public ResponseEntity<Details> addInfo(@RequestBody Details info) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(detailService.addContent(info));
    }

    // Delete Details
    @DeleteMapping("/remove/{cId}")
    public ResponseEntity<List<Details>> removeDelail(
            @PathVariable String cId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(detailService.removeContent(cId));
    }

    // UPDATE CONTENT
    @PutMapping("/update/{cId}")
    public ResponseEntity<Details> updateDetail(
            @PathVariable String cId,
            @RequestBody Details info
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(detailService.updateContent(cId, info));
    }
}
