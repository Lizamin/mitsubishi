package com.umfg.mitsubishi.service;

import com.umfg.mitsubishi.persistence.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MitsubishiUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    @Autowired
    public MitsubishiUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByName(s).orElseThrow(() -> new UsernameNotFoundException(s + " not found"));
    }

}
