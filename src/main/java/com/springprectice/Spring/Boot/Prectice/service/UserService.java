package com.springprectice.Spring.Boot.Prectice.service;

import com.springprectice.Spring.Boot.Prectice.repository.DetailRepository;
import com.springprectice.Spring.Boot.Prectice.repository.UserRepository;
import com.springprectice.Spring.Boot.Prectice.users.Details;
import com.springprectice.Spring.Boot.Prectice.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DetailRepository detailRepository;

    // Register User
    @Transactional
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
            return existUser.getDetails();
        }
        throw new RuntimeException("User Not Found");
    }

    // Get All Details By User
    public List<Details> findByUserId(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new RuntimeException("USER NOT EXIST, pleas find another USER!");
        }
        return user.getDetails();
    }

    // Add Content User ID
    public Details addContent(String id, Details info) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.getDetails().add(detailRepository.save(info));
            userRepository.save(user);
            return info;
        }
        throw new RuntimeException("Not Added Your Content");
    }

    public List<Details> removeContent(String userId, String cId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.getDetails().removeIf(x -> x.getId().equals(cId));
            userRepository.save(user);
            detailRepository.deleteById(cId);
            return user.getDetails();
        }
        throw new RuntimeException("NOT DELETE CONTENT, please enter another user");
    }

    public Details updateContent(String id, Details info) {
        Details details = detailRepository.findById(id).orElse(null);
        if (details != null) {
            details.setTitle(info.getTitle() != null && !info.getTitle().equals("") ? info.getTitle() : details.getTitle());
            details.setContent(info.getContent() != null && !info.getContent().equals("") ? info.getContent() : details.getContent());
            return detailRepository.save(details);
        }
        throw new RuntimeException("NOT DELETE CONTENT, please enter another user");
    }
}
