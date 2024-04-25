package paket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SQL_Connection db = new SQL_Connection();

        List<Book> books = new ArrayList<>();


        try (Statement statement = db.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOKS");

            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)));

                // ne rabotaet
                System.out.println(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Book book: books) {
            System.out.println(book);
        }

    }

}
