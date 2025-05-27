package TTechJavaTP.Order;

import java.util.ArrayList;
import java.util.List;

import TTechJavaTP.Product.*;
import TTechJavaTP.Utils.MenUtils;

public class OrderService {

    public void methods(List<Order> orders, List<Product> products) {
        System.out.println("# Manejo de Pedidos #\n");
        String[] options = {
                "1. Crear pedido\t",
                "2. Listar pedidos\t",
                "3. Volver"
        };

        int opOr;
        do {
            opOr = MenUtils.getOption(1, options.length, options);
            switch (opOr) {
                case 1 -> addOrder(orders, products);
                case 2 -> listOrders(orders);
                case 3 -> System.out.println("Saliendo...");
            }
        } while (opOr != options.length);       
    }

    public void addOrder(List<Order> orders, List<Product> products) {
        ProductService productService = new ProductService();
        List<Product> lineOrder = new ArrayList<>();

        if (products.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return;
        }

        System.out.println("# Crear Pedido #\n");

        String customerName = MenUtils.readString("Ingrese el nombre del cliente: ");
        System.out.println("Ingrese los productos a comprar (por ID) o '0' para terminar:");
        productService.listProducts(products);

        double total = 0;

        while (true) {
            int opO = MenUtils.readInt("Ingrese el ID del producto o '0' para terminar: ", 0, Integer.MAX_VALUE);
            if (opO == 0)
                break;

            Product selectedProduct = null;
            for (Product product : products) {
                if (product.getProductId() == opO) {
                    selectedProduct = product;
                    break;
                }
            }

            if (selectedProduct == null) {
                System.out.println("ID de producto no válido.");
                continue;
            }

            int opNi = MenUtils.readInt("Cantidad: ", 1, selectedProduct.getProductQuantity());
            if (opNi > selectedProduct.getProductQuantity()) {
                System.out.println("No hay suficiente stock.");
                continue;
            }

            Product aux = new Product(selectedProduct.getProductName(), selectedProduct.getProductPrice() * opNi, opNi);
            total += selectedProduct.getProductPrice() * opNi;
            selectedProduct.setProductQuantity(selectedProduct.getProductQuantity() - opNi);

            lineOrder.add(aux);
            System.out.println("Producto agregado: " + aux.toString());
        }

        if (!lineOrder.isEmpty()) {
            orders.add(new Order(customerName, total, lineOrder));
            System.out.println("Total del pedido: $" + total);
        } else {
            System.out.println("No se agregaron productos al pedido.");
        }
    }

    public void listOrders(List<Order> orders) {
        System.out.println("# Listar Pedidos #\n");
        if (orders.isEmpty()) {
            System.out.println("No hay pedidos disponibles.");
            return;
        }

        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).toString());
        }
    }
}