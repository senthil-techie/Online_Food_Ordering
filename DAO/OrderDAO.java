package DAO;

import DAO.DBConnection;
import Model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAO {

    public void placeOrder(Order order) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO orders(user_id, item_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getItemId());
            ps.setInt(3, order.getQuantity());

            ps.executeUpdate();

            System.out.println("Order Placed Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewOrders() {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "SELECT o.id, u.name, m.name AS item, o.quantity, o.order_date " +
                    "FROM orders o " +
                    "JOIN users u ON o.user_id = u.id " +
                    "JOIN menu m ON o.item_id = m.id";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "OrderID: " + rs.getInt("id") +
                                ", User: " + rs.getString("name") +
                                ", Item: " + rs.getString("item") +
                                ", Qty: " + rs.getInt("quantity") +
                                ", Date: " + rs.getTimestamp("order_date")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}