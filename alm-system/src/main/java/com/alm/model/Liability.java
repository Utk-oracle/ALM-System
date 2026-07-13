package com.alm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Liability {
    private int liabilityId;
    private String liabilityName;
    private String liabilityType;
    private BigDecimal principalAmount;
    private BigDecimal interestRate;
    private String rateType;
    private LocalDate maturityDate;
    private String currency;
    private BigDecimal duration;
    private boolean isRateSensitive;
    private boolean isShortTerm;
    private String liabilityStatus;

    public Liability() {}

    public Liability(int liabilityId, String liabilityName, String liabilityType,
                     BigDecimal principalAmount, BigDecimal interestRate, String rateType,
                     LocalDate maturityDate, String currency, BigDecimal duration,
                     boolean isRateSensitive, boolean isShortTerm, String liabilityStatus) {
        this.liabilityId = liabilityId;
        this.liabilityName = liabilityName;
        this.liabilityType = liabilityType;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.rateType = rateType;
        this.maturityDate = maturityDate;
        this.currency = currency;
        this.duration = duration;
        this.isRateSensitive = isRateSensitive;
        this.isShortTerm = isShortTerm;
        this.liabilityStatus = liabilityStatus;
    }

    public int getLiabilityId() {
        return liabilityId;
    }

    public void setLiabilityId(int liabilityId) {
        this.liabilityId = liabilityId;
    }

    public String getLiabilityName() {
        return liabilityName;
    }

    public void setLiabilityName(String liabilityName) {
        this.liabilityName = liabilityName;
    }

    public String getLiabilityType() {
        return liabilityType;
    }

    public void setLiabilityType(String liabilityType) {
        this.liabilityType = liabilityType;
    }

    public BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(BigDecimal principalAmount) {
        this.principalAmount = principalAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public boolean isRateSensitive() {
        return isRateSensitive;
    }

    public void setRateSensitive(boolean rateSensitive) {
        isRateSensitive = rateSensitive;
    }

    public boolean isShortTerm() {
        return isShortTerm;
    }

    public void setShortTerm(boolean shortTerm) {
        isShortTerm = shortTerm;
    }

    public String getLiabilityStatus() {
        return liabilityStatus;
    }

    public void setLiabilityStatus(String liabilityStatus) {
        this.liabilityStatus = liabilityStatus;
    }

    @Override
    public String toString() {
        return "Liability{" +
                "liabilityId=" + liabilityId +
                ", liabilityName='" + liabilityName + '\'' +
                ", liabilityType='" + liabilityType + '\'' +
                ", principalAmount=" + principalAmount +
                ", interestRate=" + interestRate +
                ", maturityDate=" + maturityDate +
                ", currency='" + currency + '\'' +
                ", duration=" + duration +
                ", isRateSensitive=" + isRateSensitive +
                ", isShortTerm=" + isShortTerm +
                ", liabilityStatus='" + liabilityStatus + '\'' +
                '}';
    }
}
