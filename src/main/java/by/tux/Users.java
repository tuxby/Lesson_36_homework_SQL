package by.tux;

import java.sql.*;

public class Users {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String passwords = "postgres";

    private Connection connection;
    private Statement statement;

    public Users() {
        try{
            connection = DriverManager.getConnection(url,username,passwords);
            statement = connection.createStatement();
        }catch (Exception e) {
            System.out.println("ERROR!");
            throw new RuntimeException(e);
        }
    }

    private int executeUpdate(String query)  {
        try{
            int result = statement.executeUpdate(query);
            return result;
        }catch (Exception e) {
            System.out.println("executeUpdate() ERROR!");
            System.out.println("========");
            System.out.println(query);
            System.out.println("========");
            throw new RuntimeException(e);
        }
    }
    public void createTable()  {
        executeUpdate(
                "DROP TABLE IF EXISTS users160 CASCADE;");
        executeUpdate(
                "create table users160 (" +
                        "id serial," +
                        "first_name varchar(50)," +
                        "last_name varchar(50))");
    }

    public void addUser(String first_name,String last_name) {
        executeUpdate(
                "INSERT INTO users160 (first_name,last_name) " + "VALUES ('" + first_name + "','" + last_name + "')");
    }

    @Override
    public String toString() {
        String pets160 = "";
        try{
            ResultSet resultSet = statement.executeQuery("select * from users160");
            String leftAlignFormat = "| %-2d | %-15s | %-14s |\n";
            pets160 += "+---------------------------------------+\n";
            pets160 += "|            Table users160             |\n";
            pets160 += "+----+-----------------+----------------+\n";
            pets160 += "| ID |   FIRST NAME    |   LAST NAME    |\n";
            pets160 += "+----+-----------------+----------------+\n";

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                pets160 += new String(String.format(leftAlignFormat, id, first_name , last_name));
            }
            pets160 += "+----+-----------------+----------------+\n";
        }catch (Exception e) {
            //System.err.println("toString() ERROR!");
            throw new RuntimeException(e);
        }
        return pets160;
    }

    public void deleteUser(String firstName, String lastName)  {
        executeUpdate("delete from pets160 where pets160.user_id=(select id from users160 where first_name='"+firstName+"' and last_name='"+lastName+"');\n" +
                "delete from users160 where users160.first_name='"+firstName+"' and last_name='"+lastName+"';");
    }
}
