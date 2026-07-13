package com.alm.model;

import java.math.BigDecimal;

public class ScenarioResult {
    private int resultId;
    private int scenarioId;
    private String metricName;
    private BigDecimal baselineValue;
    private BigDecimal scenarioValue;
    private BigDecimal impactValue;

    public ScenarioResult() {}

    public ScenarioResult(int resultId, int scenarioId, String metricName, BigDecimal baselineValue,
                          BigDecimal scenarioValue, BigDecimal impactValue) {
        this.resultId = resultId;
        this.scenarioId = scenarioId;
        this.metricName = metricName;
        this.baselineValue = baselineValue;
        this.scenarioValue = scenarioValue;
        this.impactValue = impactValue;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public BigDecimal getBaselineValue() {
        return baselineValue;
    }

    public void setBaselineValue(BigDecimal baselineValue) {
        this.baselineValue = baselineValue;
    }

    public BigDecimal getScenarioValue() {
        return scenarioValue;
    }

    public void setScenarioValue(BigDecimal scenarioValue) {
        this.scenarioValue = scenarioValue;
    }

    public BigDecimal getImpactValue() {
        return impactValue;
    }

    public void setImpactValue(BigDecimal impactValue) {
        this.impactValue = impactValue;
    }

    @Override
    public String toString() {
        return "ScenarioResult{" +
                "resultId=" + resultId +
                ", scenarioId=" + scenarioId +
                ", metricName='" + metricName + '\'' +
                ", baselineValue=" + baselineValue +
                ", scenarioValue=" + scenarioValue +
                ", impactValue=" + impactValue +
                '}';
    }
}
