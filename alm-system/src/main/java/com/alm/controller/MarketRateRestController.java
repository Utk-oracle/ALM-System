package com.alm.controller;

import com.alm.model.MarketRate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/market-rates")
public class MarketRateRestController {
    private final MarketRateController marketRateDao;

    public MarketRateRestController(MarketRateController marketRateDao) {
        this.marketRateDao = marketRateDao;
    }

    @GetMapping
    public List<MarketRate> findAll(@RequestParam(required = false) String currency,
                                    @RequestParam(required = false) String rateType) throws SQLException {
        if (currency != null && rateType != null) {
            return marketRateDao.findByTypeAndCurrency(rateType, currency);
        }
        if (currency != null) {
            return marketRateDao.findByCurrency(currency);
        }
        return marketRateDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarketRate> findById(@PathVariable int id) throws SQLException {
        return marketRateDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MarketRate> create(@RequestBody MarketRate marketRate) throws SQLException {
        marketRateDao.create(marketRate);
        return ResponseEntity.status(201).body(marketRate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarketRate> update(@PathVariable int id, @RequestBody MarketRate marketRate) throws SQLException {
        marketRate.setRateId(id);
        return marketRateDao.update(marketRate)
                ? ResponseEntity.ok(marketRate)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws SQLException {
        return marketRateDao.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
