package com.luv2code;

public class FizzBuzz {
//    public static String compute(int testedNumber) {
//
//        if (testedNumber % 15 == 0) {
//            return "FizzBuzz";
//        }
//
//        else if (testedNumber % 3 == 0) {
//            return "Fizz";
//        } else if (testedNumber % 5 == 0) {
//            return "Buzz";
//        }
//        return String.valueOf(testedNumber);
//    }

    public static String compute(int testedNumber) {
        if (testedNumber % 15 == 0) return "FizzBuzz";
        else if (testedNumber % 5 == 0) return "Buzz";
        else if (testedNumber % 3 == 0) return "Fizz";

        return String.valueOf(testedNumber);
    }
}
