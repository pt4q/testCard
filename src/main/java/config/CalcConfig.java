package config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalcConfig {

    @NonNull
    private Double maxPercentTolerance;

}
