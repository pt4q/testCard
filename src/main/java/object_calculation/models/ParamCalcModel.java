package object_calculation.models;

import domain.Param;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ParamCalcModel implements Param {

    @NonNull
    private Param param;

    private Double score;
    private Double difference;
    private Double percent;

}
