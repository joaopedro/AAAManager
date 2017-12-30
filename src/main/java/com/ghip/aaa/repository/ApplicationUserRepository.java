package com.ghip.aaa.repository;

import com.ghip.aaa.domain.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, String> {
    ApplicationUser findByUsername(String username);

    List<ApplicationUser> findByEnabled(boolean enabled);
}