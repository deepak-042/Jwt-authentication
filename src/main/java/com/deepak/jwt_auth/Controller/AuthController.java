package com.deepak.jwt_auth.Controller;

import com.deepak.jwt_auth.Components.JwtUtil;
import com.deepak.jwt_auth.Dto.AuthRequest;
import com.deepak.jwt_auth.Dto.AuthResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;

    public AuthController(JwtUtil jwtUtil,  AuthenticationManager authManager) {
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;

    }

    @PostMapping("/authenticate")
    public AuthResponse createToken(@RequestBody AuthRequest request){
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword())
        );
        String jwtToken = jwtUtil.generateToken(request.getUsername());
        return new AuthResponse(jwtToken);
    }
}
