package command;

import com.sun.scenario.effect.impl.prism.ps.PPSRenderer;
import command.interfaces.Command;
import database.DatabaseSingleton;
import org.h2.engine.Database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Post implements Command {

    private static final String QUERY = "INSERT INTO POSTS( user, post ) VALUES(?,?)";

    /**
     * Insert post
     * @param input
     * @throws SQLException
     */
    @Override
    public void execute( String input ) throws SQLException {

        System.out.println("DoPost");

        String[] inputSplitted = input.split("\\s+->\\s+" );
        String user = inputSplitted[ 0 ];
        String post = inputSplitted[ 1 ];

        try( PreparedStatement preparedStatement = DatabaseSingleton.getInstance().getConnection().prepareStatement( QUERY ) ) {

            preparedStatement.setString( 1, user );
            preparedStatement.setString( 2, post );
            preparedStatement.executeUpdate();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }

    }
}
