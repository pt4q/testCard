package object_creation.param;

import domain.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import utils.Builder;
import utils.StringMatcher;
import object_creation.param.status_and_exceptions.ParamFactoryStatusEnum;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import config.TestCardAndParamMarks;

import java.util.List;

@RequiredArgsConstructor
class ParamFactory implements Builder<Param, List<String>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public Param build(List<String> input) throws RecognizeParamTypeException {
        TestCardAndParamMarks testCardAndParamMarks = config.getParamTypes();
        String paramType = paramTypeRecognizer(input);

        if (paramType != null) {
            if (paramType.equals(testCardAndParamMarks.getBINARY_TYPE()))
                return new BinaryTypeParamBuilder(config).build(input);

             else if (paramType.equals(testCardAndParamMarks.getTEXT_TYPE()))
                return new TextTypeParamBuilder(config).build(input);

             else if (paramType.equals(testCardAndParamMarks.getDOUBLE_TYPE()))
                return new DoubleTypeParamBuilder(config).build(input);

             else if (paramType.equals(testCardAndParamMarks.getINTEGER_TYPE()))
                return new IntegerTypeParameterBuilder(config).build(input);

             else if (paramType.equals(testCardAndParamMarks.getHEADER_TYPE()))
                return new HeaderTypeParamBuilder(config).build(input);
        }
        throw new RecognizeParamTypeException(ParamFactoryStatusEnum.PARAM_BUILD_NOT_RECOGNIZED.toString() + " for " + input.get(1));
    }

    private String paramTypeRecognizer(List<String> input) {
        TestCardColumnsNumbers testCardColumnsNumbers = config.getColumnsNumbers();
        TestCardAndParamMarks testCardAndParamMarks = config.getParamTypes();

        Integer inputSize = input.size();
        String type;

        if (inputSize > 2) {
            type = input.get(testCardColumnsNumbers.getParamTypeColumnNumber());

            if (StringMatcher.isMatch(type, testCardAndParamMarks.getBINARY_TYPE()))
                return testCardAndParamMarks.getBINARY_TYPE();

            else if (StringMatcher.isMatch(type, testCardAndParamMarks.getTEXT_TYPE()))
                return testCardAndParamMarks.getTEXT_TYPE();

            else if (StringMatcher.isMatch(type, testCardAndParamMarks.getDOUBLE_TYPE()))
                return testCardAndParamMarks.getDOUBLE_TYPE();

            else if (StringMatcher.isMatch(type, testCardAndParamMarks.getINTEGER_TYPE()))
                return testCardAndParamMarks.getINTEGER_TYPE();

            else if (StringMatcher.isMatch(type, testCardAndParamMarks.getHEADER_TYPE()))
                return testCardAndParamMarks.getHEADER_TYPE();
        } else
            System.out.println(input.get(1));

        return null;
    }
}
