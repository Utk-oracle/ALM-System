package com.alm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Asset {
    private int assetId;
    private String assetName;
    private String assetType;
    private BigDecimal principalAmount;
    private BigDecimal interestRate;
    private String rateType;
    private LocalDate maturityDate;
    private String currency;
    private BigDecimal duration;
    private boolean isRateSensitive;
    private boolean isLiquid;
    private String creditStatus;
    private String assetStatus;

    public Asset() {}

    public Asset(int assetId, String assetName, String assetType, BigDecimal principalAmount,
                 BigDecimal interestRate, String rateType, LocalDate maturityDate, String currency,
                 BigDecimal duration, boolean isRateSensitive, boolean isLiquid,
                 String creditStatus, String assetStatus) {
        this.assetId = assetId;
        this.assetName = assetName;
        this.assetType = assetType;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.rateType = rateType;
        this.maturityDate = maturityDate;
        this.currency = currency;
        this.duration = duration;
        this.isRateSensitive = isRateSensitive;
        this.isLiquid = isLiquid;
        this.creditStatus = creditStatus;
        this.assetStatus = assetStatus;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
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

    public boolean isLiquid() {
        return isLiquid;
    }

    public void setLiquid(boolean liquid) {
        isLiquid = liquid;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "assetId=" + assetId +
                ", assetName='" + assetName + '\'' +
                ", assetType='" + assetType + '\'' +
                ", principalAmount=" + principalAmount +
                ", interestRate=" + interestRate +
                ", rateType='" + rateType + '\'' +
                ", maturityDate=" + maturityDate +
                ", currency='" + currency + '\'' +
                ", duration=" + duration +
                ", isRateSensitive=" + isRateSensitive +
                ", isLiquid=" + isLiquid +
                ", creditStatus='" + creditStatus + '\'' +
                ", assetStatus='" + assetStatus + '\'' +
                '}';
    }
}
