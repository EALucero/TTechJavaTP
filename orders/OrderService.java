package TTechJavaTP.orders;

import java.util.ArrayList;
import java.util.List;

import TTechJavaTP.exceptions.insufficientStockException;
import TTechJavaTP.products.*;
import TTechJavaTP.utils.MenUtils;

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
                case 3 -> System.out.println("<=\n");
            }
        } while (opOr != options.length);
    }

    public void addOrder(List<Order> orders, List<Product> products) {
        if (!MenUtils.validateList("productos", products)) return;;
        System.out.println("# Crear Pedido #\n");

        ProductService productService = new ProductService();
        List<Product> lineOrder = new ArrayList<>();

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

            try {
                if (selectedProduct.getProductQuantity() == 0) {
                    throw new insufficientStockException("El producto " + selectedProduct.getProductName() + " no está disponible.");
                }

                int opNi = MenUtils.readInt("Cantidad: ", 1, Integer.MAX_VALUE);
                if (opNi > selectedProduct.getProductQuantity()) {
                    throw new insufficientStockException("Stock insuficiente para el producto " + selectedProduct.getProductName() +
                        ". Stock disponible: " + selectedProduct.getProductQuantity());
                }

                Product aux = new Product(selectedProduct.getProductName(), selectedProduct.getProductPrice() * opNi, opNi);
                total += selectedProduct.getProductPrice() * opNi;
                selectedProduct.setProductQuantity(selectedProduct.getProductQuantity() - opNi);

                lineOrder.add(aux);
                System.out.println("Producto agregado: " + aux.toString());
            } catch (insufficientStockException e) {
                System.out.println(e.getMessage());
            }
        }

        if (!lineOrder.isEmpty()) {
            orders.add(new Order(customerName, total, lineOrder));
            System.out.println("* Total del pedido: $" + total + " *");
        } else {
            System.out.println("No se agregaron productos al pedido.");
        }
    }

    public void listOrders(List<Order> orders) {
        if (!MenUtils.validateList("pedidos", orders)) return;
        System.out.println("# Listar Pedidos #\n");

        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).toString());
        }
    }
}