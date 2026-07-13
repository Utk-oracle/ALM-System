package com.alm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Scenario {
    private int scenarioId;
    private String scenarioName;
    private int interestRateShiftBp;
    private BigDecimal liquidityShockPct;
    private BigDecimal creditShockPct;
    private LocalDate scenarioDate;
    private String description;

    public Scenario() {}

    public Scenario(int scenarioId, String scenarioName, int interestRateShiftBp,
                    BigDecimal liquidityShockPct, BigDecimal creditShockPct,
                    LocalDate scenarioDate, String description) {
        this.scenarioId = scenarioId;
        this.scenarioName = scenarioName;
        this.interestRateShiftBp = interestRateShiftBp;
        this.liquidityShockPct = liquidityShockPct;
        this.creditShockPct = creditShockPct;
        this.scenarioDate = scenarioDate;
        this.description = description;
    }

    public int getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public int getInterestRateShiftBp() {
        return interestRateShiftBp;
    }

    public void setInterestRateShiftBp(int interestRateShiftBp) {
        this.interestRateShiftBp = interestRateShiftBp;
    }

    public BigDecimal getLiquidityShockPct() {
        return liquidityShockPct;
    }

    public void setLiquidityShockPct(BigDecimal liquidityShockPct) {
        this.liquidityShockPct = liquidityShockPct;
    }

    public BigDecimal getCreditShockPct() {
        return creditShockPct;
    }

    public void setCreditShockPct(BigDecimal creditShockPct) {
        this.creditShockPct = creditShockPct;
    }

    public LocalDate getScenarioDate() {
        return scenarioDate;
    }

    public void setScenarioDate(LocalDate scenarioDate) {
        this.scenarioDate = scenarioDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "scenarioId=" + scenarioId +
                ", scenarioName='" + scenarioName + '\'' +
                ", interestRateShiftBp=" + interestRateShiftBp +
                ", liquidityShockPct=" + liquidityShockPct +
                ", creditShockPct=" + creditShockPct +
                ", scenarioDate=" + scenarioDate +
                ", description='" + description + '\'' +
                '}';
    }
}
