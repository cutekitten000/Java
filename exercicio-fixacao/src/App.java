import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        sc.nextLine();

        Client client = new Client(clientName, clientEmail, birthDate);

        System.out.println();
        System.out.println("Enter order data:");
        System.out.print("Status (PROCESSING, PENDING_PAYMENT, SHIPPED, DELIVERED): ");
        String status = sc.nextLine();
        LocalDateTime dateNow = LocalDateTime.now();
        
        Order order = new Order(dateNow, OrderStatus.valueOf(status), client);
        
        System.out.println();
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:");
            sc.nextLine();
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem orderitem = new OrderItem(productQuantity, product.getPrice(), product);

            order.addItem(orderitem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);
    

        sc.close();
    }
}
