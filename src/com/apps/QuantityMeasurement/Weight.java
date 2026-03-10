package com.apps.QuantityMeasurement;

public class Weight {

	public enum WeightUnit {

	    KILOGRAM(1.0),
	    GRAM(0.001),
	    POUND(0.453592);

	    private final double factor;

	    WeightUnit(double factor) {
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
    private final WeightUnit unit;

    private static final double EPSILON = 0.0001;

    public Weight(double value, WeightUnit unit) {

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

    public WeightUnit getUnit() {
        return unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public Weight convertTo(WeightUnit target) {

        double base = toBaseUnit();
        double result = target.convertFromBaseUnit(base);

        return new Weight(result, target);
    }

    public Weight add(Weight other) {

        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = unit.convertFromBaseUnit(sum);

        return new Weight(result, unit);
    }

    public static Weight add(
            Weight a,
            Weight b,
            WeightUnit target) {

        double sum = a.toBaseUnit() + b.toBaseUnit();
        double result = target.convertFromBaseUnit(sum);

        return new Weight(result, target);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Weight other = (Weight) obj;

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