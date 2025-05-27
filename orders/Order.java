package TTechJavaTP.orders;

import java.util.ArrayList;
import java.util.List;

import TTechJavaTP.products.Product;

public class Order {
    private int id;
    private String name;
    private double total;
    private List<Product> products = new ArrayList<Product>();

    private static int nextId = 1;

    public Order(String customerName, double totalAmount, List<Product> products) {
        this.id = nextId++;
        this.name = customerName;
        this.total = totalAmount;
        this.products = products;
    }

    public int getOrderId() {
        return id;
    }

    public String getCustomerName() {
        return name;
    }

    public void setCustomerName(String customerName) {
        this.name = customerName;
    }

    public double getTotalAmount() {
        return total;
    }

    public void setTotalAmount(double totalAmount) {
        this.total = totalAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void show() {
        System.out.println("ID: " + id + " | Cliente: " + name + " | Total: $" + total);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
                .append(", Cliente: ").append(name)
                .append(", Total: $").append(total)
                .append(", Productos: [");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            sb.append(p.getProductName()).append(" (x").append(p.getProductQuantity()).append(")");
            if (i < products.size() - 1)
                sb.append(", ");
        }
        sb.append("].");
        return sb.toString();
    }
}