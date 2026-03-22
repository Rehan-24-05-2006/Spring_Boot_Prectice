package com.springprectice.Spring.Boot.Prectice.repository;

import com.springprectice.Spring.Boot.Prectice.users.Details;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends MongoRepository<Details, String> {
}
