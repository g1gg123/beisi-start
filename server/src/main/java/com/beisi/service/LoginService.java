package com.beisi.service;

import com.beisi.dto.LoginRequest;
import com.beisi.dto.LoginResponse;

public interface LoginService {
    //用户登录
    LoginResponse login(LoginRequest loginRequest);
}