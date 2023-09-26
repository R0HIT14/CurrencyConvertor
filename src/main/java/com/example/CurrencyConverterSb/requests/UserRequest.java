package com.example.CurrencyConverterSb.requests;
public class UserRequest {
    String curType;
    String cur;

    double amountgrgerge;

    public UserRequest(){

    }

    public UserRequest(String cur, String curType, double amount) {
        this.cur = cur;
        this.curType = curType;
        this.amount = amount;
    }

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur;
    }

    public String getCurType() {
        return curType;
    }

    public void setCurType(String curType) {
        this.curType = curType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
