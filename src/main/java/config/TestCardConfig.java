package config;

import csv.CsvConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@Builder
public class TestCardConfig {
    @NonNull
    private CsvConfig csvConfig;
    @NonNull
    private TestCardColumnsNumbers columnsNumbers;
    @NonNull
    private TestCardAndParamMarks paramTypes;
    @NonNull
    private BinaryTypePositiveDefinition positiveDefinition;
    @NonNull
    private CalcConfig calcConfig;
    @NonNull
    private PrintConfig printConfig;
}
