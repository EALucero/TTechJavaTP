/* package TTechJavaTP.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import TTechJavaTP.Product.Product;
import TTechJavaTP.Product.ProductService;
import TTechJavaTP.Utils.MenUtils;

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
} */

package TTechJavaTP.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import TTechJavaTP.Product.Product;
import TTechJavaTP.Product.ProductService;
import TTechJavaTP.Utils.MenUtils;

public class OrderService {

    public void methods(List<Order> orders, List<Product> products) {
        final Scanner sc = new Scanner(System.in);

        System.out.println("# Manejo de Pedidos #\n");
        String[] options = { "1. Crear pedido\t", "2. Listar pedidos", "3. Volver" };

        int opOr = MenUtils.getOption(1, options.length + 1, options);

        while (opOr < 1 || opOr > options.length) {
            System.out.println("Opción inválida:\n");
            MenUtils.printOptions(options);
            try {
                opOr = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número.");
                opOr = -1;
            }
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
            try {
                opOr = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número.");
                opOr = -1;
            }
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
        String customerName = scO.nextLine();
        System.out.println("Ingrese los productos a comprar (por ID) o '0' para terminar:");
        productService.listProducts(products);

        Product aux;
        double total = 0;
        int opO = -1;

        while (true) {
            System.out.println("Ingrese el ID del producto o '0' para terminar:");
            try {
                opO = Integer.parseInt(scO.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Intente de nuevo.");
                continue;
            }
            if (opO == 0) break;

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

            int opNi = 0;
            while (true) {
                System.out.println("Cantidad:");
                try {
                    opNi = Integer.parseInt(scO.nextLine());
                    if (opNi <= 0) {
                        System.out.println("Cantidad inválida.");
                        continue;
                    }
                    if (opNi > selectedProduct.getProductQuantity()) {
                        System.out.println("No hay suficiente stock.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Cantidad inválida. Intente de nuevo.");
                }
            }

            aux = new Product(selectedProduct.getProductName(), selectedProduct.getProductPrice() * opNi, opNi);
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