package TTechJavaTP.Utils;

import java.util.Scanner;

public class MenUtils {
    public static final Scanner sc = new Scanner(System.in);

    public static void printOptions(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public static int getOption(int min, int max, String[] options) {
        int op = -1;
        boolean valid = false;
        while (!valid) {
            System.out.println("Elija una opción:\n");
            printOptions(options);
            try {
                op = Integer.parseInt(sc.nextLine());
                if (op >= min && op <= max) {
                    valid = true;
                } else {
                    System.out.println("Opción fuera de rango.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
        return op;
    }
}