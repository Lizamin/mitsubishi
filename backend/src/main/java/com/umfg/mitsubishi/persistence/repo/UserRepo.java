package com.umfg.mitsubishi.persistence.repo;

import com.umfg.mitsubishi.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);

}
