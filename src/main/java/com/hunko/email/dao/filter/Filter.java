package com.hunko.email.dao.filter;

import java.util.function.Predicate;

/**
 * filter condition
 */
public interface Filter {
    /**
     * @return filter condition as part of query or empty string if condition hasn't been added
     */
    String getQuery();

    /**
     * @return query tokens in inserting order e.g. and, or, a>b etc. Tokens may differ depending on repository implementation
     */
    Iterable<String> getQueryTokens();
}
