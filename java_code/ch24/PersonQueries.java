// Fig. 24.31: PersonQueries.java
// PreparedStatements used by the Address Book application.
package java_code.ch24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    private Connection connection; // manages connection
    private PreparedStatement selectAllPeople;
    private PreparedStatement selectPeopleByLastName;
    private PreparedStatement insertNewPerson;

    // constructor
    public PersonQueries() {

        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // create query that selects all entries in the AddressBook
            selectAllPeople = connection.prepareStatement("SELECT * FROM Addresses");

            // create query that selects entries with a specific last name
            selectPeopleByLastName = connection.prepareStatement("SELECT * FROM Addresses WHERE LastName = ?");

            // create query that selects entries with a specific the database
            insertNewPerson = connection.prepareStatement(
                    "INSERT INTO Addresses" + "(FirstName, LastName, Email, PhoneNumber)" + "VALUES (?, ?, ?, ?)");
        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    // select all of the addresses in the database
    public List<Person> getAllpeople() {

        List<Person> results = null;
        ResultSet resultSet = null;

        try {

            // executeQuery returns ResultSet containing matching entries
            resultSet = selectAllPeople.executeQuery();
            results = new ArrayList<Person>();

            while (resultSet.next()) {

                results.add(new Person(

                        resultSet.getInt("addressID"), resultSet.getString("FirstName"),
                        resultSet.getString("LastName"), resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber")));
            }
        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
        }

        finally {

            try {

                resultSet.close();
            } catch (SQLException sqlException) {

                sqlException.printStackTrace();
                close();
            }
        }

        return results;
    }

    // select person by last name
    public List<Person> getPeopleByLastName(String name) {

        List<Person> results = null;
        ResultSet resultSet = null;

        try {

            selectPeopleByLastName.setString(1, name); // specify last name

            // executeQuery returns ResultSet containing matching entries
            resultSet = selectPeopleByLastName.executeQuery();

            results = new ArrayList<Person>();

            while (resultSet.next()) {

                results.add(new Person(resultSet.getInt("addressID"), resultSet.getString("FirstName"),
                        resultSet.getString("LastName"), resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber")));
            }
        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
        } finally {

            try {

                resultSet.close();
            } catch (SQLException sqlException) {

                sqlException.printStackTrace();
                close();
            }
        }

        return results;
    }

    // and an entry
    public int addPerson(String fname, String lname, String email, String num) {

        int result = 0;

        // set parameters, then execute insertNewPerson
        try {

            insertNewPerson.setString(1, fname);
            insertNewPerson.setString(2, lname);
            insertNewPerson.setString(3, email);
            insertNewPerson.setString(4, num);

            // insert the new entry; returns # of rows updated
            result = insertNewPerson.executeUpdate();

        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
            close();
        }

        return result;
    }

    // close the database connection
    public void close() {

        try {

            connection.close();
        }

        catch (SQLException sqlException) {

            sqlException.printStackTrace();
        }
    }
} // end class PersonQueries