package object_creation.param;

import domain.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringMatcher;
import object_creation.param.status_and_exceptions.ParamFactoryStatusEnum;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.test_card.config.TestCardColumnsNumbers;
import object_creation.test_card.config.TestCardConfig;
import object_creation.test_card.config.TestCardParamMarks;

import java.util.List;

@RequiredArgsConstructor
class ParamFactory implements Builder<Param, List<String>> {

    @NonNull
    private TestCardConfig testCardConfig;

    @Override
    public Param build(List<String> input) throws RecognizeParamTypeException {
        TestCardParamMarks testCardParamMarks = testCardConfig.getParamTypes();
        String paramType = paramTypeRecognizer(input);

        if (paramType != null) {
            if (paramType.equals(testCardParamMarks.getBINARY_TYPE())) {
                BinaryTypeParamBuilder builder = new BinaryTypeParamBuilder();
                return builder.build(input);
            } else if (paramType.equals(testCardParamMarks.getTEXT_TYPE())) {
                TextTypeParamBuilder builder = new TextTypeParamBuilder();
                return builder.build(input);
            } else if (paramType.equals(testCardParamMarks.getDOUBLE_TYPE())) {
                DoubleTypeParamBuilder builder = new DoubleTypeParamBuilder();
                return builder.build(input);
            } else if (paramType.equals(testCardParamMarks.getINTEGER_TYPE())) {
                IntegerTypeParameterBuilder builder = new IntegerTypeParameterBuilder();
                return builder.build(input);
            }
        }
        throw new RecognizeParamTypeException(ParamFactoryStatusEnum.PARAM_BUILD_NOT_RECOGNIZED.toString() + " for " + input.get(1));
    }

    private String paramTypeRecognizer(List<String> input) {
        TestCardColumnsNumbers testCardColumnsNumbers = testCardConfig.getColumnsNumbers();
        TestCardParamMarks testCardParamMarks = testCardConfig.getParamTypes();

        TestCardParamMarks result = null;
        Integer inputSize = input.size();
        String type = null;

        if (inputSize > 2) {
            type = input.get(testCardColumnsNumbers.getParamTypeColumnNumber());

            if (StringMatcher.isMatch(type, testCardParamMarks.getBINARY_TYPE()))
                return testCardParamMarks.getBINARY_TYPE();

            else if (StringMatcher.isMatch(type, testCardParamMarks.getTEXT_TYPE()))
                return testCardParamMarks.getTEXT_TYPE();

            else if (StringMatcher.isMatch(type, testCardParamMarks.getDOUBLE_TYPE()))
                return testCardParamMarks.getDOUBLE_TYPE();

            else if (StringMatcher.isMatch(type, testCardParamMarks.getINTEGER_TYPE()))
                return testCardParamMarks.getINTEGER_TYPE();
        } else
            System.out.println(input.get(1));

        return null;
    }
}
