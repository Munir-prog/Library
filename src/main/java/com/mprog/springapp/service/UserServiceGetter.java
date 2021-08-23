package com.mprog.springapp.service;

import com.mprog.springapp.dao.UserDao;
import com.mprog.springapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceGetter {

//    @Autowired
//    private UserDao userDao;
//
//    public static User getUser() {
//        String username = "";
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails){
//            username = ((UserDetails) principal).getUsername();
//        }
//        User user = userDao.findByUsername(username);
//        return user;
//    }
}
