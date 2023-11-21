package org.group28jdbcjpaproject;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainSQLApp {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<Person> personList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS test_table (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "age INT NOT NULL)";

            statement.executeUpdate(createTableSQL);

            String insertSQL1 = "INSERT INTO test_table (name,age) VALUES ('First', 100)";
            String insertSQL2 = "INSERT INTO test_table (name,age) VALUES ('Second', 200)";

            statement.executeUpdate(insertSQL1);
            statement.executeUpdate(insertSQL2);

            System.out.println("Таблица создана и записи добавлены успешно");


            resultSet = statement.executeQuery("SELECT * FROM test_table ");

            while (resultSet.next()) {
                //System.out.println(resultSet.getString("name") + " " + resultSet.getInt("age"));
                personList.add(new Person(resultSet.getString("name"),resultSet.getInt("age")));

            }

        } catch (SQLException e) {e.printStackTrace(); }
        /*
        если не используете try-catch
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

         */
// =============== распечатаем нашу коллекцию =======

        System.out.println(personList);
    }
}
