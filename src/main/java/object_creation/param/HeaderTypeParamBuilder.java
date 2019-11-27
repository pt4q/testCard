package object_creation.param;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.HeaderTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import utils.Builder;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;

import java.util.List;

@RequiredArgsConstructor
class HeaderTypeParamBuilder implements Builder<HeaderTypeParam, List<String>> {

    @NonNull
    private TestCardConfig config;


    @Override
    public HeaderTypeParam build(List<String> input) throws RecognizeParamTypeException {
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();

        HeaderTypeParam header = new HeaderTypeParam(input.get(columnsNumbers.getNameInPolishColumnNumber()));

        try {
            header.setType(input.get(columnsNumbers.getParamTypeColumnNumber()));

        } catch (IndexOutOfBoundsException | NullPointerException e) {
//            header.setType(null);
        }

        try {
            header.setValueString(input.get(columnsNumbers.getReadValueColumnNumber()));
        } catch (IndexOutOfBoundsException | NullPointerException e) {
//            header.setValueString(null);
        }

        return header;
    }
}
