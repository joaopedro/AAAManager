package com.ghip.aaa.repository;

import com.ghip.aaa.domain.ApplicationUser;
import com.ghip.aaa.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByName(String username);
    List<Authority> findByEnabled(boolean enabled);

}