//package com.hunko.email.dao.filter;
//
//import org.apache.commons.collections4.IterableUtils;
//import org.assertj.core.util.IterableUtil;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class HqlFilterBuilderTest {
//    HqlFilterBuilder filterBuilder;
//    List<String> tokens;
//
//    @BeforeEach
//    void setUp() {
//        filterBuilder = new HqlFilterBuilder();
//
//    }
//
//    @Test
//    void testNotAtRightPosition() {
//
//    }
//
//    @Test
//    void testAnInRightPlace() {
//
//    }
//
//    @Test
//    void or() {
//    }
//
//    @Test
//    void in() {
//    }
//
//    @Test
//    void eq() {
//    }
//
//    @Test
//    void greaterThan() {
//    }
//
//    @Test
//    void lessThan() {
//    }
//
//    @Test
//    void between() {
//    }
//
//    @Test
//    void like() {
//    }
//
//    @Test
//    void testBuildValue() {
//        assertNotNull(filterBuilder.build());
//    }
//
//    @Test
//    void testBuildIfIncorrectLastToken()
//
//    @Test
//    void testBuildFilter() {
//        Iterable<String> builtQueryTokens = fillBuilder();
//        assertIterableEquals(builtQueryTokens, filterBuilder.build().getQueryTokens());
//    }
//
//    @Test
//    void testClear() {
//        assertFalse(filterBuilder.clear()
//                .build()
//                .getQueryTokens()
//                .iterator()
//                .hasNext());
//    }
//
//    Iterable<String> fillBuilder() {
//        return filterBuilder.
//                clear()
//                .not()
//                .eq("ab", "sad")
//                .and()
//                .lessThan("arr", 21321)
//                .build()
//                .getQueryTokens();
//    }
//
//    String getPenultimate(Iterable<String> strings) {
//        List<String> stringList = IterableUtils.toList(strings);
//        return stringList.get(stringList.size() - 1);
//    }
//}