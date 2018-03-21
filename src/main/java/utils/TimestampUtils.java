package utils;

import java.sql.Timestamp;
import java.util.Calendar;

public class TimestampUtils {

    public static String printInterval(Timestamp tsNow, Timestamp tsDb ) {

        Timestamp difference = new Timestamp( tsNow.getTime() - tsDb.getTime() );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( difference );

        int minutes = calendar.get( Calendar.MINUTE );
        int seconds = calendar.get( Calendar.SECOND );


        if( minutes > 0 ) {
            switch( minutes ) {
                case 1:
                    return "(" + String.valueOf( minutes ) + " minute ago)";
                default:
                    return "(" + String.valueOf( minutes ) + " minutes ago)";
            }
        }
        else {
            switch( seconds ) {
                case 1:
                    return "(" + String.valueOf( seconds ) + " second ago )";
                default:
                    return "(" + String.valueOf( seconds ) + " seconds ago )";
            }
        }
    }
}
