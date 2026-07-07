package com.matusalenalves.course.resources;

import com.matusalenalves.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/users")
public class UserResources {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria", "maria@gmail.com", "(86) 99445-3829","@Ads2005");
        return ResponseEntity.ok().body(u);
    }
}