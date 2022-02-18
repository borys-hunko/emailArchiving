package com.hunko.email.dao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SessionManagerImpl implements SessionManager {

    private final SessionFactory sessionFactory;

    @Autowired
    public SessionManagerImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void commitAndClose(Session session) {
        if (isClosable(session)) {
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void rollbackAndClose(Session session) {
        if (isClosable(session)) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void close(Session session) {
        if (isClosable(session)) {
            session.close();
        }
    }

    private boolean isClosable(Session session) {
        return session != null && session.isOpen();
    }
}
