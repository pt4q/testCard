package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DesignationTypeParam implements Param {
    private String nameInPolish;

    private Integer punctation;

    private String value;

}
