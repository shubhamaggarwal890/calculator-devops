package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double number1, number2;
        do {
            System.out.println("Calculator-DevOps, Choose to perform operation");
            System.out.print("Press 1 to Add\nPress 2 to Subtract\nPress 3 to Multiply\nPress 4 to Divide\n" +
                    "Press any other key to exit\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }
            try {
                System.out.print("Enter the first number : ");
                number1 = scanner.nextDouble();
                System.out.print("Enter the second number : ");
                number2 = scanner.nextDouble();
            } catch (InputMismatchException error) {
                logger.error("Invalid input, Entered input is not a number");
                return;
            }
            switch (choice) {
                case 1:
                    // do addition
                    System.out.println("Addition result is : " + calculator.add(number1, number2));
                    break;
                case 2:
                    // do subtraction
                    System.out.println("Subtraction result is : " + calculator.subtract(number1, number2));
                    break;
                case 3:
                    // do multiplication
                    System.out.println("Multiplication result is : " + calculator.multiply(number1, number2));
                    break;
                case 4:
                    // do division
                    System.out.println("Division result is : " + calculator.divide(number1, number2));
                    break;
                default:
                    System.out.println("Exiting....");
                    return;
            }
        } while (true);
    }


    public double add(double number1, double number2) {
        logger.info("[ADDITION] - " + number1 + ", " + number2);
        double result = number1 + number2;
        logger.info("[RESULT - ADDITION] - " + result);
        return result;
    }

    public double subtract(double number1, double number2) {
        logger.info("[SUBTRACTION] - " + number1 + ", " + number2);
        double result = number1 - number2;
        logger.info("[RESULT - SUBTRACTION] - " + result);
        return result;
    }


    public double multiply(double number1, double number2) {
        logger.info("[MULTIPLICATION] - " + number1 + ", " + number2);
        double result = number1 * number2;
        logger.info("[RESULT - MULTIPLICATION] - " + result);
        return result;
    }

    public double divide(double number1, double number2) {
        double result = 0;
        try {
            logger.info("[DIVISION] - " + number1 + ", " + number2);
            if (number1 == 0 && number2 == 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            } else if (number1 > 0 && number2 == 0) {
                result = Double.POSITIVE_INFINITY;
                throw new ArithmeticException("Case of Positive Infinity 1.0/0.0");
            } else if (number1 <= -1 && number2 == 0) {
                result = Double.NEGATIVE_INFINITY;
                throw new ArithmeticException("Case of Negative Infinity -1.0/0.0");
            } else {
                result = number1 / number2;
            }
        } catch (ArithmeticException error) {
            logger.error("[EXCEPTION - DIVISION] - Cannot be divided by ZERO " + error.getLocalizedMessage());
        } finally {
            logger.info("[RESULT - DIVISION] - " + result);
        }
        return result;
    }
}
