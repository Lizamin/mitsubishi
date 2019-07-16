package com.umfg.mitsubishi.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.umfg.mitsubishi.security.SecurityConstants.ADMIN_ROLE;
import static com.umfg.mitsubishi.security.SecurityConstants.USER_ROLE;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_entity")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String passwordHash;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public User(String name, String passwordHash) {
        this.name = name;
        this.passwordHash = passwordHash;
        if (name.equals("admin")) {
            this.roles = new ArrayList<>(Arrays.asList(ADMIN_ROLE, USER_ROLE));
        } else {
            this.roles = new ArrayList<>(Collections.singletonList(USER_ROLE));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                    .map(Role::getAuthority)
                    .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
