package com.alm.controller;

import com.alm.model.ScenarioResult;
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
@RequestMapping("/api/scenario-results")
public class ScenarioResultRestController {

    private final ScenarioResultController scenarioResultDao;

    public ScenarioResultRestController(ScenarioResultController scenarioResultDao) {
        this.scenarioResultDao = scenarioResultDao;
    }

    @GetMapping
    public List<ScenarioResult> findAll(@RequestParam(required = false) Integer scenarioId) throws SQLException {
        if (scenarioId != null) {
            return scenarioResultDao.findByScenarioId(scenarioId);
        }
        return scenarioResultDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScenarioResult> findById(@PathVariable int id) throws SQLException {
        return scenarioResultDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ScenarioResult> create(@RequestBody ScenarioResult scenarioResult) throws SQLException {
        scenarioResultDao.create(scenarioResult);
        return ResponseEntity.status(201).body(scenarioResult);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScenarioResult> update(@PathVariable int id, @RequestBody ScenarioResult scenarioResult) throws SQLException {
        scenarioResult.setResultId(id);
        return scenarioResultDao.update(scenarioResult)
                ? ResponseEntity.ok(scenarioResult)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws SQLException {
        return scenarioResultDao.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}