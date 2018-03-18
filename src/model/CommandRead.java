package model;

public class CommandRead implements Command {
    public CommandRead() {
        super();
    }

    @Override
    public void execute() {
        System.out.println("DoRead");
    }
}
