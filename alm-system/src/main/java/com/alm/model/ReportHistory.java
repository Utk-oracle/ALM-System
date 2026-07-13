package com.alm.model;

import java.time.LocalDateTime;

public class ReportHistory {
    private int reportId;
    private String reportName;
    private String reportType;
    private LocalDateTime generatedOn;
    private Integer generatedBy; // user id nullable
    private String summary;

    public ReportHistory() {}

    public ReportHistory(int reportId, String reportName, String reportType,
                         LocalDateTime generatedOn, Integer generatedBy, String summary) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportType = reportType;
        this.generatedOn = generatedOn;
        this.generatedBy = generatedBy;
        this.summary = summary;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDateTime getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(LocalDateTime generatedOn) {
        this.generatedOn = generatedOn;
    }

    public Integer getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Integer generatedBy) {
        this.generatedBy = generatedBy;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "ReportHistory{" +
                "reportId=" + reportId +
                ", reportName='" + reportName + '\'' +
                ", reportType='" + reportType + '\'' +
                ", generatedOn=" + generatedOn +
                ", generatedBy=" + generatedBy +
                ", summary='" + summary + '\'' +
                '}';
    }
}
