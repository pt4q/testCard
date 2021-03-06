package config;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestCardAndParamMarks {

    @NonNull
    private String RANGE_OF_RESEARCH_MARK;
    @NonNull
    private String HEADER_TYPE;
    @NonNull
    private String BINARY_TYPE;
    @NonNull
    private String TEXT_TYPE;
    @NonNull
    private String DOUBLE_TYPE;
    @NonNull
    private String INTEGER_TYPE;

    private String PIC_TYPE;

    private String testCardBeginWordOrSentence = "KARTA ";

}
