package command;

import command.interfaces.Command;

public class Read implements Command {
    public Read() {
        super();
    }

    @Override
    public void execute() {
        System.out.println("DoRead");
    }
}
