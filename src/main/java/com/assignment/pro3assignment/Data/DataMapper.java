package com.assignment.pro3assignment.Data;

import java.sql.ResultSet;

public interface DataMapper<T> {
    T create(ResultSet rs) throws SQLException, java.sql.SQLException;
}