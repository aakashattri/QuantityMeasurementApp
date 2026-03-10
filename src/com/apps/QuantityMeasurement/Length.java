package com.apps.QuantityMeasurement;

public class Length {

	public enum LengthUnit {

	    FEET(1.0),
	    INCHES(1.0 / 12),
	    YARDS(3.0),
	    CENTIMETERS(1.0 / 30.48);

	    private final double factor;

	    LengthUnit(double factor) {
	        this.factor = factor;
	    }

	    public double getConversionFactor() {
	        return factor;
	    }

	    public double convertToBaseUnit(double value) {
	        return value * factor;
	    }

	    public double convertFromBaseUnit(double base) {
	        return base / factor;
	    }
	}
    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 0.0001;

    public Length(double value, LengthUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

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

    public Length convertTo(LengthUnit target) {

        double base = toBaseUnit();
        double result = target.convertFromBaseUnit(base);

        return new Length(result, target);
    }

    public static double convert(double value, LengthUnit source, LengthUnit target) {

        double base = source.convertToBaseUnit(value);
        return target.convertFromBaseUnit(base);
    }

    public Length add(Length other) {

        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = unit.convertFromBaseUnit(sum);

        return new Length(result, unit);
    }

    public static Length add(Length a, Length b, LengthUnit target) {

        double sum = a.toBaseUnit() + b.toBaseUnit();
        double result = target.convertFromBaseUnit(sum);

        return new Length(result, target);
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
    public int hashCode() {
        return Double.hashCode(toBaseUnit());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}