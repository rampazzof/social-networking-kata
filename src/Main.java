/*

 */

import command.interfaces.Command;
import exception.NoCommandException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main( String[]  args) {

        System.out.println("Job started.. Type \"q\" to quit");
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
        String input = null;
        try {
            do {
                input = bufferedReader.readLine();
                if( ! "q".equals( input ) ) {
                    System.out.println( input );
                    CommandFactory commandFactory = new CommandFactory();
                    Command command = commandFactory.getCommand( input );
                    command.execute();
                }
            } while( ! "q".equals( input ) );

            System.out.println( "exit" );
        }
        catch ( NoCommandException e ) {
            System.out.println( e.getMessage() );
            e.printStackTrace();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }

    }
}
