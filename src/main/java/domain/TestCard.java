package domain;

import lombok.*;
import org.joda.time.DateTime;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TestCard {

    private RangeOfResearch header;
    private List<RangeOfResearch> rangeOfResearchList;
    private Integer punctation;

}
