package command;

import command.interfaces.Command;
import database.DatabaseSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Follow implements Command {

    private static final String QUERY = "INSERT INTO FOLLOWERS( follower, followed ) VALUES(?,?)";

    /**
     * follower/followed relation
     * @param input
     */
    @Override
    public void execute( String input ) {

        String[] inputSplitted = input.split("\\s+follows\\s+" );
        String follower = inputSplitted[ 0 ];
        String followed = inputSplitted[ 1 ];

        try( PreparedStatement preparedStatement = DatabaseSingleton.getInstance().getConnection().prepareStatement( QUERY ) ) {

            preparedStatement.setString( 1, follower );
            preparedStatement.setString( 2, followed );
            preparedStatement.executeUpdate();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }

    }
}
