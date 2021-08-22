package com.mprog.springapp.service;


public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
