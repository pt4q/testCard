package object_printing.printing;

import config.TestCardConfig;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.TestCardCalcModel;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TestCardPrinter implements Generator<List<String>, TestCardCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<String> generate(TestCardCalcModel testCard) {
        return new TestCardStringGenerator(config).generate(testCard);
    }
    
    public String generateString(TestCardCalcModel input) {
        return generate(input).stream()
                .map(s -> s + "\n")
                .collect(Collectors.joining());
    }
}
