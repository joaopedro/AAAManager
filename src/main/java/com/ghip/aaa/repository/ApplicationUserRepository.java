package com.ghip.aaa.repository;

import com.ghip.aaa.domain.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, String> {
    ApplicationUser findByUsername(String username);
}