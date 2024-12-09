package com.luv2code.junitdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    private final DemoUtils demoUtils = new DemoUtils();

    @Test
    void testAdd() {

//        give
        int a = 2;
        int b = 4;
        int expectedResult = 6;

//        when
        int result = demoUtils.add(a, b);

//        then
        assertEquals(expectedResult, result, "Result should be %d".formatted(expectedResult));
        assertNotEquals(10, result, "Should not return %d".formatted(10));
    }

    @Test
    void testCheckNull() {

        Object toTest = null;

        assertNull(demoUtils.checkNull(toTest), "This object should be null");
    }

    @Test
    void testCheckNotNull() {
        Object toTest = new Object();

        assertNotNull(demoUtils.checkNull(toTest), "This object should not benull");
    }
}
