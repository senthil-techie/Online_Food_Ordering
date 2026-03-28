import DAO.DBConnection;
import DAO.MenuDAO;
import DAO.OrderDAO;
import DAO.UserDAO;
import Model.MenuItem;
import Model.Order;
import Model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public  class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MenuDAO menuDAO = new MenuDAO();
        UserDAO userDAO = new UserDAO();
        OrderDAO orderDAO = new OrderDAO();

        while (true) {
            System.out.println("\n===== ONLINE FOOD ORDERING SYSTEM =====");
            System.out.println("1. View Menu");
            System.out.println("2. Register User");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    List<MenuItem> menu = menuDAO.getAllMenuItems();
                    for (MenuItem item : menu) {
                        System.out.println(item.getId() + ". " + item.getName() + " ₹" + item.getPrice());
                    }
                    break;

                case 2:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    userDAO.addUser(new User(0, name, email, password));
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();

                    System.out.print("Enter Item ID: ");
                    int itemId = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    orderDAO.placeOrder(new Order(0, userId, itemId, qty, LocalDateTime.now()));
                    break;

                case 4:
                    orderDAO.viewOrders();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
