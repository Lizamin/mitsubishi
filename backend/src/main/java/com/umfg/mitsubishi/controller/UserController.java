package com.umfg.mitsubishi.controller;

import com.umfg.mitsubishi.controller.dto.UserDTO;
import com.umfg.mitsubishi.form.UserRegistrationForm;
import com.umfg.mitsubishi.persistence.entity.User;
import com.umfg.mitsubishi.persistence.repo.RoleRepo;
import com.umfg.mitsubishi.persistence.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(value = "/api/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserRegistrationForm userRegistrationForm) {
        User user = new User(userRegistrationForm.getName(),
                         passwordEncoder.encode(userRegistrationForm.getPassword()));
        if (userRepo.findByName(user.getName())
                    .isPresent()) {
            return ResponseEntity.badRequest()
                                 .body(null);
        } else {
            userRepo.save(user);
            return ResponseEntity.created(null)
                                 .body(UserDTO.from(user));
        }
    }
}
