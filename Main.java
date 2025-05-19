package PE_EAL;

import java.util.ArrayList;
import java.util.List;

import PE_EAL.Order.Order;
import PE_EAL.Order.OrderService;
import PE_EAL.Product.Product;
import PE_EAL.Product.ProductService;
import PE_EAL.Utils.MenUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("### Pre Entrega del Proyecto, de Eduardo Antonio Lucero ###\n");
        String[] opMain = { "1. Manejar Productos\t", "2. Manejar Pedidos\t", "3. Salir" };
        MenUtils.menuMain(opMain);
    }
}