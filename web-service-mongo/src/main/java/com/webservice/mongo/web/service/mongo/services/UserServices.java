package com.webservice.mongo.web.service.mongo.services;

import com.webservice.mongo.web.service.mongo.domain.User;
import com.webservice.mongo.web.service.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
       return userRepository.findAll();
    }

}
