package com.oj.entity;

public class MathSelectorCheckEntity {

    private String plusSelect;
    private String minusSelect;
    private String multiplySelect;
    private String divideSelect;
    private String numberSelect;

    public MathSelectorCheckEntity() {}

    public MathSelectorCheckEntity(String plusSelect, String minusSelect, String multiplySelect, String divideSelect, String numberSelect) {
        this.plusSelect = plusSelect;
        this.minusSelect = minusSelect;
        this.multiplySelect = multiplySelect;
        this.divideSelect = divideSelect;
        this.numberSelect = numberSelect;
    }

    public String getPlusSelect() {
        return plusSelect;
    }

    public void setPlusSelect(String plusSelect) {
        this.plusSelect = plusSelect;
    }

    public String getMinusSelect() {
        return minusSelect;
    }

    public void setMinusSelect(String minusSelect) {
        this.minusSelect = minusSelect;
    }

    public String getMultiplySelect() {
        return multiplySelect;
    }

    public void setMultiplySelect(String multiplySelect) {
        this.multiplySelect = multiplySelect;
    }

    public String getDivideSelect() {
        return divideSelect;
    }

    public void setDivideSelect(String divideSelect) {
        this.divideSelect = divideSelect;
    }

    public String getNumberSelect() {
        return numberSelect;
    }

    public void setNumberSelect(String numberSelect) {
        this.numberSelect = numberSelect;
    }

    @Override
    public String toString() {
        return "MathSelectorCheckEntity{" +
                "plusSelect='" + plusSelect + '\'' +
                ", minusSelect='" + minusSelect + '\'' +
                ", multiplySelect='" + multiplySelect + '\'' +
                ", divideSelect='" + divideSelect + '\'' +
                ", numberSelect='" + numberSelect + '\'' +
                '}';
    }
}
