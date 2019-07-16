package com.umfg.mitsubishi.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    private @NonNull Integer id;

    @Column
    private @NonNull String role;

    public GrantedAuthority getAuthority(){
        return new SimpleGrantedAuthority(role);
    }
}