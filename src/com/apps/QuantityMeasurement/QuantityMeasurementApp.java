package com.apps.QuantityMeasurement;

import com.apps.QuantityMeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

	public static void demonstrateLengthEquality(Length a, Length b) {

		System.out.println("Comparing " + a + " and " + b);
		System.out.println("Equal ? : " + a.equals(b));
		System.out.println();
	}

	public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {

		double result = Length.convert(value, from, to);

		System.out.println("Convert " + value + " " + from + " to " + to);
		System.out.println("Result : " + result);
		System.out.println();
	}

	public static void demonstrateLengthAddition(Length a, Length b, LengthUnit targetUnit) {

		Length result = Length.add(a, b, targetUnit);

		System.out.println("Add " + a + " + " + b + " in " + targetUnit);
		System.out.println("Result : " + result);
		System.out.println();
	}

	public static void main(String[] args) {

		System.out.println("Equality");

		Length feet = new Length(1.0, LengthUnit.FEET);
		Length inches = new Length(12.0, LengthUnit.INCHES);

		demonstrateLengthEquality(feet, inches);

		System.out.println("Conversion");

		demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);

		System.out.println("Addition");

		demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES),
				LengthUnit.FEET);

		System.out.println("Yard");

		demonstrateLengthEquality(new Length(36.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.YARDS));
	}
}