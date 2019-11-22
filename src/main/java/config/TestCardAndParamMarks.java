package config;

import domain.RangeOfResearch;
import lombok.*;

@Getter
@NoArgsConstructor
@Builder
public class TestCardAndParamMarks {

    @Builder.Default
    private String RANGE_OF_RESEARCH_MARK = "#";
    @Builder.Default
    private String HEADER_TYPE = "h";
    @Builder.Default
    private String BINARY_TYPE = "b";
    @Builder.Default
    private String TEXT_TYPE = "t";
    @Builder.Default
    private String DOUBLE_TYPE = "f";
    @Builder.Default
    private String INTEGER_TYPE = "i";
    @Builder.Default
    private String PIC_TYPE = "p";
    @Builder.Default
    private String testCardBeginWordOrSentence = "KARTA ";

    public TestCardAndParamMarks(String RANGE_OF_RESEARCH_MARK, String HEADER_TYPE, String BINARY_TYPE, String TEXT_TYPE, String DOUBLE_TYPE, String INTEGER_TYPE, String PIC_TYPE, String testCardBeginWordOrSentence) {
        this.RANGE_OF_RESEARCH_MARK = RANGE_OF_RESEARCH_MARK;
        this.HEADER_TYPE = HEADER_TYPE;
        this.BINARY_TYPE = BINARY_TYPE;
        this.TEXT_TYPE = TEXT_TYPE;
        this.DOUBLE_TYPE = DOUBLE_TYPE;
        this.INTEGER_TYPE = INTEGER_TYPE;
        this.PIC_TYPE = PIC_TYPE;
        this.testCardBeginWordOrSentence = testCardBeginWordOrSentence;
    }

    public TestCardAndParamMarks(String s, String h, String b, String n, String f, String i) {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("Default parameters and range of research marks:");
        sb.append("\n").append(RANGE_OF_RESEARCH_MARK).append("\t- range of research");
        sb.append("\n").append(HEADER_TYPE).append("\t- header type param");
        sb.append("\n").append(BINARY_TYPE).append("\t- binary type param");
        sb.append("\n").append(TEXT_TYPE).append("\t- text type param");
        sb.append("\n").append(DOUBLE_TYPE).append("\t- float type param");
        sb.append("\n").append(INTEGER_TYPE).append("\t- integer type param");
//        sb.append("\n").append(PIC_TYPE ).append("\t- picture type param");
        sb.append("\n").append(testCardBeginWordOrSentence).append("\t- test card begin word (first range of research with header type params)");
        return sb.toString();
    }
}
