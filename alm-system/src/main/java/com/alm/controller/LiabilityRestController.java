package com.alm.controller;

import com.alm.model.Liability;
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
@RequestMapping("/api/liabilities")
public class LiabilityRestController {
    private final LiabilityController liabilityDao;

    public LiabilityRestController(LiabilityController liabilityDao) {
        this.liabilityDao = liabilityDao;
    }

    @GetMapping
    public List<Liability> findAll(@RequestParam(required = false) String status,
                                   @RequestParam(required = false) String type) throws SQLException {
        if (status != null) {
            return liabilityDao.findByStatus(status);
        }
        if (type != null) {
            return liabilityDao.findByType(type);
        }
        return liabilityDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Liability> findById(@PathVariable int id) throws SQLException {
        return liabilityDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Liability> create(@RequestBody Liability liability) throws SQLException {
        liabilityDao.create(liability);
        return ResponseEntity.status(201).body(liability);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Liability> update(@PathVariable int id, @RequestBody Liability liability) throws SQLException {
        liability.setLiabilityId(id);
        return liabilityDao.update(liability)
                ? ResponseEntity.ok(liability)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws SQLException {
        return liabilityDao.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
