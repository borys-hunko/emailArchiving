package com.hunko.email.dao;

import java.util.Comparator;
import java.util.List;

/**
 * interface which perform basic CRUD operations
 *
 * @param <I> identifier
 * @param <V> value
 */
public interface Dao<I, V> {
    /**
     * return object with provided id
     *
     * @param id identifier of object stored in database
     * @return objet stored in db or null if not found
     * @throws com.hunko.email.exceptions.InternalDatabaseException if there is server side bug
     * @throws NullPointerException                                 if id is null
     */
    V get(I id);

    /**
     * add instance to database at set new id to added instance
     *
     * @param instance add instance to db
     * @throws NullPointerException                                 if passed instance is null
     * @throws com.hunko.email.exceptions.NonUniqueElementException if passes object is not unique(if it must be)
     * @throws com.hunko.email.exceptions.NullAttributeException    if NOT NULL field are null
     * @throws com.hunko.email.exceptions.InternalDatabaseException if there is server side bug
     */
    boolean add(V instance);

    /**
     * update stored instance with id of passed object in database
     *
     * @param newInstance updated instance of object
     * @throws NullPointerException                                 if passed instance is null
     * @throws com.hunko.email.exceptions.NonUniqueElementException if passes object is not unique(if it must be)
     * @throws com.hunko.email.exceptions.NullAttributeException    if NOT NULL field are null
     * @throws com.hunko.email.exceptions.InternalDatabaseException if there is server side bug
     */
    boolean update(V newInstance);

    /**
     * delete object with specified id
     *
     * @param id identifier
     * @throws NullPointerException                                 if passed id is null
     * @throws com.hunko.email.exceptions.NoSuchElementException    if there is no object with such id
     * @throws com.hunko.email.exceptions.InternalDatabaseException if there is server side bug
     */
    boolean delete(I id);

    /**
     * return all object from db
     *
     * @return list of all objects in db
     * @throws com.hunko.email.exceptions.InternalDatabaseException if there is server side bug
     */
    List<V> getAll();

    /**
     * returns list of all object in specified order
     *
     * @param comparator condition of sorting
     * @return list of all object in specified order
     */
    List<V> getAll(Comparator<V> comparator);

    /**
     * returns $limit object for page number sorted in chosen way
     * if there is no element on given page returns empty list
     * if limit is bigger than number of object on page returns all found objects
     *
     * @param limit      number of object to return
     * @param pageNumber number of page
     * @param comparator condition of sorting
     * @return all objects for passed page in chosen order
     * @throws NullPointerException                                 if one of passed elements is null
     * @throws com.hunko.email.exceptions.InternalDatabaseException if there is server side bug
     */
    List<V> getAllPaged(int limit, int pageNumber, Comparator<V> comparator);

//    public static boolean main(String[] args) {
//        Configuration configuration = new Configuration().configure();
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = new User();
//        user.setPassword("passowrsds12312".toCharArray());
//        user.setPrimaryEmail("sdasd");
//        session.save(user);
//        User user1 = new User();
//        user1.setPrimaryEmail(user1.getPrimaryEmail());
//        user1.setPassword("888fadad".toCharArray());
//        transaction.commit();
//        session.close();
//        System.out.println(user.getId());
//    }
}
