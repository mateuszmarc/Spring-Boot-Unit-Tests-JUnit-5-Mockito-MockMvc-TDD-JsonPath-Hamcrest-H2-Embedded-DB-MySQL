package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
class DemoUtilsTest {

    private DemoUtils demoUtils;

    @BeforeEach
    void beforeEach() {
//        System.out.println("@BeforeEach executes before the execution of each method");
        demoUtils = new DemoUtils();
    }

//    @AfterEach
//    void afterEach() {
//        System.out.println("@AfterEach executes after the execution of each method");
//        System.out.println();
//    }
//
//    @BeforeAll
//    static void setupBeforeAll() {
//        System.out.println("@BeforeAll executes only once before all test methods");
//    }
//
//    @AfterAll
//    static void tearDownAfterAll() {
//        System.out.println("@AfterAll executes only once after all test methods");
//    }


    @Test
    @DisplayName("Test for checking adding calculation")
    void testAdd() {
//        System.out.println("Running test: testAdd");
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
    @DisplayName("Check for the null object")
    void testCheckNull() {
//        System.out.println("Running test: testCheckNull");

        Object toTest = null;

        assertNull(demoUtils.checkNull(toTest), "This object should be null");
    }

    @Test
    @DisplayName("Check for not null object")
    void testCheckNotNull() {
//        System.out.println("Running test: testCheckNotNull");
        Object toTest = new Object();

        assertNotNull(demoUtils.checkNull(toTest), "This object should not benull");
    }

    @Test
    @DisplayName("Check objects for the same")
    void testCheckForSame() {
        String academy = demoUtils.getAcademy();
        String academyRepeat = demoUtils.getAcademyDuplicate();

        assertSame(academy, academyRepeat, "Should refer to the same object");
    }

//    @Test
//    @DisplayName("Check for not the same")
//    void testCheckForNotSame() {
//        String academy = demoUtils.getAcademy();
//        String academyRepeat = demoUtils.getAcademyDuplicate();
//
//        assertNotSame(academy, academyRepeat, "Should refer to different objects");
//    }

    @Test
    @DisplayName("Test true for isGreater")
    void testTrueIsGreater() {
        int n1 = 4;
        int n2 = 3;

        assertTrue(demoUtils.isGreater(n1, n2), "Should return true");
    }

    @Test
    @DisplayName("Test false for isGreater")
    void testFalseIsGreater() {
        int n1 = 3;
        int n2 = 4;

        assertFalse(demoUtils.isGreater(n1, n2), "Should return false");
    }
}
