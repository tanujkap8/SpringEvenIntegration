package com.ATMApplication;

public class User {
    private String name;
    private double balance;
    private int atmPIN;
    private long mobileNumber;

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAtmPIN() { return atmPIN; }

    public void setAtmPIN(int atmPIN) { this.atmPIN = atmPIN; }

    public long getMobileNumber() { return mobileNumber; }

    public User(String name, double balance, int atmPIN, long mobileNumber) {
        this.name = name;
        this.balance = balance;
        this.atmPIN = atmPIN;
        this.mobileNumber = mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) { this.mobileNumber = mobileNumber; }
}
