package com.webservice.mongo.web.service.mongo.services;

import com.webservice.mongo.web.service.mongo.domain.User;
import com.webservice.mongo.web.service.mongo.exception.ObjectNotFoundException;
import com.webservice.mongo.web.service.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
       return userRepository.findAll();
    }

    @Transactional
    public User intoUser(User user){
        User into = userRepository.insert(user);
        return into;
    }

    public User findId(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Codigo de usuario não encontrado"));

    }

}
