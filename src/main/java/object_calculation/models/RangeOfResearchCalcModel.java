package object_calculation.models;

import domain.RangeOfResearch;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class RangeOfResearchCalcModel {

    @NonNull
    private RangeOfResearch rangeOfResearch;
    private List<ParamCalcModel> paramCalcModelList;

    private Integer sumOfAvailablePoints;
    private Double sumOfGainedPoints;

    private Integer sumOfUnavailablePoints;
    private Integer numberOfNotAvailableParams;

    private Integer punctation;
    private Double difference;
    private Double score;
    private Double percent;

}
