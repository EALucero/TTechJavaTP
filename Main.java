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
        System.out.println("### Pre Entrega del Proyecto, de Eduardo Antonio Lucero ###\n");
        String[] opMain = { "1. Manejar Productos\t", "2. Manejar Pedidos\t", "3. Salir" };

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
    }
}