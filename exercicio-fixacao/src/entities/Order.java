package entities;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

    private LocalDateTime moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {}

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }
    
    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double sum = 0;

        for (OrderItem item : items) {
            sum += item.subTotal();
        }

        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        double sum = 0;
        sb.append("Order moment: " + formatter.format(moment) + "\n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client: " + client.getName() + " " + sdf.format(client.getBirthDate()) + " - " + client.getEmail() + "\n");
        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sum += item.subTotal();
            sb.append(item.getProduct().getName() 
                        + ", $" + String.format("%.2f", item.getPrice()) 
                        + ", Quantity: " + item.getQuantity() 
                        + ", Subtotal: $" + String.format("%.2f", item.subTotal()) + "\n");
        }

        sb.append("Total price: $" + String.format("%.2f", sum));

        return sb.toString();
    }
}
