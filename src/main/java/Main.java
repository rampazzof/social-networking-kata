import command.interfaces.Command;
import exception.NoCommandException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main( String[]  args) {

        System.out.println( "Job started.. Type \"q\" to quit" );
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
        String input;

        try {
            do {
                input = bufferedReader.readLine();
                if( ! "q".equals( input ) ) {
                    System.out.println( input );
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
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
