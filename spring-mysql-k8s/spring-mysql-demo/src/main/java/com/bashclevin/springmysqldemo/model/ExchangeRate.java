package com.bashclevin.springmysqldemo.model;

import java.sql.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer transactionId;

  @Nonnull
  private String sourceCurrency;

  @Nonnull
  private String targetCurrency;

  @Nonnull
  private double amount;

  @Nonnull
  private Date lastUpdated;

  public void setTransactionId(Integer transactionId) {
    this.transactionId = transactionId;
  }

  public void setSourceCurrency(String sourceCurrency) {
    this.sourceCurrency = sourceCurrency;
  }

  public void setTargetCurrency(String targetCurrency) {
    this.targetCurrency = targetCurrency;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public Integer getTransactionId() {
    return transactionId;
  }

  public String getSourceCurrency() {
    return sourceCurrency;
  }

  public String getTargetCurrency() {
    return targetCurrency;
  }

  public double getAmount() {
    return amount;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

}
