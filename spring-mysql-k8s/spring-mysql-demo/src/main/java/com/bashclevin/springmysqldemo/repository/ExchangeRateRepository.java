package com.bashclevin.springmysqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bashclevin.springmysqldemo.model.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
  ExchangeRate findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency);
}
