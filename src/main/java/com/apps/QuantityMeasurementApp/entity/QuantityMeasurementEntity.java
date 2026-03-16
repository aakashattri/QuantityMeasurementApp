
package com.apps.QuantityMeasurementApp.entity;

import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

    private double operand1;
    private double operand2;
    private double result;
    private String operation;

    public QuantityMeasurementEntity(double operand1,
                                     double operand2,
                                     double result,
                                     String operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.operation = operation;
    }

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public double getResult() {
        return result;
    }

    public String getOperation() {
        return operation;
    }
}
