package TTechJavaTP.utils;

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

    public static int readInt(String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value < min || value > max) {
                    System.out.println("Debe ingresar un número entre " + min + " y " + max + ".");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }

    public static int readInt(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }

    public static double readDouble(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(sc.nextLine());
                if (value < min || value > max) {
                    System.out.println("Debe ingresar un número entre " + min + " y " + max + ".");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }

    public static double readDouble(String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }

    public static String readString(String prompt) {
        String value;
        while (true) {
            System.out.print(prompt);
            value = sc.nextLine();
            if (!value.trim().isEmpty()) {
                return value;
            } else {
                System.out.println("El texto no puede estar vacío.");
            }
        }
    }
}