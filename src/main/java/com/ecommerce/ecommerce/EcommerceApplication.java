package com.ecommerce.ecommerce;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

    @Bean
    CommandLineRunner run(UserRepository userRepository) {
        return args -> {
            User user = new User();
            user.setEmail("karim@example.com");
            user.setPassword("123456");
            user.setRole("USER");

            userRepository.save(user);
            System.out.println("User saved: " + user.getEmail());
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

}
