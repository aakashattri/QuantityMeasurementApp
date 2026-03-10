package com.apps.QuantityMeasurement;

public class Length {

	public enum LengthUnit {

	    FEET(1.0),
	    INCHES(1.0 / 12),
	    YARDS(3.0),
	    CENTIMETERS(1.0 / 30.48);

	    private final double conversionFactor;

	    LengthUnit(double conversionFactor) {
	        this.conversionFactor = conversionFactor;
	    }

	    public double getConversionFactor() {
	        return conversionFactor;
	    }

	    // Convert this unit value → base unit (feet)
	    public double convertToBaseUnit(double value) {
	        return value * conversionFactor;
	    }

	    // Convert base unit (feet) → this unit
	    public double convertFromBaseUnit(double baseValue) {
	        return baseValue / conversionFactor;
	    }
	}
    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 0.0001;

    public Length(double value, LengthUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public Length convertTo(LengthUnit targetUnit) {

        double baseValue = toBaseUnit();
        double result = targetUnit.convertFromBaseUnit(baseValue);

        return new Length(result, targetUnit);
    }

    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        double baseValue = source.convertToBaseUnit(value);

        return target.convertFromBaseUnit(baseValue);
    }

    public Length add(Length other) {

        double sumBase = this.toBaseUnit() + other.toBaseUnit();
        double result = unit.convertFromBaseUnit(sumBase);

        return new Length(result, unit);
    }

    public static Length add(Length a, Length b, LengthUnit targetUnit) {

        double sumBase = a.toBaseUnit() + b.toBaseUnit();
        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Length(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Length other = (Length) obj;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}