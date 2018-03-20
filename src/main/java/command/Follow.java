package command;

import command.interfaces.Command;

public class Follow implements Command {

    private static final String QUERY = "";

    /**
     * follower/followed relation.
     * Se il follower non è in db viene inserito un nuovo record
     * @param input
     */
    @Override
    public void execute( String input ) {

        System.out.println("DoFollow");

        String[] inputSplitted = input.split("\\s+" );
        String follower = inputSplitted[ 0 ];
        String followed = inputSplitted[ 1 ];

        //TODO insert
    }
}
