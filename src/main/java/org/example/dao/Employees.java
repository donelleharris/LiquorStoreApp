package org.example.dao;

import org.example.model.Employee;

public interface Employees {
    Employee findByUsername(String username);
    Long insert(Employee employee);
}
