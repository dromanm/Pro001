package w2.lesson4.task1.calculator.model;

/**
 * Created by Bohdan on 25.12.2016.
 */
public class CalculatorModel
{
    private Integer numFirst;
    private Integer numSecond;
    private Integer numResult;

    private String expression;

    public Integer getNumFirst() {
        return numFirst;
    }

    public void setNumFirst(Integer numFirst) {
        this.numFirst = numFirst;
    }

    public Integer getNumSecond() {
        return numSecond;
    }

    public void setNumSecond(Integer numSecond) {
        this.numSecond = numSecond;
    }

    public Integer getNumResult() {
        return numResult;
    }

    public void setNumResult(Integer numResult) {
        this.numResult = numResult;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
