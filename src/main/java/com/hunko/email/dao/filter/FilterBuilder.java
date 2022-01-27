package com.hunko.email.dao.filter;

/**
 * class creating filter
 * <p>
 * there are 3 types of tokens in filter:
 * conditional e.g. a=b, a>b etc.
 * combine tokens e.g. and, or
 * not token which negates next statement
 * <p>
 * conditional statement can be inserted in empty query, after combine token and after not token
 * combine token can be placed after conditional
 * not token can be placed in the beginning or after combine token
 */
public interface FilterBuilder {
    /**
     * creates filter
     * can be built if last token is conditional
     *
     * @return built filter
     */
    Filter build();

    /**
     * clears all configuration
     */
    FilterBuilder clear();

    /**
     * combine token, logical and
     *
     * @return this FilterToken
     */
    FilterBuilder and(FilterToken condition);

    /**
     * combine token, logical or
     *
     * @return this FilterToken
     */
    FilterBuilder or(FilterToken condition);
}
