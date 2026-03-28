package DAO;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public void addUser(User user) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();

            System.out.println("User Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
