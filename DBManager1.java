/*import java.sql.*;

public class DBManager1 {
    public static final String JDBCDriverSQLite = "otg.sqlite.JDBC";
    public static final String JDBCURLSQLite = "jdbc:sqlite:test.db";

    protected Statement statement;
    protected Connection connection;

    public DBManager(String JDBCDriver, String JDBCURL) throws ClassNotFoundException {
        Class.forName(JDBCDriver);
        connection = DriverManager.getConnection(JDBCURL);
        statement = connection.createStatement();
        statement.setQueryTimeout(30);
        showMetadata();
    }

    public void showMetadata() throws SQLException {
        DatabaseMetaData md = connection.getMetaData();

        System.out.println("-- ResultSet Type --");
        System.out.println("Supports TYPE_FORWARD_ONLY: "
                + md.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
        System.out.println(("Supports TYPE_SCROLL_INSENSITIVE: "
                + md.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)));
        System.out.println(("Supports TYPE_SCROLL_SENSITIVE: "
                + md.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)));

        System.out.println();
    }
}
*/