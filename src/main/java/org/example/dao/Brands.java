package org.example.dao;
import org.example.model.Brand;

import java.util.List;

public interface Brands {
    List<Brand> all();
    void insert(Brand brand)
}
