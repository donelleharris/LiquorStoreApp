package org.example.dao;

import org.example.model.User;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
}
