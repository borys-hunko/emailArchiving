package com.hunko.email.dao;

import com.hunko.email.model.User;

import java.util.Comparator;
import java.util.List;
//TODO: divide dao interface and create user dao
public class UserDao implements Dao<Long, User> {
    @Override
    public User get(Long id) {

        return null;
    }

    @Override
    public boolean add(User instance) {
        return false;
    }

    @Override
    public boolean update(User newInstance) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getAll(Comparator<User> comparator) {
        return null;
    }

    @Override
    public List<User> getAllPaged(int limit, int pageNumber, Comparator<User> comparator) {
        return null;
    }
}
