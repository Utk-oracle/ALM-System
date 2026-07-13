package com.alm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MarketRate {
    private int rateId;
    private LocalDate rateDate;
    private String rateType;
    private int tenorMonths;
    private BigDecimal interestRate;
    private String currency;

    public MarketRate() {}

    public MarketRate(int rateId, LocalDate rateDate, String rateType, int tenorMonths,
                      BigDecimal interestRate, String currency) {
        this.rateId = rateId;
        this.rateDate = rateDate;
        this.rateType = rateType;
        this.tenorMonths = tenorMonths;
        this.interestRate = interestRate;
        this.currency = currency;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public LocalDate getRateDate() {
        return rateDate;
    }

    public void setRateDate(LocalDate rateDate) {
        this.rateDate = rateDate;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public int getTenorMonths() {
        return tenorMonths;
    }

    public void setTenorMonths(int tenorMonths) {
        this.tenorMonths = tenorMonths;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "MarketRate{" +
                "rateId=" + rateId +
                ", rateDate=" + rateDate +
                ", rateType='" + rateType + '\'' +
                ", tenorMonths=" + tenorMonths +
                ", interestRate=" + interestRate +
                ", currency='" + currency + '\'' +
                '}';
    }
}
