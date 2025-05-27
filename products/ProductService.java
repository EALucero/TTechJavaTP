package TTechJavaTP.products;

import java.util.List;

import TTechJavaTP.utils.MenUtils;

public class ProductService {

    public void methods(List<Product> products) {
        System.out.println("# Manejo de Productos #\n");
        String[] options = {
                "1. Crear producto\t",
                "2. Listar productos\t",
                "3. Obtener producto\t",
                "4. Editar producto\t",
                "5. Eliminar producto\t",
                "6. Volver"
        };

        int opPr;
        do {
            opPr = MenUtils.getOption(1, options.length, options);
            switch (opPr) {
                case 1 -> createProduct(products);
                case 2 -> listProducts(products);
                case 3 -> getProductByNameOrId(products);
                case 4 -> updateProduct(products);
                case 5 -> deleteProduct(products);
                case 6 -> System.out.println("<=\n");
            }
        } while (opPr != options.length);
    }

    public void createProduct(List<Product> products) {
        System.out.println("# Crear Producto #\n");
        String name = MenUtils.readString("Ingrese el nombre: ");
        double price = MenUtils.readDouble("Ingrese el precio: ", 0, Double.MAX_VALUE);
        int quantity = MenUtils.readInt("Ingrese la cantidad: ", 0, Integer.MAX_VALUE);

        Product pr = new Product(name, price, quantity);
        products.add(pr);
        System.out.println("Producto creado: " + pr.toString());
    }

    public void listProducts(List<Product> products) {
        if (!MenUtils.validateList("productos", products)) return;
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }

    public Product getProductByNameOrId(List<Product> products) {
        if (!MenUtils.validateList("productos", products)) return null;
        System.out.println("# Obtener Producto #\n");

        int opNi = MenUtils.readInt("Buscar por: 1. Nombre\t2. ID\n", 1, 2);
        if (opNi == 1) {
            String name = MenUtils.readString("Ingrese el nombre del producto: ");
            for (Product product : products) {
                if (product.getProductName().equalsIgnoreCase(name)) {
                    System.out.println(product.toString());
                    return product;
                }
            }
            System.out.println("No se encontró el producto con el nombre: " + name);
            return null;
        } else {
            int id = MenUtils.readInt("Ingrese el ID del producto: ", 0, Integer.MAX_VALUE);
            for (Product product : products) {
                if (product.getProductId() == id) {
                    System.out.println(product.toString());
                    return product;
                }
            }
            System.out.println("No se encontró el producto con el ID: " + id);
            return null;
        }
    }

    public void updateProduct(List<Product> products) {
        if (!MenUtils.validateList("productos", products)) return;
        System.out.println("# Actualizar Producto #\n");

        int productId = MenUtils.readInt("Ingrese el ID del producto a actualizar: ", 0, Integer.MAX_VALUE);
        for (Product product : products) {
            if (product.getProductId() == productId) {
                String name = MenUtils.readString("Ingrese el nuevo nombre del producto: ");
                double price = MenUtils.readDouble("Ingrese el nuevo precio del producto: ", 0, Double.MAX_VALUE);
                int quantity = MenUtils.readInt("Ingrese la nueva cantidad del producto: ", 0, Integer.MAX_VALUE);

                product.setProductName(name);
                product.setProductPrice(price);
                product.setProductQuantity(quantity);

                System.out.println("Producto actualizado: " + product.toString());
                return;
            }
        }
        System.out.println("No se encontró el producto con el ID: " + productId);
    }

    public void deleteProduct(List<Product> products) {
        if (!MenUtils.validateList("productos", products)) return;
        System.out.println("# Eliminar Producto #\n");

        int productId = MenUtils.readInt("Ingrese el ID del producto a eliminar: ", 0, Integer.MAX_VALUE);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                System.out.println(products.get(i).toString());
                System.out.println("<!> Esta accion no se puede deshacer <!>");

                String confirm = MenUtils.readString("Escriba 'SI' para confirmar: ");
                if (confirm.equalsIgnoreCase("SI")) {
                    products.remove(i);
                    System.out.println("Producto eliminado.");
                } else {
                    System.out.println("Cancelado.");
                }
                return;
            }
        }
        System.out.println("No se encontró el producto con el ID: " + productId);
    }
}