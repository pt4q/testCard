package ui;

import domain.IntegerTypeParam;
import object_creation.creation_utils.StringMatcher;

import java.util.ArrayList;
import java.util.List;

public class FileNameProcessor implements Processor<List<String>, List<String>> {

    private String quoteMark = "\"";
    private final String fileFormatRegex = "(.+\\.[A-Za-z]{1,5})";

    @Override
    public List<String> process(List<String> input) {
        StringBuilder sb = new StringBuilder();
        Integer inputSize = input.size();
        boolean fileName = false;
        int j;

        for (int i = 0; i < inputSize; i++) {
            String actual = input.get(i);
            String next;

            if (!StringMatcher.isMatch(actual, fileFormatRegex)) {
                j = i;
                sb.append(actual);
                do {
                    if (j < inputSize - 1)
                        j++;

                    next = input.get(j);
                    sb.append(" ").append(next);
                    input.remove(j);
                    j--;

                    if (StringMatcher.isMatch(next, fileFormatRegex)) {
                        input.set(i, sb.toString());
                        fileName = true;
                        inputSize = input.size();
                    }

                } while (!fileName);
            }
            fileName = false;
        }

        return input;
    }
}
