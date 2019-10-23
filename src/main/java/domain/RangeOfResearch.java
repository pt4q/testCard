package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class RangeOfResearch {

    private String nameInPolish;
    private String nameInEnglish;

    private Integer punctation;
    private Double overallScore;

    List<Param> params;
}
