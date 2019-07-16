package com.umfg.mitsubishi.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthorizationDTO {

    private String token;
    private List<String> roles;
}
