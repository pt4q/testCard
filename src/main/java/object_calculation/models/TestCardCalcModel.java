package object_calculation.models;

import domain.Param;
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

    private Double score;
    private Double difference;
    private Double percent;

}
