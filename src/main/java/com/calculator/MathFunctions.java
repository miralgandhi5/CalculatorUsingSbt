package com.calculator;

public class MathFunctions {

    public static Double addition(Double leftOperand, Double rightOperand) {
        return leftOperand + rightOperand;

    }

    public static Double subtraction(Double leftOperand, Double rightOperand) {
        return leftOperand - rightOperand;

    }

    public static Double division(Double leftOperand, Double rightOperand) {

        return leftOperand / rightOperand;

    }

    public static Double multiplication(Double leftOperand, Double rightOperand) {
        return leftOperand * rightOperand;

    }

    public static Double power(Double leftOperand, Double rightOperand) {
        return Math.pow(leftOperand, rightOperand);

    }

    public static Double absolute(Double Operand) {
        return Math.abs(Operand);

    }

    public static Double moldulus(Double leftOperand, Double rightOperand) {
        return leftOperand % rightOperand;

    }

    public static Double maximum(Double leftOperand, Double rightOperand) {
        return Math.max(leftOperand, rightOperand);

    }

    public static Double minimum(Double leftOperand, Double rightOperand) {
        return Math.min(leftOperand, rightOperand);

    }

}
