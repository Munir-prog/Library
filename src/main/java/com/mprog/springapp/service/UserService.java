package com.mprog.springapp.service;

import com.mprog.springapp.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
