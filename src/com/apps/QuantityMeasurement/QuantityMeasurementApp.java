package com.apps.QuantityMeasurement;

import com.apps.QuantityMeasurement.Length.LengthUnit;
import com.apps.QuantityMeasurement.Weight.WeightUnit;

public class QuantityMeasurementApp {

    public static void demonstrateLengthEquality(Length a, Length b) {

        System.out.println("Comparing " + a + " and " + b);
        System.out.println("Equal ? : " + a.equals(b));
        System.out.println();
    }

    public static void demonstrateLengthConversion(double value,
                                                   LengthUnit from,
                                                   LengthUnit to) {

        double result = Length.convert(value, from, to);

        System.out.println("Convert " + value + " " + from + " to " + to);
        System.out.println("Result : " + result);
        System.out.println();
    }

    public static void demonstrateLengthAddition(Length a,
                                                 Length b,
                                                 LengthUnit target) {

        Length result = Length.add(a, b, target);

        System.out.println("Add " + a + " + " + b + " in " + target);
        System.out.println("Result : " + result);
        System.out.println();
    }

    public static void demonstrateWeightEquality(Weight a,
                                                 Weight b) {

        System.out.println("Comparing " + a + " and " + b);
        System.out.println("Equal ? : " + a.equals(b));
        System.out.println();
    }

    public static void demonstrateWeightConversion(Weight value,
                                                   WeightUnit target) {

        Weight result = value.convertTo(target);

        System.out.println("Convert " + value + " to " + target);
        System.out.println("Result : " + result);
        System.out.println();
    }

    public static void demonstrateWeightAddition(Weight a,
                                                 Weight b,
                                                 WeightUnit target) {

        Weight result = Weight.add(a, b, target);

        System.out.println("Add " + a + " + " + b + " in " + target);
        System.out.println("Result : " + result);
        System.out.println();
    }

    public static void main(String[] args) {

        demonstrateLengthEquality(
                new Length(1, LengthUnit.FEET),
                new Length(12, LengthUnit.INCHES));

        demonstrateLengthConversion(1, LengthUnit.FEET, LengthUnit.INCHES);

        demonstrateLengthAddition(
                new Length(1, LengthUnit.FEET),
                new Length(12, LengthUnit.INCHES),
                LengthUnit.FEET);

        demonstrateWeightEquality(
                new Weight(1, WeightUnit.KILOGRAM),
                new Weight(1000, WeightUnit.GRAM));

        demonstrateWeightConversion(
                new Weight(1, WeightUnit.KILOGRAM),
                WeightUnit.POUND);

        demonstrateWeightAddition(
                new Weight(1, WeightUnit.KILOGRAM),
                new Weight(1000, WeightUnit.GRAM),
                WeightUnit.KILOGRAM);
    }
}