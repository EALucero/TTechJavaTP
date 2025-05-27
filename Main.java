package TTechJavaTP;

import java.util.ArrayList;
import java.util.List;

import TTechJavaTP.orders.*;
import TTechJavaTP.products.*;
import TTechJavaTP.utils.MenUtils;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("### Pre Entrega del Proyecto, de Eduardo Antonio Lucero ###\n");
            String[] opMain = {
                    "1. Productos\t",
                    "2. Pedidos\t",
                    "3. Salir"
            };

            List<Product> products = new ArrayList<>();
            List<Order> orders = new ArrayList<>();

            ProductService productService = new ProductService();
            OrderService orderService = new OrderService();

            int op;
            do {
                op = MenUtils.getOption(1, opMain.length, opMain);
                switch (op) {
                    case 1 -> productService.methods(products);
                    case 2 -> orderService.methods(orders, products);
                    case 3 -> System.out.println("Saliendo...");
                }
            } while (op != 3);
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}