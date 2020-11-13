package org.example.dao;

import org.example.model.employee;

public interface employees {
    employee findByUsername(String username);
    Long insert(employee employee);
}
