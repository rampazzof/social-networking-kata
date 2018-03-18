package model;

public class CommandWall implements Command {
    public CommandWall() {
        super();
    }

    @Override
    public void execute() {
        System.out.println("DoWall");
    }
}
