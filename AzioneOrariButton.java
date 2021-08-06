
/*
Vengono definite le funzionalità dei bottoni degli orari di consegna, in modo da poterle richiamare e
quindi dichiarare una volta sola
 */

import java.sql.*;

public class AzioneOrariButton {
    Statement statement;

    public AzioneOrariButton(String orario) throws SQLException {
        DBManager.setConnection(
                Utils.JDBC_Driver_SQLite,
                Utils.JDBC_URL_SQLite);
        statement = DBManager.getConnection().createStatement();

        try {
            /*
             * Simple query for testing that everything is OK. If an exception raised, the
             * db is deleted and created from scratch.
             */
            statement.executeQuery("SELECT * FROM book LIMIT 1");
        } catch (SQLException e) {
            statement.executeUpdate("DROP TABLE IF EXISTS book");
            statement.executeUpdate("CREATE TABLE book (" + "id INTEGER PRIMARY KEY, " + "title VARCHAR(30), "
                    + "author VARCHAR(30), " + "pages INTEGER)");

            statement.executeUpdate(
                    "INSERT INTO book (id, title, author, pages) VALUES(1, 'The Lord of the Rings', 'Tolkien', 241)");
            statement.executeUpdate("INSERT INTO book (id, title, author, pages) VALUES(2, 'Fight Club', 'Palahniuk', 212)");
            statement.executeUpdate(
                    "INSERT INTO book (id, title, author, pages) VALUES(3, 'Computer Networks', 'Tanenbaum', 313)");
            statement.executeUpdate(
                    "INSERT INTO book (id, title, author, pages) VALUES(4, 'Affective Computing', 'Picard', 127)");
        }
    }
}
