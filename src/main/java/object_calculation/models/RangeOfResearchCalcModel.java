package object_calculation.models;

import domain.Param;
import domain.RangeOfResearch;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RangeOfResearchCalcModel implements Param {

    @NonNull
    private RangeOfResearch rangeOfResearch;

    private Double score;
    private Double difference;
    private Double percent;

}
