package com.kali;

public class Output extends Origin {

    public Output(double source, double balance, String description) {
        super(source, balance, description);
    }

    @Override
    public String toString() {
        return "支出: " + this.source + "\t支出说明: " + this.description + "\t账户余额: " + this.balance;
    }

}
