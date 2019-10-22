package object_creation.creation_utils;

public class ValueConverter {
    public Integer castToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Boolean castToBoolean(String input) {
        input = input.toLowerCase();

        if (input.equals("ok"))
            return true;
        else if (input.equals("tak"))
            return true;
        else if (input.equals("yes"))
            return true;

        return false;
    }
}
