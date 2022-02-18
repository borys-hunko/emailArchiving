package com.hunko.email.dao.impl;

import com.hunko.email.dao.UserDao;
import com.hunko.email.dao.utils.SessionManager;
import com.hunko.email.exceptions.InternalDatabaseException;
import com.hunko.email.exceptions.NonUniqueElementException;
import com.hunko.email.exceptions.NullAttributeException;
import com.hunko.email.model.User;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//TODO: create abstract class which will handle exception and standardize them
@NoArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {

    private SessionManager sessionManager;

    @Autowired
    public UserDaoImpl(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public User get(Long id) {
        try (Session session = sessionManager.getSession()) {
            return session.load(User.class, id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("you must specify user id");
        } catch (Exception e) {
            throw getInternalDatabaseException(e);
        }
    }

    @Override
    public boolean add(User user) {
        Session session = null;
        try {
            session = sessionManager.getSession();
            session.beginTransaction();
            session.save(user);
            sessionManager.commitAndClose(session);
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("user cannot be null id");
        } catch (ConstraintViolationException e) {
            throw getExceptionForInvalidInstance(user);
        } catch (Exception e) {
            sessionManager.rollbackAndClose(session);
            throw getInternalDatabaseException(e);
        }
    }


    @Override
    public boolean update(User newInstance) {
//        try {
//
//        } catch ()
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }


    @Override
    public User getByEmailPassword(String email, char[] password) {
        return null;
    }

    private InternalDatabaseException getInternalDatabaseException(Exception e) {
        return new InternalDatabaseException("error occurred on db layer:" + e.getMessage());
    }

    private RuntimeException getExceptionForInvalidInstance(User user) {
        if (user.getPrimaryEmail() == null || user.getPrimaryEmail().isBlank()
                || user.getPassword() == null || user.getPassword().length == 0) {
            return new NullAttributeException("you need to specify email and password");
        }

        return new NonUniqueElementException("email must be unique");
    }
}
