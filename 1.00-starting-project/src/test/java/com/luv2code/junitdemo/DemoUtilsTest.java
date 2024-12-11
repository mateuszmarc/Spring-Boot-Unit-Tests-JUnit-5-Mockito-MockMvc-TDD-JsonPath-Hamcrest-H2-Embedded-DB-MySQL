package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
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
    @Test
    @DisplayName("Check array equals")
    void checkArrayEquals() {
        String[] letters = demoUtils.getFirstThreeLettersOfAlphabet();

        assertArrayEquals(new String[] {"A", "B", "C"}, letters, "Arrays should not the same");
    }

    @Test
    @DisplayName("Test iterables equals")
    void checkIterablesEquals() {
        List<String> strings = demoUtils.getAcademyInList();

        assertIterableEquals(List.of("luv", "2", "code"), strings,"Arrays should be equal");
    }

    @Test
    @DisplayName("Test lines match")
    void checkIterableMatches() {
        List<String> strings = demoUtils.getAcademyInList();

        assertLinesMatch(List.of("luv", "2", "code"), strings, "Lines should match");
    }

    @Test
    @DisplayName("Test throw Exception")
    void testThrowException() {

        assertThrows(Exception.class, () -> demoUtils.throwException(-1), "Should throw an exception");
    }

    @Test
    @DisplayName("Test do not throw Exception")
    void testDontThrowException() {
        assertDoesNotThrow(() -> demoUtils.throwException(1), "Should not throw an exception");
    }

    @Test
    @DisplayName("Test timeout")
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout(), "Method should execute in 3 seconds");
    }

    @Test
    void testMultiply() {
        int a = 2;
        int b = 4;
        int expectedResult = 8;

        assertEquals(expectedResult, demoUtils.multiply(a, b), "Should be %d".formatted(expectedResult));

    }
}
























