package com.sutao.oop;

public class Hourly extends Salaried {

    private double rate=100;

    private double hours = 80;

    public Hourly() {};

    public Hourly(String name) {
        super(name);
    }
    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double getPay() {
        return rate * hours;
    }
}
