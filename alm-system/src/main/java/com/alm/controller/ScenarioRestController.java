package com.alm.controller;

import com.alm.model.Scenario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/scenarios")
public class ScenarioRestController {
    private final ScenarioController scenarioDao;

    public ScenarioRestController(ScenarioController scenarioDao) {
        this.scenarioDao = scenarioDao;
    }

    @GetMapping
    public List<Scenario> findAll() throws SQLException {
        return scenarioDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scenario> findById(@PathVariable int id) throws SQLException {
        return scenarioDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Scenario> create(@RequestBody Scenario scenario) throws SQLException {
        scenarioDao.create(scenario);
        return ResponseEntity.status(201).body(scenario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scenario> update(@PathVariable int id, @RequestBody Scenario scenario) throws SQLException {
        scenario.setScenarioId(id);
        return scenarioDao.update(scenario)
                ? ResponseEntity.ok(scenario)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws SQLException {
        return scenarioDao.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
