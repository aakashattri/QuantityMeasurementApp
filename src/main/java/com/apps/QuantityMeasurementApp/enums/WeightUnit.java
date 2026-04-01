package com.apps.QuantityMeasurementApp.enums;

import com.apps.QuantityMeasurementApp.model.Unit;
import com.apps.QuantityMeasurementApp.model.UnitCategory;

public enum WeightUnit implements Unit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }
    @Override
    public UnitCategory getCategory() {
        return UnitCategory.WEIGHT;
    }
}