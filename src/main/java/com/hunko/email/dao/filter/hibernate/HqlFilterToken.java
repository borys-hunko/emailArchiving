package com.hunko.email.dao.filter.hibernate;

import com.hunko.email.dao.filter.FilterToken;

public class HqlFilterToken implements FilterToken {

    public String value;

    public HqlFilterToken(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
