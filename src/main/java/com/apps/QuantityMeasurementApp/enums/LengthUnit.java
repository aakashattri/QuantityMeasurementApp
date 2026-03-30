package com.apps.QuantityMeasurementApp.enums;

import com.apps.QuantityMeasurementApp.model.Unit;

public enum LengthUnit implements Unit {

    METER(1.0),
    CENTIMETER(0.01),
    MILLIMETER(0.001),
    KILOMETER(1000.0),
    INCH(0.0254),
    FEET(0.3048),
    YARD(0.9144);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    @Override
    public void validateOperationSupport(String operation) {
        // Length supports all operations
    }
}