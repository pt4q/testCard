package object_printing.printing;

import config.TestCardConfig;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.TestCardCalcModel;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TestCardPrinter implements Generator<String, TestCardCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public String generate(TestCardCalcModel input) {
        return generateStringLines(input).stream()
                .map(s -> s + "\n")
                .collect(Collectors.joining());
    }

    public List<String> generateStringLines(TestCardCalcModel testCard) {
        return new TestCardStringGenerator(config).generate(testCard);
    }


    private List<String> generateListOfRangeOfResearch() {
        return null;
    }
}
