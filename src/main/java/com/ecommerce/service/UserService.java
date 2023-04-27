package com.ecommerce.service;

import com.ecommerce.dto.request.RegistrationRequest;
import com.ecommerce.entity.User;

public interface UserService {

    User getUserById(Long id);

    User getUserByUsername(String username);

    User addUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    User register(RegistrationRequest registrationRequest);
}
