package com.luv2code.tdd;

import com.luv2code.FizzBuzz;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    @Test
    @DisplayName("Divisible by Three")
    @Order(1)
    void testForDivisibleByThree() {
        String expected = "Fizz";
        int testedNumber = 3;

        assertEquals(expected, FizzBuzz.compute(testedNumber), "Should return Fizz");
    }

    @Test
    @DisplayName("Divisible by Five")
    @Order(2)
    void testDivisibleByFive() {
        String expected = "Buzz";
        int testedNumber = 5;

        assertEquals(expected, FizzBuzz.compute(testedNumber), "Should return Buzz");
    }

    @Test
    @DisplayName("Divisible by Three and Five")
    @Order(3)
    void testDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";
        int testedNumber = 15;

        assertEquals(expected, FizzBuzz.compute(testedNumber), "Should return FizzBuzz");
    }

    @Test
    @DisplayName("Not divisible by Three or Five")
    @Order(4)
    void testNotDivisibleByThreeOrFive() {
        String expectedResult = "4";
        int testedNumber = 4;

        assertEquals(expectedResult, FizzBuzz.compute(testedNumber), "Should return %s".formatted(expectedResult));
    }

    @DisplayName("Testing with small data file")
    @ParameterizedTest(name="value={0}, expected={1}")
    @Order(5)
    @CsvFileSource(resources="/small-test-data.csv")
    void testSmallDataFile(int number, String expected) {

        assertEquals(expected, FizzBuzz.compute(number));
    }

    @DisplayName("Testing medium size data")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources="/medium-test-data.csv")
    @Order(6)
    void testMediumDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing large size data")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(7)
    void testLargeDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }
}
