package object_calculation.models;

import domain.Param;
import domain.TestCard;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TestCardCalcModel implements Param {

    @NonNull
    private TestCard testCard;

    private Integer maxNumberOfPoints;
    private Double score;
    private Double difference;
    private Double percent;

}
