package com.luv2code.tdd;

import com.luv2code.FizzBuzz;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i <= 100; i++) {
            System.out.println(FizzBuzz.compute(i));
        }
    }
}
