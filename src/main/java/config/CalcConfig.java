package config;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CalcConfig {

    @NonNull
    private Double maxPercentTolerance;

}
