package PE_EAL.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PE_EAL.Order.Order;
import PE_EAL.Order.OrderService;
import PE_EAL.Product.Product;
import PE_EAL.Product.ProductService;

public class MenUtils {
    public static final Scanner sc = new Scanner(System.in);
    

    public static void menuMain(String[] options) {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
 
        int op = getOption(1, options.length + 1, options);

        do {
            switch (op) {
                case 1: {
                    List<Product> products = new ArrayList<>();
                    productService.methods(products);
                    break;
                }
                case 2: {
                    List<Order> orders = new ArrayList<>();
                    orderService.methods(orders);
                    break;
                }
                case 3:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (op != 3);

        System.exit(0);
    } 
    
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

      

    public static void menuProducts(String[] options) {
        
    }  

    public static void menuOrders(String[] options) {
        
    }  
}