package com.springprectice.Spring.Boot.Prectice.service;

import com.springprectice.Spring.Boot.Prectice.repository.DetailRepository;
import com.springprectice.Spring.Boot.Prectice.users.Details;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailService {

    private final DetailRepository detailRepository;


    public Details addContent(Details info) {
        Details save = detailRepository.save(info);
        return save;
    }

    public String removeContent(String id) {
        boolean existInfo = detailRepository.existsById(id);

        if (existInfo) {
            detailRepository.deleteById(id);
            return "Delete Successfully";
        }
        return "Not found Content";
    }
}
