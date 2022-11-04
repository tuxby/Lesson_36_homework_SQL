package by.tux;

import java.sql.*;

public class Pets {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String passwords = "postgres";

    private Connection connection;
    private Statement statement;

    public Pets() {
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
    public void createTable() throws SQLException {
        executeUpdate(
                "DROP TABLE IF EXISTS pets160 CASCADE;");
        executeUpdate(
                "create table pets160 (" +
                "id serial," +
                "pet_name varchar(50)," +
                "pet_type varchar(50)," +
                "pet_age int," +
                "pet_weight int," +
                "user_id bigint)");
    }

    public void addPet(String pet_name,String pet_type,int pet_age,int pet_weight,long user_id) throws SQLException {
        executeUpdate(
                "INSERT INTO pets160 (pet_name,pet_type,pet_age,pet_weight,user_id) " + "VALUES ('" + pet_name + "','" + pet_type + "','" + pet_age + "','" + pet_weight + "','" + user_id + "')");
    }

    @Override
    public String toString() {
        String pets160 = "";
        try{
            ResultSet resultSet = statement.executeQuery("select * from pets160");
            String leftAlignFormat = "| %-2d | %-10s | %-10s | %-4d | %-4d | %-16s |\n";
            pets160 += "+----+------------+------------+------+------+------------------+\n";
            pets160 += "|                       Table pets160                           |\n";
            pets160 += "+----+------------+------------+------+------+------------------+\n";
            pets160 += "| ID |    NAME    |   TYPE     | AGE  |WEIGHT|       USER       |\n";
            pets160 += "+----+------------+------------+------+------+------------------+\n";

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pet_name = resultSet.getString("pet_name");
                String pet_type = resultSet.getString("pet_type");
                int pet_age = resultSet.getInt("pet_age");
                int pet_weight = resultSet.getInt("pet_weight");
                int userId = resultSet.getInt("user_id");
                String userFirstName = " - not found";
                String userLastName = "";
                try{
                    Statement statementFindUser = connection.createStatement();
                    ResultSet resultSetUser = statementFindUser.executeQuery("select id,first_name,last_name from users160 where id=" + userId);
                    while (resultSetUser.next()){
                        userFirstName = resultSetUser.getString("first_name");
                        userLastName = resultSetUser.getString("last_name");
                    }
                }catch (Exception e){
                }
                pets160 += new String(String.format(leftAlignFormat, id, pet_name , pet_type , pet_age, pet_weight , userFirstName + " " + userLastName ));
            }
            pets160 += "+----+------------+------------+------+------+------------------+\n";
        }catch (Exception e) {
            //System.err.println("toString() ERROR!");
            throw new RuntimeException(e);
        }
        return pets160;
    }
}
