package com.hunko.email.dao;

import com.hunko.email.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HQLTest {
    SessionFactory factory;
    Session session;

    @BeforeEach
    void setUp() {
        Configuration configuration = new Configuration();
        factory = configuration.configure().buildSessionFactory();
        session = factory.openSession();
    }

    @Test
    void testHqlWithDoubleNot() {
        List<User> user = session.createQuery("from User where primaryEmail = null ", User.class).getResultList();
    }

    @AfterEach
    void clearResources() {
        session.close();
        factory.close();
    }
}
