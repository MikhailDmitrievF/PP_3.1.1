package com.example.PP_31.__SpringBoot.service;



import com.example.PP_31.__SpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void add(User user);

    void update(User user);

    void delete(long id);

    User findById(long id);

}
