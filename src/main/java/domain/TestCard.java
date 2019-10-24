package domain;

import lombok.*;
import org.joda.time.DateTime;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TestCard {

//    private String model;
//    private String lot;
//    private String deviceTypeInPolish;
////    private String deviceTypeInEnglish;
//    private String testTime;
//    private String performer;
//
//    private boolean reference;
    List<List<String>> header;

    List<RangeOfResearch> rangeOfResearchList;
}
