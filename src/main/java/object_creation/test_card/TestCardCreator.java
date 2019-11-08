package object_creation.test_card;

import domain.RangeOfResearch;
import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Creator;
import object_creation.creation_utils.StringValueConverter;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.creation_utils.StringMatcher;
import object_creation.range_of_reserch.RangeOfResearchListCreator;
import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import config.TestCardAndParamMarks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TestCardCreator implements Creator<TestCard, Map<Integer, List<String>>> {

    @NonNull
    private TestCardConfig config;
    private List<String> titleRow;

    @Override
    public TestCard create(Map<Integer, List<String>> input) throws RecognizeParamTypeException {
        TestCard testCard;
        List<List<String>> header;
        List<RangeOfResearch> rangeOfResearchList;

        List<List<String>> inputList = removeEverythingBeforeHeader(convertMapToList(searchAndRemoveEmptyLines(input)));
        inputList = removeNotMarkedLines(inputList);

        header = getHeader(inputList);
        inputList = removeHeader(inputList, header);

        rangeOfResearchList = createRangeOfResearchList(inputList);

        testCard = new TestCard().builder()
                .header(header)
                .rangeOfResearchList(rangeOfResearchList)
                .punctation(getGeneralPunctation(header))
                .build();

        return testCard;
    }

    private Integer getGeneralPunctation(List<List<String>> header){
        StringValueConverter converter = new StringValueConverter();
        Integer punctation = converter.castToInteger(header.get(0).get(config.getColumnsNumbers().getPunctationColumnNumber()));
        return punctation;
    }

    private List<List<String>> removeNotMarkedLines(List<List<String>> input) {
        Integer inputSize = input.size();
        Integer paramTypeColumnNumber = config.getColumnsNumbers().getParamTypeColumnNumber();

        for (int i = 0; i < inputSize; i++) {

            List<String> line = input.get(i);
            Integer lineSize = line.size();

            if (lineSize > paramTypeColumnNumber) {
                String readParamType = line.get(paramTypeColumnNumber);

                if (readParamType == null || readParamType.equals("")) {
                    input.remove(i);
                    inputSize--;
                    i--;
                }
            } else {
                System.out.println("remove line with\t=>\t" + line.get(config.getColumnsNumbers().getNameInPolishColumnNumber()));
                input.remove(i);
                inputSize--;
                i--;
            }
        }
        return input;
    }

    private List<RangeOfResearch> createRangeOfResearchList(List<List<String>> input) throws RecognizeParamTypeException {
        RangeOfResearchListCreator rangeOfResearchListCreator = new RangeOfResearchListCreator(config);

        return rangeOfResearchListCreator.create(input);
    }

    private List<List<String>> getHeader(List<List<String>> input) throws IllegalArgumentException {
        Integer rangeOfResearchColumnNumber = config.getColumnsNumbers().getRangeOfResearchColumnNumber();
        String headerMark = config.getParamTypes().getHEADER_TYPE();
        String rangeOfResearchMark = config.getParamTypes().getRANGE_OF_RESEARCH_MARK();

        List<List<String>> header = new ArrayList<>();

        Integer inputSize = input.size();
        int marks = 0;

        for (int i = 0; i < inputSize; i++) {
            List<String> line = input.get(i);
            if (line.size() > rangeOfResearchColumnNumber) {
                String prefix = line.get(rangeOfResearchColumnNumber);

                if (prefix.matches(rangeOfResearchMark))
                    marks++;

                if (marks == 2) {
                    return header;
                }

                if (prefix.equals(headerMark) || prefix.equals(rangeOfResearchMark))
                    header.add(input.get(i));
            }
        }
        throw new IllegalArgumentException(TestCardStatusEnum.CANT_GET_HEADER.toString());
    }

    private List<List<String>> removeHeader(List<List<String>> input, List<List<String>> header) {
        header.stream()
                .forEach(input::remove);

        return input;
    }

    private List<List<String>> removeEverythingBeforeHeader(List<List<String>> input) throws IllegalArgumentException {
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        TestCardAndParamMarks testCardMarks = config.getParamTypes();
        Integer inputSize = input.size();

        for (int i = 0; i < inputSize; i++) {
            List<String> line = input.get(i);
            Integer rangeOfResearchColumnNumber = columnsNumbers.getRangeOfResearchColumnNumber();
            String rangeOfResearchReadMark = line.get(rangeOfResearchColumnNumber);
            Integer nameColumnNumber = columnsNumbers.getNameInPolishColumnNumber();

            if (StringMatcher.isMatch(rangeOfResearchReadMark, testCardMarks.getRANGE_OF_RESEARCH_MARK())) {
                if (StringMatcher.isMatch(line.get(nameColumnNumber), testCardMarks.getTestCardBeginWordOrSentence() + ".+"))
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
