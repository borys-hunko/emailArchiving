//package com.hunko.email.dao.filter;
//
//import com.hunko.email.exceptions.InvalidFilterBuildingException;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
////TODO write test for builder
//public class HqlFilterBuilder implements FilterBuilder {
//    public static final String NOT = "not";
//    private static final String COMPARING_TOKEN = "COMPARING";
//    private final List<String> queryTokens = new ArrayList<>();
//    private String lastToken;
//
//    @Override
//    public Filter build() {
//        return new HqlFilterImpl(queryTokens);
//    }
//
//    @Override
//    public FilterBuilder clear() {
//        queryTokens.clear();
//        lastToken = null;
//        return this;
//    }
//
//    @Override
//    public FilterBuilder not() {
//        if (lastToken == null || lastToken.equals(COMPARING_TOKEN)) {
//            throw new InvalidFilterBuildingException("you can't place NOT statement in this place");
//        }
//        queryTokens.add(NOT);
//        lastToken = NOT;
//        return this;
//    }
//
//    @Override
//    public FilterBuilder and() {
//        return null;
//    }
//
//    @Override
//    public FilterBuilder or() {
//        return null;
//    }
//
//    @Override
//    public FilterBuilder in(String key, Set<Object> values) {
//        return null;
//    }
//
//    @Override
//    public FilterBuilder eq(String key, Object val) {
//        return null;
//    }
//
//    @Override
//    public FilterBuilder greaterThan(String key, Object val) {
//        return null;
//    }
//
//    @Override
//    public FilterBuilder lessThan(String key, Object val) {
//        return null;
//    }
//
//    @Override
//    public FilterBuilder between(String key, String from, String to) {
//        return null;
//    }
//
//    @Override
//    public FilterBuilder like(String key, String val, boolean caseSensitive) {
//        return null;
//    }
//
//    private static class HqlFilterImpl implements Filter {
//        private final List<String> queryTokens;
//        private String query;
//
//        private HqlFilterImpl(List<String> tokens) {
//            queryTokens = tokens;
//        }
//
//        @Override
//        public String getQuery() {
//            if (query == null) {
//                initQuery();
//            }
//
//            return query;
//        }
//
//        @Override
//        public Iterable<String> getQueryTokens() {
//            return queryTokens;
//        }
//
//        private void initQuery() {
//            StringBuilder queryBuilder = new StringBuilder();
//            if (queryTokens.isEmpty()) {
//                query = "";
//                return;
//            }
//            queryBuilder.append("where ");
//            for (String t : queryTokens) {
//                queryBuilder.append(t)
//                        .append(' ');
//            }
//            query = queryBuilder.toString();
//        }
//    }
//}
