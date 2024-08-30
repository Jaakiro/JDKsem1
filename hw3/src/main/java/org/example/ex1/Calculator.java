package org.example.ex1;

public class Calculator {

    public static <T extends Number, U extends Number> double subtraction(T a, U b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static <T extends Number, U extends Number> double sum(T a, U b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, U extends Number> double division(T a, U b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("На 0 делить нельзя.");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiplication(T a, U b) {
        return a.doubleValue() * b.doubleValue();
    }
}

