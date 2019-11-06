package object_calculation;

import config.TestCardConfig;
import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestCardCalculator implements Calculator<CalculatedTestCard, TestCard> {

    @NonNull
    private TestCardConfig config;

    @Override
    public CalculatedTestCard calculate(TestCard input) {
        return null;
    }
}
