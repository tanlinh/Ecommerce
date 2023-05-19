package com.ecommerce.service;

import com.ecommerce.dto.request.LoginRequest;
import com.ecommerce.dto.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface Authentication {

    LoginResponse authentication(LoginRequest loginRequest) throws Exception;
}
