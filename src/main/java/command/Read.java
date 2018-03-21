package command;

import com.sun.scenario.effect.impl.prism.ps.PPSRenderer;
import command.interfaces.Command;
import database.DatabaseSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read implements Command {

    private static final String QUERY = "SELECT post, postedAt FROM POSTS WHERE user = ? ORDER BY postedAt DESC";

    /**
     * Select post
     * @param input
     * @throws SQLException
     */
    @Override
    public void execute( String input ) throws SQLException {

        System.out.println("DoRead");

        String user = input;

        ResultSet resultSet;

        try( PreparedStatement preparedStatement = DatabaseSingleton.getInstance().getConnection().prepareStatement( QUERY ) ) {

            preparedStatement.setString( 1, user );
            resultSet = preparedStatement.executeQuery();

            while( resultSet.next() ) {
                System.out.println(resultSet.getString( "post" ));
                System.out.println(resultSet.getTimestamp( "postedAt" ));
            }
            resultSet.close();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }

    }
}
