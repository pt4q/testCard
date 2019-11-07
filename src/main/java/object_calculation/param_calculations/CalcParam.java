package object_calculation.param_calculations;

public interface CalcParam<O, I> {

    O calcDifference(I input);

    O calcPercent(I input);

    O calcScore(I input);
}
