package PE_EAL;

import java.util.ArrayList;
import java.util.List;

import PE_EAL.Order.Order;
import PE_EAL.Order.OrderService;
import PE_EAL.Product.Product;
import PE_EAL.Product.ProductService;
import PE_EAL.Utils.MenUtils;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        String[] options = { "1. Manejar Productos\t", "2. Manejar Pedidos\t", "3. Salir" };
        System.out.println("### Pre Entrega del Proyecto, de Eduardo Antonio Lucero ###\n");
        int op = MenUtils.getOption(1, options.length + 1, options);

        do {
            switch (op) {
                case 1: {
                    List<Product> products = new ArrayList<>();
                    productService.methods(products);
                    continue;
                }
                case 2: {
                    List<Order> orders = new ArrayList<>();
                    orderService.methods(orders);
                    continue;
                }
                case 3:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (op != 3);
    }
}