package com.apps.QuantityMeasurementApp;

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

	public static <U extends IMeasurable> void demonstrateSubtraction(Quantity<U> a, Quantity<U> b, U targetUnit) {

		Quantity<U> result = a.subtract(b, targetUnit);

		System.out.println("Subtract " + b + " from " + a);
		System.out.println("Result: " + result);
		System.out.println();
	}

	public static <U extends IMeasurable> void demonstrateDivision(Quantity<U> a, Quantity<U> b) {

		double result = a.divide(b);

		System.out.println("Divide " + a + " by " + b);
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

		Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);

		Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

		Quantity<VolumeUnit> v3 = new Quantity<>(1.0, VolumeUnit.GALLON);

		demonstrateEquality(v1, v2);

		demonstrateConversion(v1, VolumeUnit.MILLILITRE);

		demonstrateAddition(v1, v2, VolumeUnit.LITRE);

		Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);

		Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCHES);

		demonstrateSubtraction(l1, l2, LengthUnit.FEET);

		demonstrateDivision(l1, new Quantity<>(2.0, LengthUnit.FEET));

		Quantity<WeightUnit> w1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);

		Quantity<WeightUnit> w2 = new Quantity<>(5000.0, WeightUnit.GRAM);

		demonstrateSubtraction(w1, w2, WeightUnit.KILOGRAM);

		demonstrateDivision(w1, new Quantity<>(5.0, WeightUnit.KILOGRAM));

		Quantity<VolumeUnit> c1 = new Quantity<>(5.0, VolumeUnit.LITRE);

		Quantity<VolumeUnit> c2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

		demonstrateSubtraction(c1, c2, VolumeUnit.LITRE);

		demonstrateDivision(c1, new Quantity<>(10.0, VolumeUnit.LITRE));

		Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);

		Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

		System.out.println("Temperature Equality:");
		System.out.println(t1.equals(t2));

		System.out.println("Conversion:");
		System.out.println(new Quantity<>(100.0, TemperatureUnit.CELSIUS).convertTo(TemperatureUnit.FAHRENHEIT));

		try {
			t1.add(new Quantity<>(10.0, TemperatureUnit.CELSIUS));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}