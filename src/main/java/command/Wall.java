package command;

import command.interfaces.Command;

public class Wall implements Command {

    private static final String QUERY = "";

    @Override
    public void execute( String input ) {

        System.out.println("DoWall");

        String user = input.split("\\s+" )[ 0 ];

        // TODO select
    }
}
