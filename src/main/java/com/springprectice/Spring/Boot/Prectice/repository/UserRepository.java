package com.springprectice.Spring.Boot.Prectice.repository;

import com.springprectice.Spring.Boot.Prectice.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Boolean existsByEmail(String email);

    User findByEmail(String email);
}
