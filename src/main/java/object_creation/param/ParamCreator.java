package object_creation.param;

import domain.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Creator;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.test_card.config.TestCardColumnsNumbers;
import object_creation.test_card.config.TestCardConfig;

import java.util.List;

@RequiredArgsConstructor
public class ParamCreator implements Creator<Param, List<String>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public Param create(List<String> input) throws RecognizeParamTypeException {
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        ParamFactory factory = new ParamFactory(config);
        Param param = null;

        if (checkRequiredColumnNumber(input)) {
            param = factory.build(input);
            System.out.println("added:\t" + input.get(columnsNumbers.getNameInPolishColumnNumber()));
        }

        if (param == null)
            System.out.println("Empty VALUE in:\t" + input.get(columnsNumbers.getNameInPolishColumnNumber()));

        return param;
    }

    private boolean checkRequiredColumnNumber(List<String> input) {
        return input.size() > config.getColumnsNumbers().getParamTypeColumnNumber();
    }
}
