package PE_EAL.Order;

import java.util.List;
import PE_EAL.Utils.MenUtils;

public class OrderService {

    public void methods(List<Order> or) { 
        System.out.println("# Manejo de Pedidos #\n");
        System.out.println("Eliga una opción:\n");
        String[] options = { "1. Crear Pedido\t", "2. Actualizar Producto\t", "3. Eliminar Producto\t",
                "4. Obtener Producto\t", "5. Salir" };

        int op = MenUtils.getOption(1, options.length + 1, options);

        switch (op) {
            case 1 -> createOrder(null);
            case 2 -> updateOrder(null);
            case 3 -> deleteOrder(0);
            case 4 -> getOrder(0);
            case 5 -> System.out.println("Saliendo...");
        }
        // orderService.addOrder(new Order(1, "2023-10-01", "Customer 1", 100.0));
        // orderService.removeArticle(new Article("Article 1", 20.0));
        // orderService.clearArticles();
        // int articleCount = orderService.getArticleCount();
        // double total = orderService.calculateTotal();
    }

    /* 
    public void addOrder(Order or) {
        List<Order> orders = new ArrayList<>();
        orders.add(or);
    }

    public void removeProduct(Product pr) {
        products.remove(pr);
    }

    public void clearProducts() {
        products.clear();
    }

    public int getArticleCount() {
        return articles.size();
    }

    public double calculateTotal() {
        double total = 0;
        for (Article article : articles) {
            total += article.getPrice();
        }
        return total;
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + id);
        System.out.println("Order Date: " + date);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Amount: " + total);
        System.out.println("Articles in Order:");
        for (Article article : articles) {
            System.out.println("- " + article.getName() + ": " + article.getPrice());
        }
    } */
 /* public void addArticle(Article article) {
        articles.add(article);
    }

    public void removeArticle(Article article) {
        articles.remove(article);
    }

    public void clearArticles() {
        articles.clear();
    }

    public int getArticleCount() {
        return articles.size();
    }

    public double calculateTotal() {
        double total = 0;
        for (Article article : articles) {
            total += article.getPrice();
        }
        return total;
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + id);
        System.out.println("Order Date: " + date);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Amount: " + total);
        System.out.println("Articles in Order:");
        for (Article article : articles) {
            System.out.println("- " + article.getName() + ": " + article.getPrice());
        }
    } */

    public void createOrder(Order order) {
        // Logic to create a new order  
    }

    public void updateOrder(Order order) {
        // Logic to update an order
    }

    public void deleteOrder(int orderId) {
        // Logic to delete an order
    }

    public Order getOrder(int orderId) {
        // Logic to retrieve an order by ID
        return null; // Placeholder return statement
    }

}