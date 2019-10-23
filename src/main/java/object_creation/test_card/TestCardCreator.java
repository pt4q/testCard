package object_creation.test_card;

import domain.TestCard;
import object_creation.creation_utils.Creator;
import object_creation.creation_utils.StringMatcher;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCardCreator implements Creator<TestCard, Map<Integer, List<String>>> {

    private String testCardBeginWordOrSentence = "KARTA ";
    private String rangeOfResearchPrefix = "#";

    @Override
    public TestCard create(Map<Integer, List<String>> input) throws IllegalArgumentException {
        TestCard testCard;

        List<List<String>> inputList = removeEverythingPreviousTestCardBegin(convertMapToList(searchAndRemoveEmptyLines(input)));

        return null;
    }

    private List<List<String>> removeEverythingPreviousTestCardBegin(List<List<String>> input) throws IllegalArgumentException {
        Integer inputSize = input.size();
        boolean removed = false;

        for (int i =0; i < inputSize; i++) {
            List<String> line = input.get(i);

            if (StringMatcher.isMatch(line.get(0),rangeOfResearchPrefix)){
                if (StringMatcher.isMatch(line.get(1),testCardBeginWordOrSentence + ".+"))
                    return input;
            }
            input.remove(i);
            i--;
        }
        throw new IllegalArgumentException(TestCardStatusEnum.CANT_FIND_BEGIN.toString());
    }

    private List<List<String>> convertMapToList(Map<Integer, List<String>> input) {
        return input.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    private Map<Integer, List<String>> searchAndRemoveEmptyLines(Map<Integer, List<String>> input) {
        Integer inputSize = input.size();

        for (int i = 0; i < inputSize; i++) {
            List<String> values = input.get(i);

            if (isStringListEmpty(values)) {
                input.remove(i);
            }
        }

        return input;
    }

    private boolean isStringListEmpty(List<String> strings) {
        return strings.size() == 0;
    }
}
