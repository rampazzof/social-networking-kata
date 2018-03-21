package command;

import com.sun.scenario.effect.impl.prism.ps.PPSRenderer;
import command.interfaces.Command;
import database.DatabaseSingleton;
import org.h2.engine.Database;

import javax.xml.crypto.Data;
import java.sql.*;

public class Post implements Command {

    private static final String QUERY = "INSERT INTO POSTS( user, post, postedAt ) VALUES(?,?,?)";

    /**
     * Insert post
     * @param input
     * @throws SQLException
     */
    @Override
    public void execute( String input ) {

        String[] inputSplitted = input.split("\\s+->\\s+" );
        String user = inputSplitted[ 0 ];
        String post = inputSplitted[ 1 ];

        try( PreparedStatement preparedStatement = DatabaseSingleton.getInstance().getConnection().prepareStatement( QUERY ) ) {

            preparedStatement.setString( 1, user );
            preparedStatement.setString( 2, post );
            preparedStatement.setTimestamp( 3, new Timestamp( System.currentTimeMillis() ) );
            preparedStatement.executeUpdate();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }

    }
}
