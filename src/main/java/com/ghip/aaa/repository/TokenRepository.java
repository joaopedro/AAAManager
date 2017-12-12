package com.ghip.aaa.repository;

import com.ghip.aaa.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jpedro on 11/12/2017.
 */
public interface TokenRepository extends JpaRepository<Token, String> {
}
