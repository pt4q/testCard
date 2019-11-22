package ui;

import java.util.ArrayList;
import java.util.List;

public class FileNameProcessor implements Processor<List<String>, List<String>> {

    String quoteMark = "\"";

    @Override
    public List<String> process(List<String> input) {
        List<String> result = new ArrayList<>();
        boolean begin = false;
        boolean end = false;
        int inputSize = input.size();

        if (beginWithQuoteSign(input)) {
            for (int i = 0; i < inputSize; i++) {
                String actual = input.get(i);

            }
        }

        return input;
    }

    private boolean beginWithQuoteSign(List<String> input) {
        return quoteMark.equals(String.valueOf(input.get(0).charAt(0)));
    }


}
