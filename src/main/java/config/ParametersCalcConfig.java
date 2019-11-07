package config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParametersCalcConfig {

    @NonNull
    private Double maxPercentTolerance;

}
