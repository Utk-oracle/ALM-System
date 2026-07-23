// src/main/java/com/alm/controller/ReportRestController.java
package com.alm.controller;

import com.alm.model.AlmSummaryReport;
import com.alm.service.ReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/reports")
public class ReportRestController {

    private final ReportService reportService;

    public ReportRestController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/alm-summary")
    public AlmSummaryReport getAlmSummary() throws SQLException {
        return reportService.createAlmSummary();
    }

    @GetMapping(value = "/alm-summary.pdf",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> downloadAlmSummaryPdf(
            @RequestParam(required = false) Integer generatedBy)
            throws SQLException, IOException {

        byte[] pdf = reportService.generateAlmSummaryPdf(generatedBy);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=alm-summary.pdf")
                .body(pdf);
    }
}
