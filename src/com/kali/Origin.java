package com.kali;

public abstract class Origin {
    public double source;
    public double balance;
    public String description;

    public Origin(double fortune, double balance, String description) {
        this.source = fortune;
        this.balance = balance;
        this.description = description;
    }

    public double getSource() {
        return source;
    }

    public void setSource(double source) {
        this.source = source;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "";
    }
}
