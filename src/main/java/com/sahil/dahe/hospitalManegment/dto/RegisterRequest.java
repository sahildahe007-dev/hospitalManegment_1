package com.sahil.dahe.hospitalManegment.dto;

import com.sahil.dahe.hospitalManegment.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String username;
    private String email;
    private String password;
    private Role role;

}