package com.hunko.email.dao.filter;

import java.util.List;

public class HqlFilterImpl implements Filter {
    private final List<String> queryTokens;
    private String query;

    HqlFilterImpl(List<String> tokens) {
        queryTokens = tokens;
    }

    @Override
    public String getQuery() {
        if (query == null) {
            initQuery();
        }

        return query;
    }

    @Override
    public Iterable<String> getQueryTokens() {
        return queryTokens;
    }

    private void initQuery() {
        StringBuilder queryBuilder = new StringBuilder();
        for (String t : queryTokens) {
            queryBuilder.append(t)
                    .append(' ');
        }
        query = queryBuilder.toString();
    }
}
