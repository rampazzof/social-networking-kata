/*

 */

import model.Command;

import java.util.Scanner;

public class Main {
    public static void main( String[]  args) {

        System.out.println("Job started.. Type \"q\" to quit");
        Scanner scanner = new Scanner( System.in );
        String input = null;

        do {
            input = scanner.next();
            if( ! "q".equals( input ) ) {
                System.out.println( input );
                CommandFactory commandFactory = new CommandFactory();
                Command command = commandFactory.getCommand( input );
                command.execute();
            }
        } while( ! "q".equals( input ) );

        System.out.println( "exit" );
    }
}
