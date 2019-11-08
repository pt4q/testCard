package object_calculation.models;

import domain.Param;
import domain.RangeOfResearch;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RangeOfResearchCalcModel {

    @NonNull
    private RangeOfResearch rangeOfResearch;

    private Integer sumOfAvailablePointsFromParams;
    private Double sumOfGainedPointsFromParams;

//    private Integer punctation;
    private Double difference;
    private Double score;
    private Double percent;

}
