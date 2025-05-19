package PE_EAL.Order;
import java.util.ArrayList;
import java.util.List;
import PE_EAL.Product.Product;

public class Order {
    private int id;
    private String date;
    private String name;
    private double total;
    private List<Product> products = new ArrayList<Product>();

    public Order(int orderId, String orderDate, String customerName, double totalAmount) {
        this.id = orderId;
        this.date = orderDate;
        this.name = customerName;
        this.total = totalAmount;
    }

    public int getOrderId() {
        return id;
    }

    public void setOrderId(int orderId) {
        this.id = orderId;
    }

    public String getOrderDate() {
        return date;
    }

    public void setOrderDate(String orderDate) {
        this.date = orderDate;
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
    
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}