package com.apps.QuantityMeasurementApp.dto;

public class QuantityDTO {

    private double value;
    private Enum<?> unit;

    public QuantityDTO(double value, Enum<?> unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Enum<?> getUnit() {
        return unit;
    }
}