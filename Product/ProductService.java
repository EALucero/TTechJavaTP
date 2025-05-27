package TTechJavaTP.Product;

import java.util.List;
import java.util.Scanner;

import TTechJavaTP.Utils.MenUtils;

public class ProductService {

    public void methods(List<Product> products) {
        final Scanner sc = new Scanner(System.in);

        System.out.println("# Manejo de Productos #\n");
        String[] options = { "1. Crear producto\t", "2. Listar productos\t", "3. Obtener producto\t",
                "4. Editar producto\t", "5. Eliminar producto\t", "6. Volver" };

        int opPr = MenUtils.getOption(1, options.length + 1, options);

        while (opPr < 1 || opPr > options.length) {
            System.out.println("Opción inválida:\n");
            MenUtils.printOptions(options);
            try {
                opPr = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número.");
                opPr = -1;
            }
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
                case 4:
                    updateProduct(products);
                    break;
                case 5:
                    deleteProduct(products);
                    break;
            }

            System.out.println("Elija una opción:\n");
            MenUtils.printOptions(options);
            try {
                opPr = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número.");
                opPr = -1;
            }
        }

        System.out.println("<=\n");
        return;
    }

    public void createProduct(List<Product> products) {
        Scanner scP = new Scanner(System.in);

        System.out.println("# Crear Producto #\n");
        String name;
        double price = 0;
        int quantity = 0;

        System.out.println("Ingrese el nombre:");
        name = scP.nextLine();

        while (true) {
            System.out.println("Ingrese el precio:");
            try {
                price = Double.parseDouble(scP.nextLine());
                if (price < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido. Intente de nuevo.");
            }
        }

        while (true) {
            System.out.println("Ingrese la cantidad:");
            try {
                quantity = Integer.parseInt(scP.nextLine());
                if (quantity < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida. Intente de nuevo.");
            }
        }

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
        int opNi = 0;

        while (true) {
            try {
                opNi = Integer.parseInt(sc.nextLine());
                if (opNi == 1 || opNi == 2) break;
                System.out.println("Opción inválida:\n1. Nombre\t2. ID");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }

        if (opNi == 1) {
            System.out.println("Ingrese el nombre del producto:");
            String name = sc.nextLine();

            for (Product product : products) {
                if (product.getProductName().equalsIgnoreCase(name)) {
                    System.out.println(product.toString());
                    return product;
                }
            }

            System.out.println("No se encontró el producto con el nombre: " + name);
            return null;
        } else if (opNi == 2) {
            int id = 0;
            while (true) {
                System.out.println("Ingrese el ID del producto:");
                try {
                    id = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido. Intente de nuevo.");
                }
            }

            for (Product product : products) {
                if (product.getProductId() == id) {
                    System.out.println(product.toString());
                    return product;
                }
            }

            System.out.println("No se encontró el producto con el ID: " + id);
            return null;
        }

        System.out.println("Opción inválida:\n");
        return null;
    }

    public void updateProduct(List<Product> products) {
        if (products != null) {
            System.out.println("# Actualizar Producto #\n");
            Scanner scU = new Scanner(System.in);
            int productId = 0;

            while (true) {
                System.out.println("Ingrese el ID del producto a actualizar:");
                try {
                    productId = Integer.parseInt(scU.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido. Intente de nuevo.");
                }
            }

            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProductId() == productId) {
                    String name;
                    double price = 0;
                    int quantity = 0;

                    System.out.println("Ingrese el nuevo nombre del producto:");
                    name = scU.nextLine();

                    while (true) {
                        System.out.println("Ingrese el nuevo precio del producto:");
                        try {
                            price = Double.parseDouble(scU.nextLine());
                            if (price < 0) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Precio inválido. Intente de nuevo.");
                        }
                    }

                    while (true) {
                        System.out.println("Ingrese la nueva cantidad del producto:");
                        try {
                            quantity = Integer.parseInt(scU.nextLine());
                            if (quantity < 0) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Cantidad inválida. Intente de nuevo.");
                        }
                    }

                    Product product = new Product(name, price, quantity);
                    products.set(i, product);
                    System.out.println("Product updated: " + product.toString());
                    return;
                }
            }
            System.out.println("No se encontró el producto con el ID: " + productId);
        }
    }

    public void deleteProduct(List<Product> products) {
        System.out.println("# Eliminar Producto #\n");
        Scanner scD = new Scanner(System.in);
        int productId = 0;

        if (products.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return;
        }

        while (true) {
            System.out.println("Ingrese el ID del producto a eliminar:");
            try {
                productId = Integer.parseInt(scD.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Intente de nuevo.");
            }
        }

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                products.remove(i);
                System.out.println("Producto eliminado.");
                return;
            }
        }

        System.out.println("No se encontró el producto con el ID: " + productId);
    }
}