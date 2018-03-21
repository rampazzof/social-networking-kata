package command.interfaces;

import java.sql.SQLException;

public interface Command {

    public void execute( String input ) throws SQLException;

}
