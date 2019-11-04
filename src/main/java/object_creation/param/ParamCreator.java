package object_creation.param;

import domain.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Creator;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.test_card.config.TestCardConfig;

import java.util.List;

@RequiredArgsConstructor
public class ParamCreator implements Creator<Param, List<String>> {

    @NonNull
    private TestCardConfig testCardConfig;

    @Override
    public Param create(List<String> input) throws RecognizeParamTypeException {
        ParamFactory factory = new ParamFactory(testCardConfig);
        Param param = null;

        if (checkRequiredColumnNumber(input)) {
            param = factory.build(input);
            System.out.println("added:\t" + input.get(1));
        }

        if (param == null)
            System.out.println("Empty VALUE in:\t" + input.get(1));

        return param;
    }

    private boolean checkRequiredColumnNumber(List<String> input) {
        Integer REQUIRED_COLUMN_NUMBER = 5;
        return REQUIRED_COLUMN_NUMBER == input.size();
    }
}
