package com.hunko.email.dao.filter.hibernate;

import com.hunko.email.dao.filter.FilterToken;
import com.hunko.email.dao.filter.FilterTokenFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HqlTokenFactoryTest {
    public static final String KEY = "key";
    public static final String STRING_VAL = "val";
    public static final String NON_EQUAL = "!=";
    public static final String VAL_SET_STR = "('val1', 'val2', 'val3')";
    private static final String EQUAL = "=";
    private static final int NUM_VAL = 312;
    public static final String KEY_EQUAL_VAL = KEY + EQUAL + STRING_VAL;
    private static final String IN = "in";
    private static final String NOT = "not";
    private static final String GREATER_THAN = ">";
    private static final String LESS_THAN = "<";
    private static final Set<Object> VLA_SET = Set.of("val1", "val2", "val3");
    private static final String KEY_NON_EQUALS_VAL = KEY + NON_EQUAL + STRING_VAL;
    private static final String KEY_IN = KEY + IN + VAL_SET_STR;
    private static final String KEY_NOT_IN = KEY + NOT + IN + VAL_SET_STR;
    private static final String KEY_GREATER_THAN = KEY + GREATER_THAN + NUM_VAL;
    private static final String KEY_LESS_THAN = KEY + LESS_THAN + NUM_VAL;
    private static final String KEY_GREATER_OR_EQUAL_THAN = KEY + GREATER_THAN + EQUAL + NUM_VAL;
    private static final String KEY_LESS_EQUAL_THAN = KEY + LESS_THAN + EQUAL + NUM_VAL;

    HqlTokenFactory factory;

    @BeforeEach
    void setUp() {
        factory = new HqlTokenFactory();
    }

    @Test
    void testInNonNegative() {
        FilterToken filterToken = factory.in(KEY, VLA_SET, FilterTokenFactory.NO_NEGATE);
        assertEquals(KEY_IN, filterToken.value());
    }

    @Test
    void testInNegative() {
        FilterToken filterToken = factory.in(KEY, VLA_SET, FilterTokenFactory.NEGATE);
        assertEquals(KEY_NOT_IN, filterToken.value());
    }

    @Test
    void testEqNonNegative() {
        FilterToken filterToken = factory.eq(KEY, STRING_VAL, FilterTokenFactory.NO_NEGATE);
        assertEquals(KEY_EQUAL_VAL, filterToken.value());
    }

    @Test
    void testEqNegative() {
        FilterToken filterToken = factory.eq(KEY, STRING_VAL, FilterTokenFactory.NEGATE);
        assertEquals(KEY_NON_EQUALS_VAL, filterToken.value());
    }

    @Test
    void testGreaterThan() {
        FilterToken filterToken = factory.greaterThan(KEY, NUM_VAL);
        assertEquals(KEY_GREATER_THAN, filterToken.value());
    }

    @Test
    void testLessThan() {
        FilterToken filterToken = factory.lessThan(KEY, NUM_VAL);
        assertEquals(KEY_LESS_THAN, filterToken.value());
    }

    @Test
    void testGreaterOrEqual() {
        FilterToken filterToken = factory.greaterThan(KEY, NUM_VAL);
        assertEquals(KEY_GREATER_THAN, filterToken.value());
    }

    @Test
    void testLessOrEqual() {
        FilterToken filterToken = factory.lessThan(KEY, NUM_VAL);
        assertEquals(KEY_LESS_THAN, filterToken.value());
    }

    @Test
    void between() {
    }

    @Test
    void like() {
    }
}