package ExceptionHandlingExamples;// File: ExceptionHandlingExamples.java
/**
 * This program demonstrates handling of common exceptions in Java,
 * covering both checked and unchecked exceptions. Each exception is triggered
 * in a meaningful scenario and handled with appropriate mechanisms.
 */

import java.io.*;
import java.sql.*;

public final class ExceptionHandlingExamples {

    public static void main(String[] args) {
        simulateIOException();
        simulateFileNotFoundException();
        simulateEOFException();
        simulateSQLException();
        simulateClassNotFoundException();
        simulateArithmeticException();
        simulateNullPointerException();
        simulateArrayIndexOutOfBoundsException();
        simulateClassCastException();
        simulateIllegalArgumentException();
        simulateNumberFormatException();
    }

    // Checked Exceptions

    // 1. IOException
    public static void simulateIOException() {
        try {
            // Attempt to read from a non-existent file
            FileReader reader = new FileReader("non_existent_file.txt");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // 2. FileNotFoundException
    public static void simulateFileNotFoundException() {
        try {
            // Attempt to open a file that does not exist
            FileInputStream file = new FileInputStream("missing_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    // 3. EOFException
    public static void simulateEOFException() {
        try (DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(new byte[]{}))) {
            // Attempt to read beyond the end of an empty stream
            dataInputStream.readUTF();
        } catch (EOFException e) {
            System.out.println("EOFException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // 4. SQLException
    public static void simulateSQLException() {
        try {
            // Attempt to connect to a non-existent database
            DriverManager.getConnection("jdbc:mysql://localhost:3306/nonexistentdb", "root", "password");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    // 5. ClassNotFoundException
    public static void simulateClassNotFoundException() {
        try {
            // Attempt to load a non-existent class
            Class.forName("com.nonexistent.Class");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    // Unchecked Exceptions

    // 6. ArithmeticException
    public static void simulateArithmeticException() {
        try {
            // Division by zero
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }

    // 7. NullPointerException
    public static void simulateNullPointerException() {
        try {
            // Accessing a null reference
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }

    // 8. ArrayIndexOutOfBoundsException
    public static void simulateArrayIndexOutOfBoundsException() {
        try {
            // Accessing an invalid index in an array
            int[] array = {1, 2, 3};
            int value = array[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    // 9. ClassCastException
    public static void simulateClassCastException() {
        try {
            // Invalid type casting
            Object obj = new Integer(10);
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }

    // 10. IllegalArgumentException
    public static void simulateIllegalArgumentException() {
        try {
            // Passing invalid argument to a method
            Thread thread = new Thread();
            thread.setPriority(11); // Invalid priority
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    // 11. NumberFormatException
    public static void simulateNumberFormatException() {
        try {
            // Invalid string to number conversion
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }
}
