package com.kenzie.interfaces;
public interface Customer {
    void createProfile(String userID);
    void updateProfile(String userID);
    void login(String userID, String password);
}