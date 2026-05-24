package com.springprectice.Spring.Boot.Prectice.service;

import com.springprectice.Spring.Boot.Prectice.repository.UserRepository;
import com.springprectice.Spring.Boot.Prectice.users.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Disabled
    @Test
    public void testfindByUser() {
        assertNotNull(userRepository.findByEmail("karan@gmail.com"));
    }

    @Disabled
    @Test
    public void testExistByEmail() {
        assertNotEquals(false, userRepository.existsByEmail("mrrkhan067@gmail.com"));
    }


    @ParameterizedTest
    @CsvSource({
            "mrrkhan067@gmail.com",
            "fejan@gmail.com",
            "karan@gmail.com"
    })
    public void testExistByDetails(String name) {
        assertNotNull(userRepository.findByEmail(name));
    }

    

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,2,4",
            "5,10,15"
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }
}
