package com.ghip.aaa.endpoint;

import com.ghip.aaa.domain.Asset;
import com.ghip.aaa.exceptions.ObjectFoundException;
import com.ghip.aaa.repository.AssetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {
    private AssetRepository assetRepository;

    public AssetController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @PostMapping
    public void addAsset(@RequestBody Asset asset) {
        assetRepository.save(asset);
    }

    @GetMapping
    public List<Asset> getAssets() {
        return assetRepository.findByEnabled(true);
    }

    @PutMapping("/{id}")
    public void editRole(@PathVariable long id, Asset asset) {
        Asset existingAsset = assetRepository.findOne(id);
        if(asset == null)
            throw new ObjectFoundException("Asset "+ id + " not found");
        existingAsset.setName(asset.getName());
        existingAsset.setAuthorities(asset.getAuthorities());
        assetRepository.save(existingAsset);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        Asset asset = assetRepository.findOne(id);
        if(asset == null)
            throw new ObjectFoundException("Asset "+ id + " not found");
        asset.setEnabled(false);
        assetRepository.save(asset);
    }

}
