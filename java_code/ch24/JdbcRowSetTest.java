// Fig. 24.29: JdbcRowSetTest.java
// Displaying the contents of the Authors table using JdbcRowSet.
package java_code.ch24;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetTest {

    // JDBC driver name and database URL
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {

        // connect to database books and query database
        try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet()) {

            // specify JdbcRowSet properties
            rowSet.setUrl(DATABASE_URL);
            rowSet.setUsername(USER_NAME);
            rowSet.setPassword(PASSWORD);
            rowSet.setCommand("SELECT * FROM Authors"); // set query
            rowSet.execute();

            // process query results
            ResultSetMetaData metaData = rowSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.printf("Authors table of Books Database:%n%n");

            // display rowset header
            for (int i = 1; i <= numberOfColumns; i++)
                System.out.printf("%-8s\t", metaData.getCatalogName(i));

            // display each row
            while (rowSet.next()) {

                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-8s\t", rowSet.getObject(i));
                    System.out.println();
                }

            }
        } catch (SQLException e) {

            e.printStackTrace();
            System.exit(1);
        }
    }
}