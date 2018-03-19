package command;

import command.interfaces.Command;

public class Follow implements Command {

    public Follow() {
        super();
    }

    @Override
    public void execute() {
        System.out.println("DoFollow");
    }
}
