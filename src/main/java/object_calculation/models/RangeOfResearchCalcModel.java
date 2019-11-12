package object_calculation.models;

import domain.RangeOfResearch;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RangeOfResearchCalcModel {

    @NonNull
    private RangeOfResearch rangeOfResearch;

    private Integer sumOfAvailablePoints;
    private Integer sumOfUnavailablePoints;
    private Double sumOfGainedPoints;

//    private Integer punctation;
    private Double difference;
    private Double score;
    private Double percent;

}
