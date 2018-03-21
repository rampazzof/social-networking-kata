import command.*;
import command.interfaces.Command;
import exception.NoCommandException;

import java.util.regex.Pattern;

public class CommandFactory {

    private static final String POST    = "[a-zA-Z0-9]+\\s->\\s[a-zA-Z0-9]+";
    private static final String FOLLOW  = "[a-zA-Z0-9]+\\sfollows\\s[a-zA-Z0-9]+";
    private static final String WALL    = "[a-zA-Z0-9]+\\swall";
    private static final String READ    = "[a-zA-Z0-9]+";

    public Command getCommand( String command ) throws NoCommandException {

        if ( Pattern.matches( POST, command) ) {
            return new Post();
        }
        else if ( Pattern.matches( FOLLOW, command ) ) {
            return new Follow();
        }
        else if ( Pattern.matches( WALL, command ) ) {
            return new Wall();
        }
        else if ( Pattern.matches( READ, command ) ) {
            return new Read();
        }
        else {
            throw new NoCommandException( "Nessun pattern trovato" );
        }
    }
}
