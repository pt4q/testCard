package object_creation.param;

import domain.*;
import object_creation.creation_utils.Creator;

import java.util.List;
import java.util.Map;

public class ParamCreator implements Creator<Param, List<String>> {

    @Override
    public Param create(List<String> input) {
        ParamFactory factory = new ParamFactory();
        return factory.build(input);
    }
}
