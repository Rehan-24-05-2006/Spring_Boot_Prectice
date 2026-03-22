package com.springprectice.Spring.Boot.Prectice.service;

import com.springprectice.Spring.Boot.Prectice.repository.DetailRepository;
import com.springprectice.Spring.Boot.Prectice.repository.UserRepository;
import com.springprectice.Spring.Boot.Prectice.users.Details;
import com.springprectice.Spring.Boot.Prectice.users.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DetailRepository detailRepository;

    // Register User
    public User addUser(User user) {

        Boolean res = userRepository.existsByEmail(user.getEmail());
        if (res)
            throw new RuntimeException("User All Ready Exist, Please Enter Another User/Email");
        return userRepository.save(user);
    }


    // Login User
    public List<Details> loginUser(@RequestBody User user) {

        User existUser = userRepository.findByEmail(user.getEmail());

        if (existUser != null &&
                existUser.getPassword().equals(user.getPassword())) {

            List<Details> allByUserId =  detailRepository.findAllByUserId(existUser.getId());
            return allByUserId;
        }
        throw new RuntimeException("User Not Found");
    }


//    Map<String, User> map = new HashMap<>();
//
//    public User showUsers() {
//        return new User("Rehan", "3271", "rehan@gmail.com");
//    }
//
//    public User addUSer(User user) {
//        map.put(user.getId(), user);
//        return new User();
//    }


}
