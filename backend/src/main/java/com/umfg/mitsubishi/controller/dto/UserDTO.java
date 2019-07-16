package com.umfg.mitsubishi.controller.dto;

import com.umfg.mitsubishi.persistence.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement
@Data
public class UserDTO {

    private int id;
    private String name;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserDTO from(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setAuthorities(user.getAuthorities());
        return dto;
    }
}
