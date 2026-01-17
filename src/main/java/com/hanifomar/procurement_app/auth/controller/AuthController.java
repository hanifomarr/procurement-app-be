package com.hanifomar.procurement_app.auth.controller;

import com.hanifomar.procurement_app.auth.dto.AuthResponseDto;
import com.hanifomar.procurement_app.auth.dto.LoginRequestDto;
import com.hanifomar.procurement_app.auth.dto.SignUpRequestDto;
import com.hanifomar.procurement_app.auth.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        UserDetails userDetails = authenticationService
                .authenticate(loginRequestDto.getEmail(), loginRequestDto.getPassword());

        AuthResponseDto authResponseDto = AuthResponseDto.builder()
                .token(authenticationService.generateToken(userDetails))
                .expiresIn(86400)
                .build();

        return ResponseEntity.ok(authResponseDto);

    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signup(
            @Valid @RequestBody SignUpRequestDto request) {

        UserDetails userDetails = authenticationService.signup(request);

        String token = authenticationService.generateToken(userDetails);

        AuthResponseDto response = AuthResponseDto.builder()
                .token(token)
                .expiresIn(86400)
                .build();

        return ResponseEntity.status(201).body(response);
    }

}
