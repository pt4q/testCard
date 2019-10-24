package object_creation.param;

import domain.Param;
import object_creation.creation_utils.Creator;

import java.util.List;

public class ParamListCreator implements Creator<List<Param>,List<List<String>>> {

    @Override
    public List<Param> create(List<List<String>> input) {
        return null;
    }

    private Param createParam(List<String> input){
        return new ParamCreator().create(input);
    }
}
