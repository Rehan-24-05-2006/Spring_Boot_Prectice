package com.springprectice.Spring.Boot.Prectice.config;

import com.springprectice.Spring.Boot.Prectice.repository.UserRepository;
import com.springprectice.Spring.Boot.Prectice.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class TransactionConfig {

    @Bean
    public PlatformTransactionManager falana(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

}
