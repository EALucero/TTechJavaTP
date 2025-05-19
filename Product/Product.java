package PE_EAL.Product;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;

    private static int nextId = 1;

    public Product(String productName, String productDescription, double productPrice) {
        this.id = nextId++;
        this.name = productName;
        this.description = productDescription;
        this.price = productPrice;
    }

    public int getProductId() {
        return id;
    }

    public void setProductId(int productId) {
        this.id = productId;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String productName) {
        this.name = productName;
    }

    public String getProductDescription() {
        return description;
    }

    public void setProductDescription(String productDescription) {
        this.description = productDescription;
    }

    public double getProductPrice() {
        return price;
    }

    public void setProductPrice(double productPrice) {
        this.price = productPrice;
    }

    public void mostrar() {
        System.out.println("ID: " + id + " | Nombre: " + name + " | Descripción: " + description + " | Precio: $" + price);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + name + ", Descripción: " + description + ", Precio: $" + price;
    }
}