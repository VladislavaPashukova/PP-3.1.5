package ru.javamentor.springmvchibernate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.springmvchibernate.model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @GetMapping("/allUser")
    public ResponseEntity<User> getAuthenticationUser(Authentication auth) {
        return new ResponseEntity<>((User) auth.getPrincipal(), HttpStatus.OK);
    }
}
