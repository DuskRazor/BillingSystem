package com.kali;

public class Income extends Origin {

    public Income(double source, double balance, String description) {
        super(source, balance, description);
    }

    @Override
    public String toString() {
        return "收入: " + this.source + "\t收入说明: " + this.description + "\t账户余额: " + this.balance;
    }
}
