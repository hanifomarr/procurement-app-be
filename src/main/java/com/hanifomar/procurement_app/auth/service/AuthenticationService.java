package com.hanifomar.procurement_app.auth.service;

import com.hanifomar.procurement_app.auth.dto.SignUpRequestDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    UserDetails authenticate(String email, String password);

    String generateToken(UserDetails userDetails);

    UserDetails validateToken(String token);

    UserDetails signup(SignUpRequestDto signUpRequestDto);

}
