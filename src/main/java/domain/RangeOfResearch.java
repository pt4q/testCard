package domain;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RangeOfResearch {

    private String nameInPolish;

    private Integer punctation;
    private Double overallScore;

    private List<Param> params;
}
