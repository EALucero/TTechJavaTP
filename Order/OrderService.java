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
        System.out.println("Eliga una opción:\n");
        String[] options = { "1. Crear Pedido\t", "2. Actualizar Producto\t", "3. Eliminar Producto\t",
                "4. Obtener Producto\t", "5. Salir" };

        int op = MenUtils.getOption(1, options.length + 1, options);

        switch (op) {
            case 1 -> addOrder(orders, products);
            /*
             * case 2 -> updateOrder(null);
             * case 3 -> deleteOrder(0);
             * case 4 -> getOrder(0);
             */
            case 5 -> System.out.println("Saliendo...");
        }
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

        Product aux;
        double total = 0;
        int opO = scO.nextInt();

        while (opO != -1) {
            productService.listProducts(products);

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
                    return;
                }
            }
        }

        orders.add(new Order(customerName, total, lineOrder));
        System.out.println("Total del pedido: $" + total);
    }
}