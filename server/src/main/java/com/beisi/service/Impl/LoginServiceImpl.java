package com.beisi.service.Impl;

import org.springframework.stereotype.Service;

import com.beisi.dto.LoginResponse;
import com.beisi.dto.LoginRequest;
import com.beisi.service.LoginService;
import com.beisi.util.TokenGenerator;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(TokenGenerator.generateToken(loginRequest.getUsername()));
        return loginResponse;
    }
}
