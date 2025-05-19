package PE_EAL;

import java.util.ArrayList;
import java.util.Scanner;

import PE_EAL.Order.OrderService;
import PE_EAL.Product.ProductService;
import PE_EAL.Utils.MenUtils;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        
        String[] options = { "1. Manejar Productos\t", "2. Manejar Pedidos\t", "3. Salir" };
        System.out.println("### Pre Entrega del Proyecto, de Eduardo Antonio Lucero ###\n");
        int op;

        do {
            op = MenUtils.getOption(1, options.length, options, sc);

            switch (op) {
                case 1 -> productService.methods(new ArrayList<>());
                // case 2 -> orderService.methods(new ArrayList<>());
                case 3 -> System.out.println("Saliendo...");
            }
        } while (op != 3);
    }
}