package com.apps.QuantityMeasurementApp.model;

public interface Unit {

    double convertToBaseUnit(double value);
    double convertFromBaseUnit(double baseValue);

    default boolean supportsArithmetic() {
        return true;
    }

    default void validateOperationSupport(String operation) {
        if (!supportsArithmetic()) {
            throw new UnsupportedOperationException(
                "Operation " + operation + " not supported for this unit"
            );
        }
    }
    

    UnitCategory getCategory(); // 🔥 ADD THIS
 
}