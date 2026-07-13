package com.alm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RiskMetric {
    private int metricId;
    private Integer scenarioId; // nullable
    private LocalDate reportingDate;
    private BigDecimal totalAssets;
    private BigDecimal totalLiabilities;
    private BigDecimal netInterestIncome;
    private BigDecimal liquidityRatio;
    private BigDecimal durationGap;
    private BigDecimal creditRiskScore;

    public RiskMetric() {}

    public RiskMetric(int metricId, Integer scenarioId, LocalDate reportingDate, BigDecimal totalAssets,
                      BigDecimal totalLiabilities, BigDecimal netInterestIncome, BigDecimal liquidityRatio,
                      BigDecimal durationGap, BigDecimal creditRiskScore) {
        this.metricId = metricId;
        this.scenarioId = scenarioId;
        this.reportingDate = reportingDate;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.netInterestIncome = netInterestIncome;
        this.liquidityRatio = liquidityRatio;
        this.durationGap = durationGap;
        this.creditRiskScore = creditRiskScore;
    }

    public int getMetricId() {
        return metricId;
    }

    public void setMetricId(int metricId) {
        this.metricId = metricId;
    }

    public Integer getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(Integer scenarioId) {
        this.scenarioId = scenarioId;
    }

    public LocalDate getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(LocalDate reportingDate) {
        this.reportingDate = reportingDate;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(BigDecimal totalAssets) {
        this.totalAssets = totalAssets;
    }

    public BigDecimal getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(BigDecimal totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public BigDecimal getNetInterestIncome() {
        return netInterestIncome;
    }

    public void setNetInterestIncome(BigDecimal netInterestIncome) {
        this.netInterestIncome = netInterestIncome;
    }

    public BigDecimal getLiquidityRatio() {
        return liquidityRatio;
    }

    public void setLiquidityRatio(BigDecimal liquidityRatio) {
        this.liquidityRatio = liquidityRatio;
    }

    public BigDecimal getDurationGap() {
        return durationGap;
    }

    public void setDurationGap(BigDecimal durationGap) {
        this.durationGap = durationGap;
    }

    public BigDecimal getCreditRiskScore() {
        return creditRiskScore;
    }

    public void setCreditRiskScore(BigDecimal creditRiskScore) {
        this.creditRiskScore = creditRiskScore;
    }

    @Override
    public String toString() {
        return "RiskMetric{" +
                "metricId=" + metricId +
                ", scenarioId=" + scenarioId +
                ", reportingDate=" + reportingDate +
                ", totalAssets=" + totalAssets +
                ", totalLiabilities=" + totalLiabilities +
                ", netInterestIncome=" + netInterestIncome +
                ", liquidityRatio=" + liquidityRatio +
                ", durationGap=" + durationGap +
                ", creditRiskScore=" + creditRiskScore +
                '}';
    }
}
