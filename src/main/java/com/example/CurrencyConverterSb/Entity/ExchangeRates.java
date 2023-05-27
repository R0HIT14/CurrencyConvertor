package com.example.CurrencyConverterSb.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Exchange_Rates")
public class ExchangeRates {
    @Id
    @Column(name = "Currency")
    private String currencyId;
    @Column(name = "INR")
    private double inrRate;
    @Column(name = "EURO")
    private double eurRate;
    @Column(name = "YEN")
    private double jpyRate;
    @Column(name = "USD")
    private double usdRate;

    public ExchangeRates(String currencyId, double inrRate, double eurRate, double jpyRate, double usdRate) {
        this.currencyId = currencyId;
        this.inrRate = inrRate;
        this.eurRate = eurRate;
        this.jpyRate = jpyRate;
        this.usdRate = usdRate;
    }
    public ExchangeRates(){

    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public double getInrRate() {
        return inrRate;
    }

    public void setInrRate(double inrRate) {
        this.inrRate = inrRate;
    }

    public double getEurRate() {
        return eurRate;
    }

    public void setEurRate(double eurRate) {
        this.eurRate = eurRate;
    }

    public double getJpyRate() {
        return jpyRate;
    }

    public void setJpyRate(double jpyRate) {
        this.jpyRate = jpyRate;
    }

    public double getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(double usdRate) {
        this.usdRate = usdRate;
    }
    public String toString(){
        return this.currencyId +" : "+this.inrRate+" : "+this.usdRate+" : "+this.jpyRate+" : "+this.eurRate;
    }
}
