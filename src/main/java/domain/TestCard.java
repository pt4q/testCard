package domain;

import org.joda.time.DateTime;

import java.util.List;

public class TestCard {

    private String model;
    private String lot;
    private String deviceNameInPolish;
    private String deviceNameInEnglish;
    private DateTime testTime;

    private boolean reference;

    List<RangeOfResearch> rangeOfResearchList;
}
