package object_printing;

import config.TestCardConfig;
import domain.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
class ParamStringGenerator implements Generator<List<List<ParamPrintModel>>, List<Param>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<List<ParamPrintModel>> generate(List<Param> input) {
        return generateParamPrintModels(input);
    }

    private List<List<ParamPrintModel>> generateParamPrintModels(List<Param> input) {
        List<List<ParamPrintModel>> result = new ArrayList<>();

        for (Param param : input) {
            if (param instanceof BinaryTypeParam)
                result.add(new BinaryTypeParamStringGenerator(config).generate((BinaryTypeParam) param));
            else if (param instanceof DoubleTypeParam)
                result.add(new DoubleTypeParamStringGenerator(config).generate((DoubleTypeParam) param));
            else if (param instanceof IntegerTypeParam)
                result.add(new IntegerTypeParamStringGenerator(config).generate((IntegerTypeParam) param));
            else if (param instanceof TextTypeParam)
                result.add(new TextTypeParamStringGenerator(config).generate((TextTypeParam) param));
        }

        return result;
    }

    private Integer calcMaxColumnNumberFromConfig() {
        TestCardColumnSequencer columnSequencer = new TestCardColumnSequencer();
        return columnSequencer.calcMaxNumberOfColumn(config);
    }
}
