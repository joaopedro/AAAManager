package com.ghip.aaa.repository;

import com.ghip.aaa.domain.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByEnabled(boolean enabled);
}
