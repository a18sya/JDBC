package paket;

import java.sql.*;

public class SQL_Connection {

    final static String URL =  "jdbc:oracle:thin:@localhost:1522:BAZE";
    final static String USER =  "sys as sysdba";
    final static String PASSWORD =  "sys123";

    private Connection connection;

    public SQL_Connection() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            //statement.execute("INSERT INTO BOOKS(TITLE, AUTHOR, GENRE, YEAR, PAGE_COUNT) VALUES ('Властелин колец', 'Джон Толкин', 'Фантастика', 1954, 800)");
            boolean a = statement.execute("UPDATE BOOKS SET TITLE = 'ПРОВЕРКА' WHERE TITLE = 'Властелин колец'");
            System.out.println(a);

//            statement.addBatch("INSERT INTO BOOKS(TITLE, AUTHOR, GENRE, YEAR, PAGE_COUNT) VALUES ('Название 1', 'Автор 1', 'Жанр 1', 123, 100)");
//            statement.addBatch("INSERT INTO BOOKS(TITLE, AUTHOR, GENRE, YEAR, PAGE_COUNT) VALUES ('Название 2', 'Автор 2', 'Жанр 2', 456, 200)");
//            statement.addBatch("INSERT INTO BOOKS(TITLE, AUTHOR, GENRE, YEAR, PAGE_COUNT) VALUES ('Название 3', 'Автор 3', 'Жанр 3', 789, 300)");

            //statement.executeBatch();

            //statement.clearBatch();

            int rowsUpdated = statement.executeUpdate("UPDATE BOOKS SET AUTHOR = 'АВТОР' WHERE AUTHOR = 'Александр Пушкин'");

            System.out.println("Количество обновленных строк: " + rowsUpdated);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
