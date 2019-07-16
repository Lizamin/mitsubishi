package com.umfg.mitsubishi.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRegistrationForm {

    @NotBlank(message = "{userregform.name.empty}")
    @Size(min = 3, max = 24, message = "{userregform.name.size}")
    private String name;

    @NotBlank(message = "{userregform.password.empty}")
    @Size(min = 8, max = 64, message = "{userregform.password.size}")
    private String password;

}
