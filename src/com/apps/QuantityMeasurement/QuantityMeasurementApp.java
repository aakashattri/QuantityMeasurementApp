package com.apps.QuantityMeasurement;

public class QuantityMeasurementApp {

    public static void demonstrateLengthEquality(Length a, Length b) {

        System.out.println("Comparing " + a + " and " + b);
        System.out.println("Equal ? " + a.equals(b));
        System.out.println();
    }

    public static void demonstrateLengthConversion(double value,
                                                   Length.Unit from,
                                                   Length.Unit to) {

        double result = Length.convert(value, from, to);

        System.out.println("Convert " + value + " " + from + " to " + to);
        System.out.println("Result : " + result);
        System.out.println();
    }

    public static void demonstrateLengthAddition(Length a, Length b) {

        Length result = a.add(b);

        System.out.println("Add " + a + " + " + b);
        System.out.println("Result : " + result);
        System.out.println();
    }

    public static void demonstrateLengthAddition(Length a,
                                                 Length b,
                                                 Length.Unit targetUnit) {

        Length result = Length.add(a, b, targetUnit);

        System.out.println("Add " + a + " + " + b + " in " + targetUnit);
        System.out.println("Result : " + result);
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Equality");

        Length feet = new Length(1.0, Length.Unit.FEET);
        Length inches = new Length(12.0, Length.Unit.INCHES);

        demonstrateLengthEquality(feet, inches);

        System.out.println("Yard");

        Length yard = new Length(1.0, Length.Unit.YARDS);
        Length threeFeet = new Length(3.0, Length.Unit.FEET);

        demonstrateLengthEquality(yard, threeFeet);

        System.out.println("Conversion");

        demonstrateLengthConversion(1.0, Length.Unit.FEET, Length.Unit.INCHES);

        demonstrateLengthConversion(1.0, Length.Unit.YARDS, Length.Unit.INCHES);

        System.out.println("Addition");

        demonstrateLengthAddition(
                new Length(1.0, Length.Unit.FEET),
                new Length(12.0, Length.Unit.INCHES)
        );

        System.out.println("Addition With Target Unit");

        demonstrateLengthAddition(
                new Length(1.0, Length.Unit.FEET),
                new Length(12.0, Length.Unit.INCHES),
                Length.Unit.INCHES
        );
    }
}