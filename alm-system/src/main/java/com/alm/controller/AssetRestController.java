package com.alm.controller;

import com.alm.model.Asset;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetRestController {
    private final AssetController assetDao;

    public AssetRestController(AssetController assetDao) {
        this.assetDao = assetDao;
    }

    @GetMapping
    public List<Asset> findAll(@RequestParam(required = false) String status,
                               @RequestParam(required = false) String type) throws SQLException {
        if (status != null) {
            return assetDao.findByStatus(status);
        }
        if (type != null) {
            return assetDao.findByType(type);
        }
        return assetDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> findById(@PathVariable int id) throws SQLException {
        return assetDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asset> create(@RequestBody Asset asset) throws SQLException {
        assetDao.create(asset);
        System.out.println("success");
        return ResponseEntity.status(201).body(asset);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asset> update(@PathVariable int id, @RequestBody Asset asset) throws SQLException {
        asset.setAssetId(id);
        return assetDao.update(asset)
                ? ResponseEntity.ok(asset)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws SQLException {
        return assetDao.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}