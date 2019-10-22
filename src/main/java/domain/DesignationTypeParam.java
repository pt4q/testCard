package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class DesignationTypeParam implements Param {
    private String nameInPolish;
    private String nameInEnglish;

    private Integer punctation;

    private String value;
}
