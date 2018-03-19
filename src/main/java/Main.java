import command.interfaces.Command;
import database.JDBCConnection;
import exception.NoCommandException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static void main( String[]  args) {

        System.out.println( "Job started.. Type \"q\" to quit" );
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
        String input;

        try {
            JDBCConnection.createTables();
            do {
                input = bufferedReader.readLine();
                if( ! "q".equals( input ) && input != null ) {
                    CommandFactory commandFactory = new CommandFactory();
                    try {
                        Command command = commandFactory.getCommand( input );
                        command.execute();
                    }
                    catch ( NoCommandException e ) {
                        e.printStackTrace();
                    }
                }
            } while( ! "q".equals( input ) );

            System.out.println( "exit" );
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
