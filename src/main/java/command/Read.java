package command;

import command.interfaces.Command;

public class Read implements Command {

    private static final String QUERY = "";

    @Override
    public void execute( String input ) {

        System.out.println("DoRead");

        String user = input;

        // TODO select
    }
}
