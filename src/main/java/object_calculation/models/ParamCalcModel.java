package object_calculation.models;

import domain.Param;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ParamCalcModel {

    @NonNull
    private Param param;

    private Integer availablePoints;
    private Double score;
    private Double difference;
    private Double percent;

}
