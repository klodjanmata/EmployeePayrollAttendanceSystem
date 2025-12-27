package Util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Helper {

    public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final Scanner scanner = new Scanner(System.in);

    public static String getStringFromUser(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }

    public static char getCharFromUser(String message) {
        return Helper.getStringFromUser(message).charAt(0);
    }

    public static int getIntFromUser(String message) {
        System.out.print(message + ": ");
        int value = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        return value;
    }

    public static float getFloatFromUser(String message) {
        System.out.print(message + ": ");
        float value = scanner.nextFloat();
        scanner.nextLine(); // consume the newline
        return value;
    }

    public static String convertListToString(List<String> values) {
        String result = "[";
        for (String value : values) {
            result += value + ", ";
        }
        result += "]";
        return result;
    }

    public static Boolean getBooleanFromUser(String message) {
        System.out.print(message + ": ");
        if (scanner.hasNextBoolean()) {
            boolean value = scanner.nextBoolean();
            scanner.nextLine(); // consume the newline
            return value;
        } else {
            scanner.nextLine(); // consume invalid input
            return null;
        }
    }

    public static LocalDate getLocalDateFromUser(String message) {
        System.out.println("Expected date format: dd.MM.yyyy");
        System.out.print(message + ": ");
        try {
            return LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
        } catch (Exception e) {
            return new Date().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }
    }

    public static Long getLongFromUser(String message) {
        System.out.println(message + ": ");
        long value = scanner.nextLong();
        scanner.nextLine(); // consume the newline
        return value;
    }
    public static String toUpperCase(String message){
       return message.toUpperCase();


    }

    }

