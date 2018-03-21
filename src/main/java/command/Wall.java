package command;

import com.sun.scenario.effect.impl.prism.ps.PPSRenderer;
import command.interfaces.Command;
import database.DatabaseSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wall implements Command {

    private static final String QUERY = "SELECT user, post, postedAt FROM POSTS WHERE user IN ( SELECT followed FROM FOLLOWERS WHERE follower = ? ) OR user = ? ORDER BY postedAt DESC";

    /**
     * Select user wall
     * @param input
     * @throws SQLException
     */
    @Override
    public void execute( String input ) throws SQLException {

        System.out.println("DoWall");

        String user = input.split("\\s+" )[ 0 ];

        ResultSet resultSet;

        try( PreparedStatement preparedStatement = DatabaseSingleton.getInstance().getConnection().prepareStatement( QUERY ) ) {

            preparedStatement.setString( 1, user );
            preparedStatement.setString( 2, user );
            resultSet = preparedStatement.executeQuery();

            while( resultSet.next() ) {

                System.out.println(resultSet.getString( "user" ));
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
