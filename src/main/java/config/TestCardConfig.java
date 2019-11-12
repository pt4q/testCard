package config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@Builder
public class TestCardConfig {
    @NonNull
    private TestCardColumnsNumbers columnsNumbers;
    @NonNull
    private TestCardAndParamMarks paramTypes;
    @NonNull
    private BinaryTypePositiveDefinition positiveDefinition;
//    @NonNull
//    private ParametersCalcConfig calcConfig;
}
