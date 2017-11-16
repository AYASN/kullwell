package com.yandm.assir.bo.dao.impl;

import com.yandm.assir.bo.dao.UserDao;
import com.yandm.assir.dao.ConnectionFactory;
import com.yandm.assir.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private Connection connection;

    @Override
    public boolean isFound(User user) {
        connection = ConnectionFactory.getConnection();
        boolean isFound = false;
        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?;");
            query.setString(1, user.getUsername());
            query.setString(2, user.getPassword());
            ResultSet resultSet = query.executeQuery();
            connection.close();
            isFound = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isFound;
    }
}