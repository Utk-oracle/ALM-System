package com.alm.controller;

import com.alm.model.ReportHistory;
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
@RequestMapping("/api/report-history")
public class ReportHistoryRestController {
    private final ReportHistoryController reportHistoryDao;

    public ReportHistoryRestController(ReportHistoryController reportHistoryDao) {
        this.reportHistoryDao = reportHistoryDao;
    }

    @GetMapping
    public List<ReportHistory> findAll(@RequestParam(required = false) Integer generatedBy) throws SQLException {
        if (generatedBy != null) {
            return reportHistoryDao.findByGeneratedBy(generatedBy);
        }
        return reportHistoryDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportHistory> findById(@PathVariable int id) throws SQLException {
        return reportHistoryDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReportHistory> create(@RequestBody ReportHistory reportHistory) throws SQLException {
        reportHistoryDao.create(reportHistory);
        return ResponseEntity.status(201).body(reportHistory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportHistory> update(@PathVariable int id, @RequestBody ReportHistory reportHistory) throws SQLException {
        reportHistory.setReportId(id);
        return reportHistoryDao.update(reportHistory)
                ? ResponseEntity.ok(reportHistory)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws SQLException {
        return reportHistoryDao.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
