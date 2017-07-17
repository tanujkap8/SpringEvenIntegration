package com.ATMApplication;

public interface UserDao {
    boolean withdrawal(User user, double money);
    boolean changeATMPIN(User user, int PIN);
    boolean changeMobileNumber(User user, long mobileNumber);
    void insert(User user);
}
