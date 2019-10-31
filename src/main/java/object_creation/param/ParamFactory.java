package object_creation.param;

import domain.*;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringMatcher;
import object_creation.param.status_and_exceptions.ParamFactoryStatusEnum;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.param.types.ParamTypeEnum;

import java.util.List;

class ParamFactory implements Builder<Param, List<String>> {

    @Override
    public Param build(List<String> input) throws RecognizeParamTypeException {
        ParamTypeEnum paramType = paramTypeRecognizer(input);

        if (paramType != null) {
            if (paramType.equals(ParamTypeEnum.BINARY)) {
                BinaryTypeParamBuilder builder = new BinaryTypeParamBuilder();
                return builder.build(input);
            } else if (paramType.equals(ParamTypeEnum.TEXT)) {
                TextTypeParamBuilder builder = new TextTypeParamBuilder();
                return builder.build(input);
            } else if (paramType.equals(ParamTypeEnum.DOUBLE)) {
                DoubleTypeParamBuilder builder = new DoubleTypeParamBuilder();
                return builder.build(input);
            } else if (paramType.equals(ParamTypeEnum.INTEGER)) {
                IntegerTypeParameterBuilder builder = new IntegerTypeParameterBuilder();
                return builder.build(input);
            }
        }

        throw new RecognizeParamTypeException(ParamFactoryStatusEnum.PARAM_BUILD_NOT_RECOGNIZED.toString()+ " for " + input.get(1));
    }

    private ParamTypeEnum paramTypeRecognizer(List<String> input) {
        ParamTypeEnum result = null;
        Integer inputSize = input.size();
        String type = null;

        if (inputSize > 2) {
            type = input.get(3);

            if (StringMatcher.isMatch(type, ParamTypeEnum.BINARY.toString()))
                return ParamTypeEnum.BINARY;

            else if (StringMatcher.isMatch(type, ParamTypeEnum.TEXT.toString()))
                return ParamTypeEnum.TEXT;

            else if (StringMatcher.isMatch(type, ParamTypeEnum.DOUBLE.toString()))
                return ParamTypeEnum.DOUBLE;

            else if (StringMatcher.isMatch(type, ParamTypeEnum.INTEGER.toString()))
                return ParamTypeEnum.INTEGER;
        } else
            System.out.println(input.get(1));

        return result;
    }
}
