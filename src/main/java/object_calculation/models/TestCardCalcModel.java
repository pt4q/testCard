package object_calculation.models;

import domain.TestCard;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class TestCardCalcModel {

    @NonNull
    private TestCard testCard;
    private List<RangeOfResearchCalcModel> rangeOfResearchCalcModelList;

    private Integer sumOfAvailablePoints;
    private Double sumOfGainedPoints;

    private Integer sumOfUnavailablePoints;
    private Integer numberOfNotAvailableParams;

    private Double score;
    private Double difference;
    private Double percent;

}
