package com.springprectice.Spring.Boot.Prectice.service;

import com.springprectice.Spring.Boot.Prectice.dto.UserUpdateDTO;
import com.springprectice.Spring.Boot.Prectice.repository.DetailRepository;
import com.springprectice.Spring.Boot.Prectice.repository.UserRepository;
import com.springprectice.Spring.Boot.Prectice.users.Details;
import com.springprectice.Spring.Boot.Prectice.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.SequencedCollection;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DetailRepository detailRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email1 = authentication.getName();
        return userRepository.findByEmail(email1);
    }

    // Register User
//    @Transactional
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of("USER"));
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
    public List<Details> findByUserId() {
        User user = authenticatedUser();
        return user.getDetails();
    }

    // Add Content User ID
    public Details addContent(Details info) {
        User user = authenticatedUser();
        user.getDetails().add(detailRepository.save(info));
        userRepository.save(user);
        return info;
    }

    public List<Details> removeContent(String cId) {
        User user = authenticatedUser();
        List<Details> list = user.getDetails().stream().filter(x -> x.equals(cId)).toList();
        if (!list.isEmpty()) {
            user.getDetails().removeIf(x -> x.getId().equals(cId));
            userRepository.save(user);
            detailRepository.deleteById(cId);
            return user.getDetails();
        }
        throw new RuntimeException("User Not found");
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

    public User updateUser(UserUpdateDTO user) {
        User userInDb = authenticatedUser();
        userInDb.setUserName(user.getUserName() != null && !user.getPassword().equals("") ? user.getUserName() : userInDb.getUserName());
        userInDb.setPassword(user.getPassword() != null && !user.getPassword().equals("") ? passwordEncoder.encode(user.getPassword()) : userInDb.getPassword());
        userRepository.save(userInDb);
        return userInDb;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}


