package database;

import com.sun.scenario.effect.impl.prism.ps.PPSBlend_REDPeer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JDBCConnection {

    private static final String DB_DRIVER     = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:socialNetworkingKata;DB_CLOSE_DELAY=-1";
    private static final String DB_USER       = "";
    private static final String DB_PASSWORD   = "";

    private static final List<String> CREATE_DB_TABLES = Arrays.asList(
            "CREATE TABLE USERS(user VARCHAR(255), PRIMARY KEY(user))",
            "CREATE TABLE POST(follower VARCHAR(255), follow VARCHAR(255))",
            "CREATE TABLE FOLLOWERS( id BIGINT auto_increment NOT NULL, user VARCHAR(255), post VARCHAR(255), postedAt DATETIME default getDate(), PRIMARY KEY(id))"
    );

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        }
        catch ( SQLException e ) {
            System.out.println(e.getMessage());
        }
        return dbConnection;

    }

    public static void createTables() throws SQLException {

        Connection connection = getDBConnection();
        PreparedStatement preparedStatement = null;

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
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

    }
}
