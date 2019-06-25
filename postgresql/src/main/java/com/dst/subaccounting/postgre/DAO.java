package com.dst.subaccounting.postgre;

import java.util.List;

public interface DAO<T> {
    void insert(T t);
    void bulkInsert(List<T> t);
    List<T> getAll();
}
