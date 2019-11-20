package object_creation.creation_utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatcher {

    public static boolean isMatch(String input, String regex) {
        return getMatcher(input, regex).matches();
    }

    public static boolean isInputContainsAWordAtBegin(String input, String word) {
        input = input.toLowerCase();
        word = "(" + word.toLowerCase() + "+.{1,})";

        return isMatch(input, word);
    }

    private static Matcher getMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher;
    }
}
