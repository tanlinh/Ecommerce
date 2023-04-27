package com.ecommerce.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {
    private String fullName;
    private String username;
    private String password;
}
