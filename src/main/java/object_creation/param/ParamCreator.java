package object_creation.param;

import domain.*;
import object_creation.creation_utils.Creator;

import java.util.List;

public class ParamCreator implements Creator<Param, List<String>> {

    @Override
    public Param create(List<String> input) {
        ParamFactory factory = new ParamFactory();
        Param param = null;

        if (checkRequiredColumnNumber(input)) {
            param = factory.build(input);
            System.out.println("added:\t" + input.get(1));
        }

        if (param == null)
            System.out.println("NULL in:\t" + input.get(1));

        return param;
    }

    private boolean checkRequiredColumnNumber(List<String> input) {
        Integer REQUIRED_COLUMN_NUMBER = 5;
        return REQUIRED_COLUMN_NUMBER == input.size();
    }
}
