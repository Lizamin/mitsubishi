package com.umfg.mitsubishi.persistence;

import com.umfg.mitsubishi.persistence.entity.Qualifier;
import com.umfg.mitsubishi.persistence.repo.QualifierRepo;
import com.umfg.mitsubishi.persistence.repo.RoleRepo;
import com.umfg.mitsubishi.persistence.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.umfg.mitsubishi.security.SecurityConstants.ADMIN_ROLE;
import static com.umfg.mitsubishi.security.SecurityConstants.USER_ROLE;

@Component
@RequiredArgsConstructor(onConstructor = @___(@Autowired))
public class Initializer {

    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final QualifierRepo qualifierRepo;

    @PostConstruct
    public void init(){
        roleRepo.save(USER_ROLE);
        roleRepo.save(ADMIN_ROLE);
        qualifierRepo.save(new Qualifier(1, "home"));
        qualifierRepo.save(new Qualifier(2, "l200"));
        qualifierRepo.save(new Qualifier(3, "eclipse"));
        qualifierRepo.save(new Qualifier(4, "asx"));
        qualifierRepo.save(new Qualifier(5, "outlander"));
        qualifierRepo.save(new Qualifier(6, "pajerosport"));
        qualifierRepo.save(new Qualifier(7, "pajero"));
    }
}
