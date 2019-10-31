package object_creation.param;

import domain.Param;
import object_creation.creation_utils.Creator;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;

import java.util.ArrayList;
import java.util.List;

public class ParamListCreator implements Creator<List<Param>, List<List<String>>> {

    @Override
    public List<Param> create(List<List<String>> input) throws RecognizeParamTypeException {
//        return input.stream()
//                .map(list -> createParam(list))
//                .collect(Collectors.toList());
        List<Param> params = new ArrayList<>();
        Integer inputSize = input.size();

        for (int i = 0; i < inputSize; i++) {
            List<String> stringLines = input.get(i);

            if (stringLines.size() > 2) {
                Param param = createParam(stringLines);
                params.add(param);
            }
        }
        return params;
    }

    private Param createParam(List<String> input) throws RecognizeParamTypeException {
        return new ParamCreator().create(input);
    }
}
