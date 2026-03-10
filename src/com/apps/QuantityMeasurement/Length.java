package com.apps.QuantityMeasurement;

public class Length {

    public enum Unit {
        FEET(1.0),
        INCHES(1.0 / 12),
        YARDS(3.0),
        CENTIMETERS(0.0328084);

        private final double toFeetFactor;

        Unit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double getToFeetFactor() {
            return toFeetFactor;
        }
    }

    private final double value;
    private final Unit unit;

    private static final double EPSILON = 0.0001;

    public Length(double value, Unit unit) {

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

    public Unit getUnit() {
        return unit;
    }

    private double toFeet() {
        return value * unit.getToFeetFactor();
    }

    private static double toFeet(double value, Unit unit) {
        return value * unit.getToFeetFactor();
    }

    public Length convertTo(Unit targetUnit) {

        double feet = toFeet();
        double result = feet / targetUnit.getToFeetFactor();

        return new Length(result, targetUnit);
    }

    public static double convert(double value, Unit sourceUnit, Unit targetUnit) {

        if (sourceUnit == null || targetUnit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        double feet = toFeet(value, sourceUnit);

        return feet / targetUnit.getToFeetFactor();
    }

    public Length add(Length other) {

        double sumFeet = this.toFeet() + other.toFeet();

        double result = sumFeet / this.unit.getToFeetFactor();

        return new Length(result, this.unit);
    }

    public static Length add(Length a, Length b, Unit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumFeet = a.toFeet() + b.toFeet();

        double result = sumFeet / targetUnit.getToFeetFactor();

        return new Length(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Length other = (Length) obj;

        return Math.abs(this.toFeet() - other.toFeet()) < EPSILON;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}