package com.webservice.mongo.web.service.mongo.config;

import com.webservice.mongo.web.service.mongo.domain.User;
import com.webservice.mongo.web.service.mongo.repository.UserRepository;
import com.webservice.mongo.web.service.mongo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserServices userServices;

    @Override
    public void run(String... args) throws Exception {

        userRepo.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepo.saveAll(Arrays.asList(maria, alex, bob));

    }
}
