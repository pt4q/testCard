package object_printing;

import config.TestCardConfig;
import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.RangeOfResearchCalcModel;
import object_calculation.models.TestCardCalcModel;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class TestCardStringGenerator implements Generator<List<String>, TestCardCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<String> generate(TestCardCalcModel input) {
        List<String> result = new ArrayList<>();


        return result;
    }


    private List<List<String>> convertListOfMapsToListOfStrings(List<RangeOfResearchCalcModel> calcModelList) {
        List<String> result = new ArrayList<>();
        List<Map<Integer, String>> listOfMaps = generateListOfMaps(calcModelList);
        String defaultSeparator = config.getCsvConfig().getDefaultSeparator();

        for (Map<Integer, String> valuesInMap : listOfMaps) {
            String line = valuesInMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(entry -> entry.getValue() + defaultSeparator)
                    .collect(Collectors.joining());

            result.add(line);
        }

        return result;
    }

    private List<Map<Integer, String>> generateListOfMaps(List<RangeOfResearchCalcModel> calcModelList) {
        List<Map<Integer, String>> result = new ArrayList<>();

        for (RangeOfResearchCalcModel calcModel : calcModelList) {
            generateRangeOfResearchListOfMaps(calcModel)
                    .forEach(result::add);
        }

        return result;
    }

    private List<Map<Integer, String>> generateRangeOfResearchListOfMaps(RangeOfResearchCalcModel rorCalcModel) {
        return new RangeOfResearchStringGenerator(config).generate(rorCalcModel);
    }
}
