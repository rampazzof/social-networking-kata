package command;

import command.interfaces.Command;

public class Post implements Command {

    public Post() {
        super();
    }

    @Override
    public void execute() {
        System.out.println("DoPost");
    }
}
