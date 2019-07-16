package com.umfg.mitsubishi.model;

import com.umfg.mitsubishi.persistence.entity.User;
import com.umfg.mitsubishi.persistence.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class SecurityContext {

    private final UserRepo userRepo;

    @Autowired
    public SecurityContext(UserRepo userRepo) {this.userRepo = userRepo;}

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userRepo.findByName(userDetails.getUsername()).orElseThrow(EntityNotFoundException::new);
    }
}
