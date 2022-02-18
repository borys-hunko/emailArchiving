package com.hunko.email.dao;

import com.hunko.email.dao.impl.UserDaoImpl;
import com.hunko.email.exceptions.NonUniqueElementException;
import com.hunko.email.exceptions.NullAttributeException;
import com.hunko.email.model.User;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UserDaoImplTest {
    private static final String EMAIL = "mail@mail.org";
    private static final char[] PASSWORD = "pa$$word123".toCharArray();
    private UserDaoImpl dao;
    private static final long ID = 2;
    private static final long NON_EXISTING_ID = 0;
    private static User lassAddedUser;

    @BeforeEach
    void setUp() {
        dao = new UserDaoImpl();
    }

//    @AfterAll
//    static void clearDB() {
//        UserDaoImpl dao = new UserDaoImpl();
//    }

    @Test
    void testGetForExisting() {
        User user = dao.get(ID);
        assertEquals(ID, user.getId());
    }

    @Test
    void testGetForNonExisting() {
        assertNull(dao.get(NON_EXISTING_ID));
    }

    @Test
    void testGetForNull() {
        assertThrows(IllegalArgumentException.class, () -> dao.get(null));
    }

    @Test
    void testAddValid() {
        User user = getUniqueUser();
        dao.add(user);
        assertEquals(user, dao.get(user.getId()));
        lassAddedUser = user;
    }

    @Test
    void testAddReturnValue() {
        assertTrue(dao.add(getUniqueUser()));
    }

    @Test
    void testAddNull() {
        assertThrows(NullPointerException.class, () -> dao.add(null));
    }

    @Test
    void testAddWithNullEmail() {
        User u = new User();
        u.setPassword(PASSWORD);
        assertThrows(NullAttributeException.class, () -> dao.add(u));
    }

    @Test
    void testAddWithNullPassword() {
        User u = new User();
        u.setPrimaryEmail(getUniqueEmail());
        assertThrows(NullAttributeException.class, () -> dao.add(u));
    }

    @Test
    void testAddWithNonUniqueEmail() {
        assertThrows(NonUniqueElementException.class, () -> dao.add(lassAddedUser));
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(lassAddedUser.getId());
        user.setPrimaryEmail(lassAddedUser.getPrimaryEmail());
        user.setPassword(generateUniquePassword().toCharArray());

        dao.update(user);

        User afterUpdateUser = dao.get(lassAddedUser.getId());
        assertEquals(user, afterUpdateUser);
        lassAddedUser = user;
    }

    @Test
    void testUpdateReturnValueWhenSetNewValue() {
        User user = new User();
        user.setId(lassAddedUser.getId());
        user.setPrimaryEmail(lassAddedUser.getPrimaryEmail());
        user.setPassword(generateUniquePassword().toCharArray());

        boolean res = dao.update(user);

        assertTrue(res);
    }

    @Test
    void testUpdateReturnValueWhenSetOldValue() {
        boolean res = dao.update(lassAddedUser);

        assertFalse(res);
    }

    @Test
    void testUpdateWithNull() {
        assertThrows(IllegalArgumentException.class, () -> dao.add(null));
    }

    @Test
    void testUpdateNonExistingValue() {
        User user = getUniqueUser();
        user.setId(NON_EXISTING_ID);
        assertFalse(dao.update(user));
    }

    @Test
    void testUpdateWithNonUniqueValues() {
        User user = getUniqueUser();
        dao.add(user);
        user.setPrimaryEmail(lassAddedUser.getPrimaryEmail());
        assertThrows(NonUniqueElementException.class, () -> dao.update(user));
    }

    @Test
    void testUpdateWithNullFields() {
        User user = dao.get(lassAddedUser.getId());
        user.setPrimaryEmail(null);
        assertThrows(NullAttributeException.class, () -> dao.update(user));
    }

    @Test
    void testDeleteWithCorrectId() {
        User user = getUniqueUser();
        dao.add(user);
        long id = user.getId();
        dao.delete(id);
        assertNull(dao.get(id));
    }

    @Test
    void testDeleteWithCorrectIdReturnedValue() {
        User user = getUniqueUser();
        dao.add(user);
        long id = user.getId();

        assertTrue(dao.delete(id));
    }

    @Test
    void testDeleteWithIncorrectIdReturnedValue() {
        assertFalse(dao.delete(NON_EXISTING_ID));
    }

    @Test
    void testDeleteWithNullIdReturnedValue() {
        assertFalse(dao.delete(null));
    }

    private User getUniqueUser() {
        User user = new User();
        user.setPrimaryEmail(getUniqueEmail());
        user.setPassword(PASSWORD);
        return user;
    }

//    void test

    private String getUniqueEmail() {
        return "a" + UUID.randomUUID() + EMAIL;
    }

    private String generateUniquePassword() {
        return "A" + UUID.randomUUID() + UUID.randomUUID();
    }
}
