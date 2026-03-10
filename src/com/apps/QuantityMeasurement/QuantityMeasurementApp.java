package com.apps.QuantityMeasurement;

public class QuantityMeasurementApp {

	public static void demonstrateEquality(Quantity<?> a, Quantity<?> b) {

		System.out.println("Comparing " + a + " and " + b);
		System.out.println("Equal ? " + a.equals(b));
		System.out.println();
	}

	public static <U extends IMeasurable> void demonstrateConversion(Quantity<U> quantity, U targetUnit) {

		Quantity<U> result = quantity.convertTo(targetUnit);

		System.out.println("Convert " + quantity + " to " + targetUnit.getUnitName());
		System.out.println("Result: " + result);
		System.out.println();
	}

	public static <U extends IMeasurable> void demonstrateAddition(Quantity<U> a, Quantity<U> b, U targetUnit) {

		Quantity<U> result = a.add(b, targetUnit);

		System.out.println("Add " + a + " + " + b + " in " + targetUnit.getUnitName());
		System.out.println("Result: " + result);
		System.out.println();
	}

	public static void main(String[] args) {

		Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);

		Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

		demonstrateEquality(length1, length2);

		demonstrateConversion(length1, LengthUnit.INCHES);

		demonstrateAddition(length1, length2, LengthUnit.FEET);

		Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);

		Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

		demonstrateEquality(weight1, weight2);

		demonstrateConversion(weight1, WeightUnit.GRAM);

		demonstrateAddition(weight1, weight2, WeightUnit.KILOGRAM);
	}
}