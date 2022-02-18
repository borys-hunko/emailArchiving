package com.hunko.email.dao;

import com.hunko.email.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import javax.persistence.criteria.Selection;
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

    @AfterEach
    void foo() {
        session.close();
    }

    @Test
    void testNullId() {
        User u = null;
        System.out.println(session.get(User.class, null));
    }

    @Test
    void testInsertNull() {
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 2L);
        user.setPassword("newPasssword4".toCharArray());
        Query<User> from_user = session.createQuery("from User", User.class);
        System.err.println(1);
        from_user.stream().forEach(System.err::println);
        System.err.println(2);
        List<User> users = from_user.list();
        users.forEach(System.err::println);


//        int res = session.createQuery("update User set primaryEmail=:email, password = :password where id=:id")
//                .setParameter("email", u2.getPrimaryEmail())
//                .setParameter("password", u2.getPassword())
//                .setParameter("id", user.getId())
//                .executeUpdate();
//        User user = new User();
//        user.setPassword("pasdasd".repeat(10).toCharArray());
//        user.setPrimaryEmail("kekekeke@gmail.com");
//        session.save(user);
//        session.createQuery("delete User where id=:id")
//                .setParameter("id", null)
//                .executeUpdate();
        //SQLIntegrityConstraintViolationException
        //SQLIntegrityConstraintViolationException
        transaction.commit();

    }

    @Test
    void testHqlWithDoubleNot() {
        Query<User> userQuery = session.createQuery("from User where primaryEmail = 'asd'", User.class)
//                .setParameter("param", )
                ;
//        session.getCriteriaBuilder()
//                .between()
//                .createQuery(User.class)
//                .

        String s = userQuery
                .getQueryString();
        System.err.println(s);
        List<User> user = userQuery.getResultList();
        System.err.println(user);
    }

    @AfterEach
    void clearResources() {
        session.close();
        factory.close();
    }
    /*create generic dao
        dao(crud + getAll)
        dao  w/ pagination
        for filtering create extra method inside *classname*DAO which take *classname*FilterParams as argument
     */

}
