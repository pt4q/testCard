package object_creation.test_card;

import domain.RangeOfResearch;
import domain.TestCard;
import object_creation.creation_utils.Creator;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.creation_utils.StringMatcher;
import object_creation.range_of_reserch.RangeOfResearchListCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCardCreator implements Creator<TestCard, Map<Integer, List<String>>> {

    private String testCardBeginWordOrSentence = "KARTA ";
    private String rangeOfResearchMark = "#";
    private List<String> titleRow;

    @Override
    public TestCard create(Map<Integer, List<String>> input) throws RecognizeParamTypeException {
        TestCard testCard;
        List<List<String>> header;
        List<RangeOfResearch> rangeOfResearchList;

        List<List<String>> inputList = removeEverythingBeforeHeader(convertMapToList(searchAndRemoveEmptyLines(input)));

        header = getHeader(inputList);
        inputList = removeHeader(inputList, header);
        rangeOfResearchList = createRangeOfResearchList(inputList, rangeOfResearchMark);

        testCard = new TestCard().builder()
                .header(header)
                .rangeOfResearchList(rangeOfResearchList)
                .build();


        return testCard;
    }

    private List<RangeOfResearch> createRangeOfResearchList(List<List<String>> input, String rangeOfResearchMark) throws RecognizeParamTypeException {
        RangeOfResearchListCreator rangeOfResearchListCreator = new RangeOfResearchListCreator().builder()
                .rangeOfResearchMark(rangeOfResearchMark)
                .build();

        return rangeOfResearchListCreator.create(input);
    }

    private List<List<String>> getHeader(List<List<String>> input) throws IllegalArgumentException {
        List<List<String>> header = new ArrayList<>();
        Integer inputSize = input.size();
        int marks = 0;

        for (int i = 0; i < inputSize; i++) {
            String prefix = input.get(i).get(0);

            if (prefix.matches(rangeOfResearchMark))
                marks++;

            if (marks == 2)
                return header;

            header.add(input.get(i));
        }
        throw new IllegalArgumentException(TestCardStatusEnum.CANT_GET_HEADER.toString());
    }

    private List<List<String>> removeHeader(List<List<String>> input, List<List<String>> header) {
        header.stream()
                .forEach(input::remove);

        return input;
    }

    private List<List<String>> removeEverythingBeforeHeader(List<List<String>> input) throws IllegalArgumentException {
        Integer inputSize = input.size();

        for (int i = 0; i < inputSize; i++) {
            List<String> line = input.get(i);

            if (StringMatcher.isMatch(line.get(0), rangeOfResearchMark)) {
                if (StringMatcher.isMatch(line.get(1), testCardBeginWordOrSentence + ".+"))
                    return input;

            }
            input.remove(i);
            i--;
        }
        throw new IllegalArgumentException(TestCardStatusEnum.CANT_FIND_BEGIN.toString());
    }

    private List<List<String>> filterTitleRow(List<List<String>> input) {
        titleRow = input.get(0);
        input.remove(0);
        return input;
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
