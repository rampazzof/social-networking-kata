package command;

import command.interfaces.Command;

public class Wall implements Command {
    public Wall() {
        super();
    }

    @Override
    public void execute() {
        System.out.println("DoWall");
    }
}
