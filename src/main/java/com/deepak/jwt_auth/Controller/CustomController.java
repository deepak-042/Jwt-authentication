package com.deepak.jwt_auth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomController {
    @GetMapping
    public String get(){
        return "/welcome to session";
    }
}
