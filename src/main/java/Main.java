import command.interfaces.Command;
import database.DatabaseSingleton;
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

        DatabaseSingleton.getInstance().createTables();

        try{
            do {
                input = bufferedReader.readLine();

                if( ! "q".equals( input ) && input != null ) {
                    CommandFactory commandFactory = new CommandFactory();
                    Command command = commandFactory.getCommand( input );
                    command.execute( input );
                }

            } while( ! "q".equals( input ) );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        catch ( NoCommandException e ) {
            e.printStackTrace();
        }
    }
}
