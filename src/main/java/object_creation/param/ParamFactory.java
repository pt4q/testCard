package object_creation.param;

import domain.*;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringMatcher;
import java.util.List;

class ParamFactory implements Builder <Param, List<String>> {

    @Override
    public Param build(List<String> input) throws IllegalArgumentException {
        ParamTypeEnum paramType = paramTypeRecognizer(input);

        if (paramType.equals(ParamTypeEnum.BINARY)) {
            BinaryTypeParamBuilder builder = new BinaryTypeParamBuilder();
            return builder.build(input);
        }

        else if (paramType.equals(ParamTypeEnum.TEXT)) {
            TextTypeParamBuilder builder = new TextTypeParamBuilder();
            return builder.build(input);
        }

        else if (paramType.equals(ParamTypeEnum.DOUBLE)) {
            DoubleTypeParamBuilder builder = new DoubleTypeParamBuilder();
            return builder.build(input);
        }

        else if (paramType.equals(ParamTypeEnum.INTEGER)) {
            IntegerTypeParameterBuilder builder = new IntegerTypeParameterBuilder();
            return builder.build(input);
        }

        throw new IllegalArgumentException(ParamFactoryStatusEnum.PARAM_BUILD_ERR.toString());
    }

    private ParamTypeEnum paramTypeRecognizer(List<String> input) {
        ParamTypeEnum result = null;
        String type = input.get(3);

        if (StringMatcher.isMatch(type, ParamTypeEnum.BINARY.toString()))
            return ParamTypeEnum.BINARY;

        else if (StringMatcher.isMatch(type, ParamTypeEnum.TEXT.toString()))
            return ParamTypeEnum.TEXT;

        else if (StringMatcher.isMatch(type, ParamTypeEnum.DOUBLE.toString()))
            return ParamTypeEnum.DOUBLE;

        else if (StringMatcher.isMatch(type, ParamTypeEnum.INTEGER.toString()))
            return ParamTypeEnum.INTEGER;

        return result;
    }
}
