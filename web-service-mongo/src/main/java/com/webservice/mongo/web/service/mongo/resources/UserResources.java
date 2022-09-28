package com.webservice.mongo.web.service.mongo.resources;


import com.webservice.mongo.web.service.mongo.domain.User;
import com.webservice.mongo.web.service.mongo.domain.dto.UserDTO;
import com.webservice.mongo.web.service.mongo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userServices.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

}