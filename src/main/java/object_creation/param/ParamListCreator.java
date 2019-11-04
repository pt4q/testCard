package object_creation.param;

import domain.Param;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Creator;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.test_card.config.TestCardConfig;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ParamListCreator implements Creator<List<Param>, List<List<String>>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<Param> create(List<List<String>> input) throws RecognizeParamTypeException {
//        return input.stream()
//                .map(list -> createParam(list))
//                .collect(Collectors.toList());
        List<Param> params = new ArrayList<>();
        Integer inputSize = input.size();

        for (int i = 0; i < inputSize; i++) {
            List<String> stringLines = input.get(i);

            String readParam = stringLines.get(1);
            String brakepoint = "Przyrost rezystancji uzwojeń wirnika ∆t";
            if (readParam.equals(brakepoint))
                System.out.println("breakpoint");

            if (stringLines.size() > 2) {
                Param param = createParam(stringLines);
                params.add(param);
            }
        }
        return params;
    }

    private Param createParam(List<String> input) throws RecognizeParamTypeException {
        return new ParamCreator(config).create(input);
    }
}
