package object_creation.test_card.config;

import lombok.*;

@Getter
@RequiredArgsConstructor
@Data
public class TestCardColumnsNumbers {
    @NonNull
    private Integer nameInPolishColumnNumber;
    private Integer nameInEnglishColumnNumber;

    @NonNull
    private Integer punctationColumnNumber;
    @NonNull
    private Integer paramTypeColumnNumber;
    @NonNull
    private Integer rangeOfResearchColumnNumber;

    @NonNull
    private Integer measuredValuesColumnNumber;
    @NonNull
    private Integer declaredValuesColumnNumber;
}
