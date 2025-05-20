package PE_EAL.Utils;

import java.util.Scanner;

public class MenUtils {
    public static final Scanner sc = new Scanner(System.in);

    public static void printOptions(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public static int getOption(int min, int max, String[] options) {
        System.out.println("Elija una opción:\n");
        printOptions(options);
        int op = sc.nextInt();

        while (op < min || op > max) {
            System.out.println("Opción inválida:\n");
            printOptions(options);
            op = sc.nextInt();
        }

        return op;
    }
}