package com.yandm.assir.bo.service.impl;

import com.yandm.assir.bo.dao.UserDao;
import com.yandm.assir.bo.dao.impl.UserDaoImpl;
import com.yandm.assir.bo.service.UserService;
import com.yandm.assir.model.User;

public class UserServiceImpl implements UserService{

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean isFound(User user) { return userDao.isFound(user); }
}
