package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * This method queries for specific users based on user entered
     * search criteria, returning all if the criteria is empty
     * @param searchQuery the user's criteria
     * @return The queried list of users
     */
    public List<User> getSpecificUsers(String searchQuery) {
        logger.info("Currently in method 'getSpecificUsers()'.");
        Database database = Database.getInstance();
        Connection connection = null;
        List<User> specificUsers = new ArrayList<User>();
        String sql = "SELECT * FROM users WHERE id LIKE '%" + searchQuery +
                "%' OR first_name LIKE '%" + searchQuery +
                "%' or last_name LIKE '%" + searchQuery +
                "%' or date_of_birth LIKE '%" + searchQuery + "%'";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                specificUsers.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("Encountered an SQLException: ", e);
        } catch (Exception e) {
            logger.error("Encountered an Exception: ", e);
        }
        return specificUsers;
    }

    /**
     * This method creates users from results sets
     * @param results the result set
     * @return the created user
     * @throws SQLException
     */
    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));
        user.setDateOfBirth(results.getDate("date_of_birth"));
        // TODO map the remaining fields
        return user;
    }

}