package object_calculation;

import config.TestCardConfig;
import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.TestCardCalcModel;

@RequiredArgsConstructor
public class TestCardCalculator implements Calculator<TestCardCalcModel, TestCard> {

    @NonNull
    private TestCardConfig config;

    @Override
    public TestCardCalcModel calculate(TestCard input) {
        return null;
    }
}
