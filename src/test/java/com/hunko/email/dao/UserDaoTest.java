package com.hunko.email.dao;

import com.hunko.email.exceptions.NoSuchElementException;
import com.hunko.email.exceptions.NonUniqueElementException;
import com.hunko.email.exceptions.NullAttributeException;
import com.hunko.email.model.User;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

public class UserDaoTest {
    public static final User USER = new User();
    public static final String EMAIL = "mail@mail.org";
    public static final char[] PASSWORD = "pa$$word123".toCharArray();
    public static final int REPEAT_TIMES = 2;
    public static final char[] NEW_PASSWORD = "Wqejkl@9".toCharArray();
    UserDao dao;
    static final long ID = REPEAT_TIMES;
    static final long NON_EXISTING_ID = 0;
    static final long FIRST_ID = 1;
    static long lasId;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
        USER.setPrimaryEmail(getUniqueEmail());
        USER.setPassword(PASSWORD);
    }

    @AfterAll
    static void clearDB() {
        UserDao dao = new UserDao();
        List<User> users = dao.getAll();
        users.removeIf(user -> user.getId() == FIRST_ID);
        for (User u : users) {
            dao.delete(u.getId());
        }
    }

    @Test//test mapping
    //divide dao interface into 3 (crud + getAll + getPaged) + conditional get(receiving comperator) +
    void testGetForExisting() {
        User user = dao.get(ID);
        assertEquals(ID, user.getId());
    }

    @Test
    void testGetForNonExisting() {
        assertNull(dao.get(NON_EXISTING_ID));
    }

    @Test
    void testAddValid() {
        dao.add(USER);
        assertEquals(USER, dao.get(USER.getId()));
    }

    @Test
    void testAddReturnValue() {
        assertTrue(dao.add(USER));
    }

    @Test
    void testAddNull() {
        assertThrows(NullPointerException.class, () -> dao.add(null));
    }

    @Test
    void testAddWithNullEmail() {
        USER.setPrimaryEmail(null);
        assertThrows(NullAttributeException.class, () -> dao.add(USER));
    }

    @Test
    void testAddWithNullPassword() {
        USER.setPassword(null);
        assertThrows(NullAttributeException.class, () -> dao.add(USER));
    }

    @Test
    void testAddWithNonUniqueEmail() {
        long lastSetEmail = USER.getId();
        String lastPrimaryEmail = dao.get(lastSetEmail).getPrimaryEmail();
        USER.setPrimaryEmail(lastPrimaryEmail);
        assertThrows(NonUniqueElementException.class, () -> dao.add(USER));
    }

    @Test
    void testUpdate() {
        long id = USER.getId();
        User previousUser = dao.get(id);
        previousUser.setPassword(NEW_PASSWORD);

        dao.update(previousUser);

        User afterUpdateUser = dao.get(id);
        assertEquals(previousUser, afterUpdateUser);
    }

    @Test
    void testUpdateReturnValueWhenSetNewValue() {
        long id = USER.getId();
        User previousUser = dao.get(id);
        previousUser.setPassword(NEW_PASSWORD);

        boolean res = dao.update(previousUser);

        assertTrue(res);
    }

    @Test
    void testUpdateReturnValueWhenSetOldValue() {
        long id = USER.getId();
        User previousUser = dao.get(id);

        boolean res = dao.update(previousUser);

        assertFalse(res);
    }

    @Test
    void testUpdateWithNull() {
        assertThrows(NullPointerException.class, () -> dao.add(null));
    }

    @Test
    void testUpdateNonExistingValue() {
        USER.setId(NON_EXISTING_ID);
        assertThrows(NoSuchElementException.class, () -> dao.add(USER));
    }

    @Test
    void testUpdateWithNonUniqueValues() {
        User lastUser = dao.get(USER.getId());
    }

    private String getUniqueEmail() {
        return "a" + UUID.randomUUID() + EMAIL;
    }

    private String generateUniquePassword() {
        return "A" + UUID.randomUUID() + UUID.randomUUID();
    }
}
