package object_creation.creation_utils;

import org.joda.time.DateTime;

public class StringValueConverter {
    public Integer castToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Boolean castPositiveScoreToBoolean(String input) {
        input = input.toLowerCase();

        if (input.equals("ok"))
            return true;
        else if (input.equals("tak"))
            return true;
        else if (input.equals("yes"))
            return true;

        return false;
    }

    public DateTime convertStringToTime (String input){
        return DateTime.parse(input);
    }
}
