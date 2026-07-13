package com.alm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CashFlow {
    private int flowId;
    private Integer assetId; // nullable
    private Integer liabilityId; // nullable
    private LocalDate flowDate;
    private BigDecimal amount;
    private String flowType;

    public CashFlow() {}

    public CashFlow(int flowId, Integer assetId, Integer liabilityId, LocalDate flowDate,
                    BigDecimal amount, String flowType) {
        this.flowId = flowId;
        this.assetId = assetId;
        this.liabilityId = liabilityId;
        this.flowDate = flowDate;
        this.amount = amount;
        this.flowType = flowType;
    }

    public int getFlowId() {
        return flowId;
    }

    public void setFlowId(int flowId) {
        this.flowId = flowId;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public Integer getLiabilityId() {
        return liabilityId;
    }

    public void setLiabilityId(Integer liabilityId) {
        this.liabilityId = liabilityId;
    }

    public LocalDate getFlowDate() {
        return flowDate;
    }

    public void setFlowDate(LocalDate flowDate) {
        this.flowDate = flowDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    @Override
    public String toString() {
        return "CashFlow{" +
                "flowId=" + flowId +
                ", assetId=" + assetId +
                ", liabilityId=" + liabilityId +
                ", flowDate=" + flowDate +
                ", amount=" + amount +
                ", flowType='" + flowType + '\'' +
                '}';
    }
}
