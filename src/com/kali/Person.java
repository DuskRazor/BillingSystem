package com.kali;

public class Person {
    private String name;
    private double balance;
    private Origin origin;

    public Person() {
    }

    public Person(String name, double balance,Origin origin) {
        this.name = name;
        this.balance = balance;
        this.origin = origin;
    }

    public void addIncome(){
        if(origin instanceof Income){
            Income income = (Income)origin;
            this.balance += income.getSource();
        }
    }

    public void addOutput(){
        if(origin instanceof Output){
            Output output = (Output)origin;
            this.balance -= output.getSource();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
