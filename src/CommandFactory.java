import model.*;

public class CommandFactory {

    private static final String POST = "POST";
    private static final String FOLLOW = "FOLLOW";
    private static final String WALL = "WALL";
    private static final String READ = "READ";

    public Command getCommand( String command ) {

        switch ( command ) {
            case POST:
                return new CommandPost();
            case FOLLOW:
                return new CommandFollow();
            case WALL:
                return new CommandWall();
            case READ:
                return new CommandRead();
            default:
                throw new RuntimeException("Comando non trovato");
        }
    }
}
