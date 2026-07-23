package com.alm.controller;

import com.alm.model.RiskMetric;
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
@RequestMapping("/api/risk-metrics")
public class RiskMetricRestController {
    private final RiskMetricController riskMetricDao;

    public RiskMetricRestController(RiskMetricController riskMetricDao) {
        this.riskMetricDao = riskMetricDao;
    }

    @GetMapping
    public List<RiskMetric> findAll(@RequestParam(required = false) Integer scenarioId) throws SQLException {
        if (scenarioId != null) {
            return riskMetricDao.findByScenarioId(scenarioId);
        }
        return riskMetricDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskMetric> findById(@PathVariable int id) throws SQLException {
        return riskMetricDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RiskMetric> create(@RequestBody RiskMetric riskMetric) throws SQLException {
        riskMetricDao.create(riskMetric);
        return ResponseEntity.status(201).body(riskMetric);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskMetric> update(@PathVariable int id, @RequestBody RiskMetric riskMetric) throws SQLException {
        riskMetric.setMetricId(id);
        return riskMetricDao.update(riskMetric)
                ? ResponseEntity.ok(riskMetric)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws SQLException {
        return riskMetricDao.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
