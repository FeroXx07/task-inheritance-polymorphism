package utility;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtility {
    public static void cleanInputBuffer(Scanner input) {
        while (true) {
            try {
                if (!(System.in.available() > 0))
                    break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            input.nextLine();
        }
    }

    // For reasons, I don't understand the cleanInputBuffer() doesn't clean the buffer after numeric mismatch exception
    // and throw exceptions goes infinitely.
    private static void forceCleanInputBuffer(Scanner input) {
        input.nextLine();
    }

    public static String fetchStringInput(Scanner input, String message) {
        String str = "";

        while (str.isEmpty()) {
            try {
                System.out.println(message);
                String newChar = input.nextLine();
                if (newChar.trim().isEmpty()) {
                    throw new InputMismatchException("Empty String");
                }
                str = newChar;
            } catch (InputMismatchException e) {
                System.err.println("Invalid string: " + e.getMessage());
            }
            cleanInputBuffer(input);
        }
        return str;
    }

    public static <T extends Number> T fetchNumber(Scanner input, String showMessage, String errorMessage, Class<T> type) {
        T number = null;
        boolean validNumber = false;
        while (!validNumber) {
            try {
                System.out.println(showMessage);
                number = readNumber(input, type);
                validNumber = true;
            } catch (InputMismatchException e) {
                System.err.println(errorMessage + ": " + e.getMessage());
                forceCleanInputBuffer(input);
            }
            //cleanInputBuffer(input);
            forceCleanInputBuffer(input);
        }
        return number;
    }

    // Since there are no reflection capabilities, it is imperative to pass class type
    @SuppressWarnings("unchecked")
    private static <T extends Number> T readNumber(Scanner input, Class<T> type) {
        if (type == Integer.class || type == int.class) {
            return (T) Integer.valueOf(input.nextInt());
        }
        if (type == Long.class || type == long.class) {
            return (T) Long.valueOf(input.nextLong());
        }
        if (type == Float.class || type == float.class) {
            return (T) Float.valueOf(input.nextFloat());
        }
        if (type == Double.class || type == double.class) {
            return (T) Double.valueOf(input.nextDouble());
        }
        if (type == Byte.class || type == byte.class) {
            return (T) Byte.valueOf(input.nextByte());
        }
        if (type == Short.class || type == short.class) {
            return (T) Short.valueOf(input.nextShort());
        }
        if (type == java.math.BigInteger.class) {
            return (T) input.nextBigInteger();
        }
        if (type == java.math.BigDecimal.class) {
            return (T) input.nextBigDecimal();
        }
        throw new IllegalArgumentException("Unsupported numeric type: " + type.getName());
    }
}
