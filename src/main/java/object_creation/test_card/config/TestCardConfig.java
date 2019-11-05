package object_creation.test_card.config;

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
    private TestCardParamMarks paramTypes;
    @NonNull
    private BinaryTypePositiveDefinition positiveDefinition;
}
