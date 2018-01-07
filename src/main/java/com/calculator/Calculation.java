package com.calculator;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class Calculation {


    public static void main(String[] args) {
        Integer option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Option to perform : \n1.Calculator\n2.Read All Operations\n3.Read specific type operations");
        option = sc.nextInt();

        if (option == 1) {
            Double input1;
            Double input2 = 0.0;
            Double result = 0.0;
            String operator = null;
            System.out.println("Enter leftOperand:");
            input1 = sc.nextDouble();

            Integer choice;
            System.out.println("Select operation to perform     \n 1.Add\n" +
                    "\n" +
                    "    2.Subtract\n" +
                    "\n" +
                    "    3.Multiplication\n" +
                    "\n" +
                    "    4.Division\n" +
                    "\n" +
                    "    5.Power\n" +
                    "\n" +
                    "    6.Absolute\n" +
                    "\n" +
                    "    7.Modulus\n" +
                    "\n" +
                    "    8.Maximum of Two\n" +
                    "\n" +
                    "    9.Minimum of Two\n" +
                    "\n" +
                    "\n");


            choice = sc.nextInt();
            if (choice != 6)
                System.out.println("Enter rightOperand:");
            input2 = sc.nextDouble();

            switch (choice) {
                case 1:
                    result = MathFunctions.addition(input1, input2);
                    operator = "add";
                    break;
                case 2:
                    result = MathFunctions.subtraction(input1, input2);
                    operator = "sub";
                    break;
                case 3:
                    result = MathFunctions.multiplication(input1, input2);
                    operator = "multiply";
                    break;
                case 4:
                    if (input2 != 0) {
                        result = MathFunctions.division(input1, input2);
                        operator = "div";
                    } else
                        System.out.println("denominator cannot be zero");

                    break;
                case 5:
                    result = MathFunctions.power(input1, input2);
                    operator = "power";
                    break;
                case 6:
                    result = MathFunctions.absolute(input1);
                    operator = "absolute";
                    break;
                case 7:
                    result = MathFunctions.moldulus(input1, input2);
                    operator = "modulus";
                    break;
                case 8:
                    result = MathFunctions.maximum(input1, input2);
                    operator = "max";
                    break;
                case 9:
                    result = MathFunctions.minimum(input1, input2);
                    operator = "min";
                    break;
                default:
                    System.out.println("Not a valid option");


            }
            System.out.println("Result is " + result);
            Operation operation = new Operation(input1, input2, operator, result, new Timestamp(new Date().getTime()));
            Boolean done = operation.addOperation();
            if (done)
                System.out.println("operation saved");

        } else if (option == 2) {
            List<Operation> operationList = Operation.readOperation();
            for (Operation operation :
                    operationList) {
                System.out.println(operation.toString() + " \n");

            }
        } else if (option == 3) {
            Integer choice;
            String operator = null;
            System.out.println("Select operation to perform     \n 1.Add\n" +
                    "\n" +
                    "    2.Subtract\n" +
                    "\n" +
                    "    3.Multiplication\n" +
                    "\n" +
                    "    4.Division\n" +
                    "\n" +
                    "    5.Power\n" +
                    "\n" +
                    "    6.Absolute\n" +
                    "\n" +
                    "    7.Modulus\n" +
                    "\n" +
                    "    8.Maximum of Two\n" +
                    "\n" +
                    "    9.Minimum of Two\n" +
                    "\n" +
                    "\n");


            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    operator = "add";
                    break;
                case 2:
                    operator = "sub";
                    break;
                case 3:
                    operator = "multiply";
                    break;
                case 4:
                    operator = "div";
                    break;
                case 5:
                    operator = "power";
                    break;
                case 6:
                    operator = "absolute";
                    break;
                case 7:
                    operator = "modulus";
                    break;
                case 8:
                    operator = "max";
                    break;
                case 9:
                    operator = "min";
                    break;
                default:
                    System.out.println("Not a valid option");

            }
            List<Operation> operationList = Operation.readSpecificOperation(operator);
            for (Operation operation :
                    operationList) {
                System.out.println(operation.toString() + " \n");

            }

        }
        else System.out.println("Not a valid option");
    }
}
