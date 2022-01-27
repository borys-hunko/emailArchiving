package com.hunko.email.dao.filter.hibernate;

import com.hunko.email.dao.filter.FilterToken;
import com.hunko.email.dao.filter.FilterTokenFactory;

import java.util.Set;

public class HqlTokenFactory implements FilterTokenFactory {

    @Override
    public FilterToken in(String key, Set<Object> values, boolean negate) {
        return null;
    }

    @Override
    public FilterToken eq(String key, Object val, boolean negate) {

        return null;
    }

    @Override
    public FilterToken greaterThan(String key, Number val) {
        return null;
    }

    @Override
    public FilterToken lessThan(String key, Number val) {
        return null;
    }

    @Override
    public FilterToken greaterOrEqual(String key, Number val) {
        return null;
    }

    @Override
    public FilterToken lessOrEqual(String key, Number val) {
        return null;
    }

    @Override
    public FilterToken between(String key, Number from, Number to, boolean negate) {
        return null;
    }

    @Override
    public FilterToken like(String key, String val, boolean negate) {
        return null;
    }
}
