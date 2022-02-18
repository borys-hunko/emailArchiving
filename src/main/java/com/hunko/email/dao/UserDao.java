package com.hunko.email.dao;

import com.hunko.email.model.User;

public interface UserDao extends Dao<Long, User> {
    /**
     *
     * @param email user email
     * @param password user password
     * @return user with passed email and password
     */
    User getByEmailPassword(String email, char[] password);
}
