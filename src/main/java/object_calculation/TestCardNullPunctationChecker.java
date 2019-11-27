package object_calculation;

import config.TestCardConfig;
import domain.Param;
import domain.RangeOfResearch;
import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class TestCardNullPunctationChecker {

    @NonNull
    private TestCardConfig config;

    private int totalRangeOfResearchNumber;
    private int totalRangeOfResearchWithoutPunctation;
    private double rangeOfResearchesPercentage;

    private int totalParamNumber;
    private int totalParamWithoutPunctation;
    private double paramsPercentage;

    public Boolean checkPunctation(TestCard testCard){

        checkRangeOfResearchList(testCard.getRangeOfResearchList());

        return false;
    }

    private boolean checkRangeOfResearchList(List<RangeOfResearch> rangeOfResearchList){


        return false;
    }

    private boolean checkParams(List<Param> paramList){

        return false;
    }
}
