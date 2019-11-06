package object_printing;

import config.TestCardConfig;
import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TestCardPrinter implements Generator<String, TestCard> {

    @NonNull
    private TestCardConfig config;

    @Override
    public String generate(TestCard input) {
        return generateStringLines(input).stream()
                .map(s -> s + "\n")
                .collect(Collectors.joining());
    }

    public List<String> generateStringLines(TestCard testCard) {
        return null;
    }

    private Integer calcMaxColumnNumberFromConfig() {
        TestCardColumnSequencer columnSequencer = new TestCardColumnSequencer();
        return columnSequencer.calcMaxNumberOfColumn(config);
    }

    private List<String> generateListOfRangeOfResearch() {
        return null;
    }
}
