package model;

public class CommandPost implements Command {

    public CommandPost() {
        super();
    }
    @Override
    public void execute() {
        System.out.println("DoPost");
    }
}
