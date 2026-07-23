// src/main/java/com/alm/model/AlmSummaryReport.java
package com.alm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AlmSummaryReport(
        LocalDate reportDate,
        BigDecimal totalAssets,
        BigDecimal totalLiabilities,
        BigDecimal liquidAssets,
        BigDecimal shortTermLiabilities,
        BigDecimal netPosition,
        BigDecimal liquidityRatio
) {}
