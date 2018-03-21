package database;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class DatabaseSingleton {

    private static DatabaseSingleton jdbcConnection;
    private Connection connection;

    private final String DB_CONNECTION = "jdbc:h2:mem:socialNetworkingKata;DB_CLOSE_DELAY=-1";
    private final String DB_USER       = "";
    private final String DB_PASSWORD   = "";

    private final List<String> CREATE_DB_TABLES = Arrays.asList(
            "CREATE TABLE FOLLOWERS(follower VARCHAR(255) NOT NULL, followed VARCHAR(255) NOT NULL, PRIMARY KEY(follower, followed))",
            "CREATE TABLE POSTS( id BIGINT auto_increment NOT NULL, user VARCHAR(255), post VARCHAR(255), postedAt DATETIME default CURRENT_TIMESTAMP, PRIMARY KEY(id))"
    );

    private DatabaseSingleton() {}

    public static DatabaseSingleton getInstance() {

        return ( jdbcConnection == null ) ? jdbcConnection = new DatabaseSingleton() : jdbcConnection;

    }

    public Connection getConnection() {

        if( connection == null ) {

            try {
                connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            }
            catch ( SQLException e ) {
                System.out.println(e.getMessage());
            }
        }

        return connection;

    }

    public void createTables() {

        PreparedStatement preparedStatement = null;

        Connection connection = getConnection();

        try {
            connection.setAutoCommit( false );

            for( String query : CREATE_DB_TABLES ) {
                preparedStatement = connection.prepareStatement( query );
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            connection.commit();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }

    }
}
