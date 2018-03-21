import command.interfaces.Command;
import database.DatabaseSingleton;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main( String[]  args) {

        System.out.println( "Job started.. Type \"q\" to quit" );
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
        String input = null;

        DatabaseSingleton.getInstance().createTables();

        do {

            try{

                input = bufferedReader.readLine();

                if( ! "q".equals( input ) && input != null ) {

                    CommandFactory commandFactory = new CommandFactory();
                    Command command = commandFactory.getCommand( input );
                    command.execute( input );

                }
            }
            catch ( Exception e ) {

                e.printStackTrace();

            }

        } while( ! "q".equals( input ) );

    }

}
