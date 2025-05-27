package TTechJavaTP.products;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    private static int nextId = 1;

    public Product(String productName, double productPrice, int productQuantity) { 
        this.id = nextId++;
        this.name = productName;
        this.price = productPrice;
        this.quantity = productQuantity;
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

    public double getProductPrice() {
        return price;
    }

    public void setProductPrice(double productPrice) {
        this.price = productPrice;
    }

    public int getProductQuantity() {
        return quantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.quantity = productQuantity;
    }


    public void show() {
        System.out.println("ID: " + id + " | Nombre: " + name + " | Precio: $" + price+ " | Cantidad: " + quantity);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + name + ", Precio: $" + price+ ", Cantidad: " + quantity + ".";
    }
}