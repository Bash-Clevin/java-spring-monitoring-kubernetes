package com.bashclevin.springmysqldemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bashclevin.springmysqldemo.model.ExchangeRate;
import com.bashclevin.springmysqldemo.service.ExchangeRateService;

@RestController
public class ExchangeRateController {

  @Autowired
  ExchangeRateService exchangeRateService;

  @GetMapping("/get-amount")
  public double getAmount(@RequestParam String sourceCurrency, @RequestParam String targetCurrency) {
    return exchangeRateService.getAmount(sourceCurrency, targetCurrency);
  }

  @PostMapping("/add-exchangerate")
  public ExchangeRate addExchangeRate(@RequestBody ExchangeRate exchangeRate) {
    return exchangeRateService.addExchangeRate(exchangeRate);
  }
}
