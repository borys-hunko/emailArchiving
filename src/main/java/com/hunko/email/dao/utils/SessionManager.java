package com.hunko.email.dao.utils;

import org.hibernate.Session;

//TODO: contracts and tests
public interface SessionManager {

    /**
     * opens session
     * @return opened session
     */
    Session getSession();
    void commitAndClose(Session session);
    void rollbackAndClose(Session session);
    void close(Session session);
}
