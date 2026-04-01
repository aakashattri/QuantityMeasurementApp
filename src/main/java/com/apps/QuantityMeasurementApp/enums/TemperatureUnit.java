package com.apps.QuantityMeasurementApp.enums;

import com.apps.QuantityMeasurementApp.model.Unit;
import com.apps.QuantityMeasurementApp.model.UnitCategory;

public enum TemperatureUnit implements Unit {

    CELSIUS {
        public double convertToBaseUnit(double value) {
            return value + 273.15;
        }

        public double convertFromBaseUnit(double value) {
            return value - 273.15;
        }
    },

    FAHRENHEIT {
        public double convertToBaseUnit(double value) {
            return (value - 32) * 5/9 + 273.15;
        }

        public double convertFromBaseUnit(double value) {
            return (value - 273.15) * 9/5 + 32;
        }
    },

    KELVIN {
        public double convertToBaseUnit(double value) {
            return value;
        }

        public double convertFromBaseUnit(double value) {
            return value;
        }
    };

    // 🚨 IMPORTANT: Temperature does NOT support arithmetic
    @Override
    public void validateOperationSupport(String operation) {
        if (!operation.equals("comparison")) {
            throw new UnsupportedOperationException(
                "Temperature does not support operation: " + operation
            );
        }
    }
    @Override
    public UnitCategory getCategory() {
        return UnitCategory.TEMPERATURE;
    }
}