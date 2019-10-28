package object_creation.param;

import domain.Param;
import object_creation.creation_utils.Creator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParamListCreator implements Creator<List<Param>, List<List<String>>> {

    @Override
    public List<Param> create(List<List<String>> input) {
//        return input.stream()
//                .map(list -> createParam(list))
//                .collect(Collectors.toList());
        List<Param> params = new ArrayList<>();
        Integer inputSize = input.size();

        for (int i = 0; i < inputSize; i++) {
            Param param = createParam(input.get(i));
            System.out.println(param.toString());
            params.add(param);
        }
        return params;
    }

    private Param createParam(List<String> input) {
        return new ParamCreator().create(input);
    }
}
