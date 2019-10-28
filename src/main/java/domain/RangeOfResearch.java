package domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RangeOfResearch {

    private String nameInPolish;

    private Integer punctation;
    private Double overallScore;

    List<Param> params;
}
