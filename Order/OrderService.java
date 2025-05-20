package PE_EAL.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PE_EAL.Product.Product;
import PE_EAL.Product.ProductService;
import PE_EAL.Utils.MenUtils;

public class OrderService {

    public void methods(List<Order> orders, List<Product> products) {
        final Scanner sc = new Scanner(System.in);

        System.out.println("# Manejo de Pedidos #\n");
        String[] options = { "1. Crear pedido\t", "2. Listar pedidos", "3. Volver" };

        int opOr = MenUtils.getOption(1, options.length + 1, options);

        while (opOr < 1 || opOr > options.length) {
            System.out.println("Opción inválida:\n");
            MenUtils.printOptions(options);
            opOr = sc.nextInt();
        }

        while (opOr != options.length) {
            switch (opOr) {
                case 1:
                    addOrder(orders, products);
                    break;
                case 2:
                    listOrders(orders);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
            }

            System.out.println("Elija una opción:\n");
            MenUtils.printOptions(options);
            opOr = sc.nextInt();
        }

        System.out.println("<=\n");
        return;
    }

    public void addOrder(List<Order> orders, List<Product> products) {
        ProductService productService = new ProductService();
        List<Product> lineOrder = new ArrayList<>();
        Scanner scO = new Scanner(System.in);

        if (products.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return;
        }

        System.out.println("# Crear Pedido #\n");

        System.out.println("Ingrese el nombre del cliente:");
        String customerName = scO.next();
        System.out.println("Ingrese los productos a comprar (por ID) o '0' para terminar:");
        productService.listProducts(products);

        Product aux;
        double total = 0;
        int opO = scO.nextInt();

        while (opO != -1) {
            if (opO == 0) {
                break;
            }

            for (Product product : products) {
                if (product.getProductId() == opO) {
                    System.out.println("Producto encontrado: " + product.getProductName());
                    System.out.println("Cantidad:");
                    int opNi = scO.nextInt();

                    if (opNi <= 0) {
                        System.out.println("Cantidad inválida.");
                        return;
                    }

                    if (opNi > product.getProductQuantity()) {
                        System.out.println("No hay suficiente stock.");
                        return;
                    }

                    aux = new Product(product.getProductName(), product.getProductPrice() * opNi, opNi);
                    total += product.getProductPrice() * opNi;
                    product.setProductQuantity(product.getProductQuantity() - opNi);

                    lineOrder.add(aux);
                    System.out.println("Producto agregado: " + aux.toString());

                    System.out.println("Ingrese el ID del siguiente producto o '0' para terminar:");
                    opO = scO.nextInt();
                }
            }
        }

        orders.add(new Order(customerName, total, lineOrder));
        System.out.println("Total del pedido: $" + total);
    }

    public void listOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return;
        }

        System.out.println("# Listar Pedidos #\n");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).toString());
        }
    }
}