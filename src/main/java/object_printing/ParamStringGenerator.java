package object_printing;

import config.TestCardConfig;
import domain.Param;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class ParamStringGenerator implements Generator<List<List<String>>, List<Param>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<List<String>> generate(List<Param> input) {



        return null;
    }

    private Integer calcMaxColumnNumberFromConfig() {
        TestCardColumnSequencer columnSequencer = new TestCardColumnSequencer();
        return columnSequencer.calcMaxNumberOfColumn(config);
    }
}
