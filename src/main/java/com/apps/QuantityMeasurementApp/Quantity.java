package com.apps.QuantityMeasurementApp;

public class Quantity<U extends IMeasurable> {
	public enum ArithmeticOperation {

		ADD((a, b) -> a + b), SUBTRACT((a, b) -> a - b), DIVIDE((a, b) -> {
			if (b == 0)
				throw new ArithmeticException("Division by zero");
			return a / b;
		});

		private final java.util.function.DoubleBinaryOperator operator;

		ArithmeticOperation(java.util.function.DoubleBinaryOperator operator) {
			this.operator = operator;
		}

		public double compute(double a, double b) {
			return operator.applyAsDouble(a, b);
		}
	}

	private final double value;
	private final U unit;

	private static final double EPSILON = 0.0001;

	public Quantity(double value, U unit) {

		if (unit == null)
			throw new IllegalArgumentException("Unit cannot be null");

		if (!Double.isFinite(value))
			throw new IllegalArgumentException("Invalid value");

		this.value = value;
		this.unit = unit;
	}

	private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetUnitRequired) {

		if (other == null)
			throw new IllegalArgumentException("Operand cannot be null");

		if (!this.unit.getClass().equals(other.unit.getClass()))
			throw new IllegalArgumentException("Different measurement categories");

		if (!Double.isFinite(this.value) || !Double.isFinite(other.value))
			throw new IllegalArgumentException("Values must be finite");

		if (targetUnitRequired && targetUnit == null)
			throw new IllegalArgumentException("Target unit cannot be null");
	}

	private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation operation) {

		double baseValue1 = unit.convertToBaseUnit(value);

		double baseValue2 = other.unit.convertToBaseUnit(other.value);

		return operation.compute(baseValue1, baseValue2);
	}

	private double roundToTwoDecimals(double value) {
		return Math.round(value * 100.0) / 100.0;
	}

	public double getValue() {
		return value;
	}

	public U getUnit() {
		return unit;
	}

	private double toBaseUnit() {
		return unit.convertToBaseUnit(value);
	}

	public Quantity<U> convertTo(U targetUnit) {

		double base = toBaseUnit();
		double result = targetUnit.convertFromBaseUnit(base);

		return new Quantity<>(result, targetUnit);
	}

	public Quantity<U> add(Quantity<U> other) {

		validateArithmeticOperands(other, unit, false);

		double baseResult = performBaseArithmetic(other, ArithmeticOperation.ADD);

		double result = unit.convertFromBaseUnit(baseResult);

		return new Quantity<>(roundToTwoDecimals(result), unit);
	}

	public Quantity<U> add(Quantity<U> other, U targetUnit) {

		validateArithmeticOperands(other, targetUnit, true);

		double baseResult = performBaseArithmetic(other, ArithmeticOperation.ADD);

		double result = targetUnit.convertFromBaseUnit(baseResult);

		return new Quantity<>(roundToTwoDecimals(result), targetUnit);
	}

	public Quantity<U> subtract(Quantity<U> other) {

		validateArithmeticOperands(other, unit, false);

		double baseResult = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);

		double result = unit.convertFromBaseUnit(baseResult);

		return new Quantity<>(roundToTwoDecimals(result), unit);
	}

	public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

		validateArithmeticOperands(other, targetUnit, true);

		double baseResult = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);

		double result = targetUnit.convertFromBaseUnit(baseResult);

		return new Quantity<>(roundToTwoDecimals(result), targetUnit);
	}

	public double divide(Quantity<U> other) {

		validateArithmeticOperands(other, null, false);

		return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Quantity<?> other = (Quantity<?>) obj;

		if (!this.unit.getClass().equals(other.unit.getClass()))
			return false;

		return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
	}

	@Override
	public int hashCode() {
		return Double.hashCode(toBaseUnit());
	}

	@Override
	public String toString() {
		return "Quantity(" + value + ", " + unit.getUnitName() + ")";
	}
}