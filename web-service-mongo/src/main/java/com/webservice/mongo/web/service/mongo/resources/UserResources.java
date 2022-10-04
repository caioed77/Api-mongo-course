package com.webservice.mongo.web.service.mongo.resources;


import com.webservice.mongo.web.service.mongo.domain.User;
import com.webservice.mongo.web.service.mongo.domain.dto.UserDTO;
import com.webservice.mongo.web.service.mongo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user){
        return ResponseEntity.ok().body(userServices.intoUser(user));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
         User userId = userServices.findId(id);
        return ResponseEntity.ok().body(new UserDTO(userId));

    }

}
