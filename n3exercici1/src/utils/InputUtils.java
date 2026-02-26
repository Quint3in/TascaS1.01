package utils;

import java.util.Scanner;

public class InputUtils {
    public static int readValidNumber(Scanner scanner) {
        int number = -1;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Valor no númeric.");
            enterToContinue(scanner);
        }
        return number;
    }
    public static String readValidString(Scanner scanner) {
        String words = "";
        if (scanner.hasNextLine()) {
            words = scanner.nextLine();
        } else {
            System.out.println("Valor no alfanúmerico.");
            enterToContinue(scanner);
        }
        return words;
    }
    public static void enterToContinue(Scanner scanner) {
        System.out.println("------------------- \n" +
                "Enter per continuar...");
        scanner.nextLine();
    }
}
