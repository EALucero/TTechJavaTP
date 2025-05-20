package PE_EAL.Product;

import java.util.List;
import java.util.Scanner;

import PE_EAL.Utils.MenUtils;

public class ProductService {

    public void methods(List<Product> products) {
        final Scanner sc = new Scanner(System.in);

        System.out.println("# Manejo de Productos #\n");
        System.out.println("Eliga una opción:\n");
        String[] options = { "1. Crear producto\t", "2. Listar productos\t", "3. Obtener producto\t",
                "4. Editar producto\t", "5. Eliminar producto\t", "6. Volver" };

        int opPr = MenUtils.getOption(1, options.length + 1, options);

        while (opPr < 1 || opPr > options.length) {
            System.out.println("Opción inválida:\n");
            MenUtils.printOptions(options);
            opPr = sc.nextInt();
        }

        while (opPr != options.length) {
            switch (opPr) {
                case 1:
                    createProduct(products);
                    break;
                case 2:
                    listProducts(products);
                    break;
                case 3:
                    getProductByNameOrId(products);
                    break;
                case 4: {
                    deleteProduct(products);
                    break;
                }
            }

            System.out.println("Elija una opción:\n");
            MenUtils.printOptions(options);
            opPr = sc.nextInt();
        }

        System.out.println("<=\n");
        options = new String[] { "1. Manejar Productos\t", "2. Manejar Pedidos\t", "3. Salir" };
        MenUtils.menuMain(options);
    }

    public void createProduct(List<Product> products) {
        Scanner scP = new Scanner(System.in);

        System.out.println("# Crear Producto #\n");
        System.out.println("Ingrese el nombre:");
        String name = scP.next();
        System.out.println("Ingrese el precio:");
        double price = scP.nextDouble();
        System.out.println("Ingrese la cantidad:");
        int quantity = scP.nextInt();
        scP.nextLine();

        Product pr = new Product(name, price, quantity);
        products.add(pr);
        System.out.println("Product created: " + pr.toString());
    }

    public void listProducts(List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }

    public Product getProductByNameOrId(List<Product> products) {
        System.out.println("# Obtener Producto #\n");

        if (products.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return null;
        }

        System.out.println("1. Nombre\t" + "2. ID");
        Scanner sc = new Scanner(System.in);
        int opNi = sc.nextInt();

        while (opNi < 1 || opNi > 2) {
            System.out.println("Opción inválida:\n");
            System.out.println("1. Nombre\t" + "2. ID");
            opNi = sc.nextInt();
        }

        if (opNi == 1) {
            System.out.println("Ingrese el nombre del producto:");
            String name = sc.next();

            for (Product product : products) {
                if (product.getProductName().equalsIgnoreCase(name)) {
                    System.out.println(product.toString());
                    return product;
                }
            }

            System.out.println("No se encontró el producto con el nombre: " + name);
            return null;
        } else if (opNi == 2) {
            System.out.println("Ingrese el ID del producto:");
            opNi = sc.nextInt();

            for (Product product : products) {
                if (product.getProductId() == opNi) {
                    System.out.println(product.toString());
                    return product;
                }
            }

            System.out.println("No se encontró el producto con el ID: " + opNi);
            return null;
        }

        System.out.println("Opción inválida:\n");
        return null;
    }

    public void updateProduct(List<Product> products) {
        if (products != null) {
            System.out.println("# Actualizar Producto #\n");
            System.out.println("Ingrese el ID del producto a actualizar:");
            Scanner scU = new Scanner(System.in);
            int productId = scU.nextInt();

            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProductId() == productId) {
                    System.out.println("Ingrese el nuevo nombre del producto:");
                    String name = scU.next();
                    System.out.println("Ingrese el nuevo precio del producto:");
                    double price = scU.nextDouble();
                    System.out.println("Ingrese la nueva cantidad del producto:");
                    int quantity = scU.nextInt();

                    Product product = new Product(name, price, quantity);
                    products.set(i, product);
                    System.out.println("Product updated: " + product.toString());
                    return;
                }
            }
        }
    }

    public void deleteProduct(List<Product> products) {
        System.out.println("# Eliminar Producto #\n");
        System.out.println("Ingrese el ID del producto a eliminar:");
        Scanner scD = new Scanner(System.in);
        int productId = scD.nextInt();

        if (products.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return;
        }

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                products.remove(i);
                System.out.println("Producto eliminado.");
                return;
            }
        }

        System.out.println("No se encontró el producto con el ID: " + productId);
        return;
    }
}