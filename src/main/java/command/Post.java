package command;

import command.interfaces.Command;

public class Post implements Command {

    private static final String QUERY = "";

    @Override
    public void execute( String input ) {

        System.out.println("DoPost");

        String[] inputSplitted = input.split("\\s+->\\s+" );
        String user = inputSplitted[ 0 ];
        String post = inputSplitted[ 1 ];

        System.out.println(user);
        System.out.println(post);

        // TODO insert

    }
}
