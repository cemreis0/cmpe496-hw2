package service;

import model.Order;
import persistence.OrderFileWriter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderService {

    // Other Methods
    public void saveOrder(Order order) {
        String formattedOrder = formatOrder(order);
        String timestamp = generateTimestamp();
        OrderFileWriter.writeToFile(formattedOrder, timestamp);
    }

    private String generateTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return LocalDateTime.now().format(formatter);
    }

    private String formatOrder(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Timestamp: ").append(LocalDateTime.now()).append("\n\n");

        sb.append("Customer Info:\n");
        sb.append("Name: ").append(order.getPurchaser().getName()).append("\n");
        sb.append("Phone: ").append(order.getPurchaser().getPhone()).append("\n");
        sb.append("Postal Code: ").append(order.getPurchaser().getPostalCode()).append("\n");
        sb.append("Province: ").append(order.getPurchaser().getProvince()).append("\n");
        sb.append("City: ").append(order.getPurchaser().getCity()).append("\n");
        sb.append("Delivery Address: ").append(order.getPurchaser().getDeliveryAddress()).append("\n");
        sb.append("Date: ").append(order.getPurchaser().getTodaysDate()).append("\n");
        sb.append("Credit Card No: ").append(
                order.getPurchaser().getCreditCardNo().isEmpty() ? "(Paid in Cash)" : order.getPurchaser().getCreditCardNo()
        ).append("\n");
        sb.append("Validation ID: ").append(order.getPurchaser().getValidationId()).append("\n");

        sb.append("\nItems:\n");
        sb.append("--------------------------------\n");
        for (var item : order.getItems()) {
            sb.append(item.getNumber())
                    .append(" | Qty: ").append(item.getQuantity())
                    .append(" | $").append(String.format("%.2f", item.getCostPerItem()))
                    .append(" | Total: $").append(String.format("%.2f", item.getTotal()))
                    .append("\n");
        }
        sb.append("--------------------------------\n");
        sb.append("Balance Owing: $").append(String.format("%.2f", order.getBalanceOwing())).append("\n");

        return sb.toString();
    }

}
