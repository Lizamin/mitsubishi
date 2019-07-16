package com.umfg.mitsubishi.persistence.repo;

import com.umfg.mitsubishi.persistence.entity.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QualifierRepo extends JpaRepository<Qualifier, Integer> {

    Optional<Qualifier> getByQualifier(String qualifier);
}
