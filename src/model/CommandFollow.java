package model;

public class CommandFollow implements Command {
    public CommandFollow() {
        super();
    }

    @Override
    public void execute() {
        System.out.println("DoFollow");
    }
}
