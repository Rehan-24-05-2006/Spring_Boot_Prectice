package com.springprectice.Spring.Boot.Prectice.service;

import com.springprectice.Spring.Boot.Prectice.repository.DetailRepository;
import com.springprectice.Spring.Boot.Prectice.repository.UserRepository;
import com.springprectice.Spring.Boot.Prectice.users.Details;
import com.springprectice.Spring.Boot.Prectice.users.User;
import lombok.RequiredArgsConstructor;
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


//     Login User
    public List<Details> loginUser(@RequestBody User user) {
        User existUser = userRepository.findByEmail(user.getEmail());
        if (existUser != null &&
                existUser.getPassword().equals(user.getPassword())) {
            List<Details> list = existUser.getDetails();
            list.stream().forEach(System.out::println);
            return null;
        }
        throw new RuntimeException("User Not Found");
    }

    public List<Details> findByUserId(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new RuntimeException("USER NOT EXIST, pleas find another USER!");
        }
        return user.getDetails();
    }

    public Details addContent(String id, Details info) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.getDetails().add(detailRepository.save(info));
            userRepository.save(user);
            return info;
        }
        throw new RuntimeException("Not Added Your Content");
    }
}
