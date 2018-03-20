package database;

import java.sql.Connection;

public class DatabaseSingleton {


    private static DatabaseSingleton databaseSingleton = null;
    private static Connection con;


    public static DatabaseSingleton getInstance() {

        if( databaseSingleton == null ) {

            databaseSingleton = new DatabaseSingleton();

        }

        return databaseSingleton;
    }
}
