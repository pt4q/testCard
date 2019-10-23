package object_creation.test_card;

import domain.TestCard;
import object_creation.creation_utils.Creator;

import java.util.List;
import java.util.Map;

public class TestCardCreator implements Creator<TestCard, Map<Integer,List<String>>> {

    @Override
    public TestCard create(Map<Integer, List<String>> input) {
        TestCard testCard;


        return null;
    }

    private Map <Integer, List<String>> removeEmptyLines(Map<Integer, List<String>> input){
        input.entrySet().stream()
                .forEach();

        return ;
    }

    private boolean emptyStringListRemover(List<String> strings){

        return false;
    }
}
