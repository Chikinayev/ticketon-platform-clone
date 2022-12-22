package kz.ticketon.javaEE;

import java.sql.*;

public class DBManager {
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static User getUser(String email){
        User user = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from users where email=?");
            stmt.setString(1,email);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public static boolean addUser(User user){
        int rows = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into users(email, password) values(?,?)");
            stmt.setString(1,user.getEmail());
            stmt.setString(2,user.getPassword());
            rows = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0;
    }
}
