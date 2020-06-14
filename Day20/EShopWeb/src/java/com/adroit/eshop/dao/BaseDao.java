package com.adroit.eshop.dao;

import java.util.ArrayList;

public interface BaseDao<T> {
    boolean save(T ob);
    boolean update(T ob);
    T get(int id);
    ArrayList<T> list();
}
