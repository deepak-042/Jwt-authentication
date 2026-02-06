package com.deepak.jwt_auth.Service;

import com.deepak.jwt_auth.Repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
