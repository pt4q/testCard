package object_calculation.models;

import domain.Param;
import domain.TestCard;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TestCardCalcModel {

    @NonNull
    private TestCard testCard;

    private Integer availablePoints;
    private Double score;
    private Double difference;
    private Double percent;

}
