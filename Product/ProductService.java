package PE_EAL.Product;

import java.util.List;
import java.util.Scanner;

import PE_EAL.Utils.MenUtils;

public class ProductService {

    public void methods(List<Product> products) {
        final Scanner sc = new Scanner(System.in);

        System.out.println("# Manejo de Productos #\n");
        System.out.println("Eliga una opción:\n");
        String[] options = { "1. Crear Producto\t", "2. Actualizar Producto\t", "3. Eliminar Producto\t",
                "4. Obtener Producto\t", "5. Volver" };
        MenUtils.printOptions(options);

        int opPr = sc.nextInt();

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
                    updateProduct(products);
                    break;
                case 3: {
                    System.out.println("Ingrese el ID del producto a eliminar:");
                    int productId = sc.nextInt();
                    deleteProduct(products, productId);
                    break;
                }
                case 4: {
                    System.out.println("Ingrese el ID del producto a obtener:");
                    int productId = sc.nextInt();
                    getProduct(productId);
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
        System.out.println("Ingrese el nombre del producto:");
        String name = scP.next();
        System.out.println("Ingrese la descripción del producto:");
        String description = scP.next();
        System.out.println("Ingrese el precio del producto:");
        double price = scP.nextDouble();
        scP.nextLine();

        Product pr = new Product(name, description, price);
        products.add(pr);
        System.out.println("Product created: " + pr.toString());

    }

    public void updateProduct(List<Product> products) {
        if (products != null) {
            System.out.println("# Actualizar Producto #\n");
            System.out.println("Ingrese el ID del producto a actualizar:");
            Scanner sc = new Scanner(System.in);
            int productId = sc.nextInt();
            System.out.println("Ingrese el nuevo nombre del producto:");
            /*
             * for (int i = 0; i < products.size(); i++) {
             * if (products.get(i).getProductId() == product.getProductId()) {
             * products.set(i, product);
             * System.out.println("Product updated: " + product);
             * return;
             * }
             * }
             */
        }
    }

    public void deleteProduct(List<Product> products, int productId) {
        // Logic to delete a product
    }

    public Product getProduct(int productId) {
        // Logic to retrieve a product by ID
        return null; // Placeholder return statement
    }
}