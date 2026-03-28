package Model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private int userId;
    private int itemId;
    private int quantity;
    private LocalDateTime orderDate;

    public Order(int id, int userId, int itemId, int quantity, LocalDateTime orderDate) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public int getItemId() { return itemId; }
    public int getQuantity() { return quantity; }
    public LocalDateTime getOrderDate() { return orderDate; }

    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
}