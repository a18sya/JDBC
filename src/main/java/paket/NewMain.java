package paket;

import java.io.PipedReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NewMain {
    public static void main(String[] args) {
        SQL_Connection db = new SQL_Connection();

        List<Book> books = new ArrayList<>();

        try (PreparedStatement statement = db.getConnection().prepareStatement("INSERT INTO BOOKS(TITLE, AUTHOR, GENRE, YEAR, PAGE_COUNT) VALUES (?, ?, ?, ?, ?);")) {
            statement.setString(1, "Новое название");
            statement.setString(2, "Новый автор");
            statement.setString(1, "Новый жанр");
            statement.setInt(1, 123);
            statement.setInt(1, 456);

            statement.executeUpdate();
            db.closeConnection();
    } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Book book: books) {
            System.out.println(book);
        }

    }

}
