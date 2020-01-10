package com.Zalvi.dao;

import java.sql.SQLException;
import java.util.List;


public interface DaoServices<T> {

    int addData(T Object);

    int updatedData(T Object);

    int deleteData(T Object);

    List<T> GetAllData();
}
