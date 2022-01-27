package com.hunko.email.dao.filter;

import java.util.Set;

public interface FilterTokenFactory {

    boolean NO_NEGATE = false;
    boolean NEGATE = true;

    /**
     * conditional token, define if attribute is in contained in collection
     *
     * @param key    name of attribute
     * @param values set of values for comparison
     * @param negate analogue of not statement
     * @return this FilterToken
     */
    FilterToken in(String key, Set<Object> values, boolean negate);

    /**
     * conditional token, define if attribute is in contained in collection
     *
     * @param key    name of attribute
     * @param values set of values for comparison
     * @throws java.security.InvalidParameterException if values are empty
     * @return this FilterToken
     */
    default FilterToken in(String key, Set<Object> values) {
        return in(key, values, NO_NEGATE);
    }

    /**
     * conditional token, define if attribute of key is equal val
     *
     * @param key    name of attribute
     * @param val    value which to which attributes value is compared
     * @param negate analogue of not statement
     * @return this FilterToken
     */
    FilterToken eq(String key, Object val, boolean negate);

    /**
     * conditional token, define if attribute of key is equal val
     *
     * @param key name of attribute
     * @param val value which to which attributes value is compared
     * @return this FilterToken
     */
    default FilterToken eq(String key, Object val) {
        return eq(key, val, NO_NEGATE);
    }

    /**
     * conditional token, define if attribute of key is greater than val
     *
     * @param key name of attribute
     * @param val value which to which attributes value is compared
     * @return this FilterToken
     */
    FilterToken greaterThan(String key, Number val);

    /**
     * conditional token, define if attribute of key is less than val
     *
     * @param key name of attribute
     * @param val value which to which attributes value is compared
     * @return this FilterToken
     */
    FilterToken lessThan(String key, Number val);

    /**
     * conditional token, define if attribute of key is greater or equal than val
     *
     * @param key name of attribute
     * @param val value which to which attributes value is compared
     * @return this FilterToken
     */
    FilterToken greaterOrEqual(String key, Number val);

    /**
     * conditional token, define if attribute of key is less or equal than val
     *
     * @param key name of attribute
     * @param val value which to which attributes value is compared
     * @return this FilterToken
     */
    FilterToken lessOrEqual(String key, Number val);

    /**
     * conditional token, define if attribute of key is between from and to
     *
     * @param key    name of attribute
     * @param from   minimum value
     * @param to     maximum value
     * @param negate analogue of not statement
     * @return this FilterToken
     */
    FilterToken between(String key, Number from, Number to, boolean negate);

    /**
     * conditional token, define if attribute of key is between from and to
     *
     * @param key  name of attribute
     * @param from minimum value
     * @param to   maximum value
     * @return this FilterToken
     */
    default FilterToken between(String key, Number from, Number to) {
        return between(key, from, to, NO_NEGATE);
    }

    /**
     * conditional token, define if string attribute of key is like value
     *
     * @param key    name of attribute
     * @param val    value which to which attributes value is compared
     * @param negate analogue of not statement
     * @return this FilterToken
     */
    FilterToken like(String key, String val, boolean negate);

    /**
     * conditional token, define if string attribute of key is like value
     *
     * @param key name of attribute
     * @param val value which to which attributes value is compared
     * @return this FilterToken
     */
    default FilterToken like(String key, String val) {
        return like(key, val, NO_NEGATE);
    }
}
