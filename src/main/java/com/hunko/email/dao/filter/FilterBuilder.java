package com.hunko.email.dao.filter;

import java.util.Set;

public interface FilterBuilder {
    /**
     * creates filter
     *
     * @return built filter
     */
    Filter build();

    /**
     * clears all configuration
     */
    FilterBuilder clear();

    /**
     * negate next statement
     *
     * @return this FilterBuilder
     */
    FilterBuilder not();

    /**
     * logical and
     *
     * @return this FilterBuilder
     */
    FilterBuilder and();

    /**
     * logical or
     *
     * @return this FilterBuilder
     */
    FilterBuilder or();

    /**
     * define if attribute is in contained in collection
     *
     * @param key    name of attribute
     * @param values set of values for comparison
     * @return this FilterBuilder
     */
    FilterBuilder in(String key, Set<String> values);

    /**
     * define if attribute of key is equal val
     *
     * @param key name of attribute
     * @param val value which to which attributes value is compared
     * @return this FilterBuilder
     */
    FilterBuilder eq(String key, String val);

    /**
     * define if attribute of key is greater than val
     *
     * @param key name of attribute
     * @param val value which to which attributes value is compared
     * @return this FilterBuilder
     */
    FilterBuilder greaterThan(String key, String val);

    /**
     * define if attribute of key is less than val
     *
     * @param key name of attribute
     * @param val value which to which attributes value is compared
     * @return this FilterBuilder
     */
    FilterBuilder lessThan(String key, String val);

    /**
     * define if attribute of key is between from and to
     *
     * @param key  name of attribute
     * @param from minimum value
     * @param to   maximum value
     * @return this FilterBuilder
     */
    FilterBuilder between(String key, String from, String to);

    /**
     * define if string attribute of key is like value
     *
     * @param key           name of attribute
     * @param val           value which to which attributes value is compared
     * @param caseSensitive if comparing is case-sensitive
     * @return this FilterBuilder
     */
    FilterBuilder like(String key, String val, boolean caseSensitive);
}
