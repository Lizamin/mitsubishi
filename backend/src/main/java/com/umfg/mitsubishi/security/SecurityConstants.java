package com.umfg.mitsubishi.security;

import com.umfg.mitsubishi.persistence.entity.Role;

public class SecurityConstants {

    public static final String SECRET = "asfagn3i3wtw3tw3";
    public static final String TOKEN_PREFIX = "";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 864000000L;

    public static Role USER_ROLE = new Role(1, "USER");
    public static Role ADMIN_ROLE = new Role(2, "ADMIN");

}