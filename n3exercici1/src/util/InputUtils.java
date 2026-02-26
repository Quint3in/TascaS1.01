package util;

import java.util.Scanner;

public final class InputUtils {
    private InputUtils() {
    }

    public static int readValidNumber(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            scanner.nextLine();
            return number;
        }

        System.out.println("Valor no numeric.");
        enterToContinue(scanner);
        return -1;
    }

    public static String readValidString(Scanner scanner) {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }

        System.out.println("Valor no alfanumeric.");
        enterToContinue(scanner);
        return "";
    }

    public static void enterToContinue(Scanner scanner) {
        System.out.println("-------------------");
        System.out.println("Enter per continuar...");
        scanner.nextLine();
    }
}


