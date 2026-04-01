package com.apps.QuantityMeasurementApp.enums;

import com.apps.QuantityMeasurementApp.model.Unit;
import com.apps.QuantityMeasurementApp.model.UnitCategory;

public enum VolumeUnit implements Unit {

    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78);

    private final double factor;

    VolumeUnit(double factor) {
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
        return UnitCategory.VOLUME;
    }
}