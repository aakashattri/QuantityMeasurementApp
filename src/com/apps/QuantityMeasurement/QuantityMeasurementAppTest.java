package com.apps.QuantityMeasurement;

import org.junit.jupiter.api.Test;

import com.apps.QuantityMeasurement.Length.LengthUnit;
import com.apps.QuantityMeasurement.Weight.WeightUnit;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.0001;

    // ---------- UC1 / UC2 Equality ----------

    @Test
    public void testFeetEquality() {
        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(1.0, LengthUnit.FEET);
        assertTrue(a.equals(b));
    }

    @Test
    public void testInchesEquality() {
        Length a = new Length(12.0, LengthUnit.INCHES);
        Length b = new Length(12.0, LengthUnit.INCHES);
        assertTrue(a.equals(b));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {
        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(2.0, LengthUnit.FEET);
        assertFalse(a.equals(b));
    }

    @Test
    public void testInchesInequality() {
        Length a = new Length(10.0, LengthUnit.INCHES);
        Length b = new Length(12.0, LengthUnit.INCHES);
        assertFalse(a.equals(b));
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(10.0, LengthUnit.INCHES);
        assertFalse(feet.equals(inches));
    }

    // ---------- UC4 Extended Units ----------

    @Test
    public void yardEquals36Inches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        Length inch = new Length(0.393701, LengthUnit.INCHES);
        assertTrue(cm.equals(inch));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(feet.equals(yard));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
        Length foot = new Length(1.0, LengthUnit.FEET);
        assertTrue(cm.equals(foot));
    }

    @Test
    public void yardNotEqualToInches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertFalse(yard.equals(inches));
    }

    // ---------- Equality Contract ----------

    @Test
    public void referenceEqualitySameObject() {
        Length length = new Length(1.0, LengthUnit.FEET);
        assertTrue(length.equals(length));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length length = new Length(1.0, LengthUnit.FEET);
        assertFalse(length.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length a = new Length(1.0, LengthUnit.YARDS);
        Length b = new Length(3.0, LengthUnit.FEET);
        Length c = new Length(36.0, LengthUnit.INCHES);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(2.0, LengthUnit.FEET);
        assertFalse(a.equals(b));
    }

    // ---------- UC5 Conversion ----------

    @Test
    public void convertFeetToInches() {

        double result =
                Length.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES);

        assertEquals(12.0, result, EPSILON);
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {

        double result =
                Length.convert(1.0, LengthUnit.YARDS, LengthUnit.INCHES);

        assertEquals(36.0, result, EPSILON);
    }

    // ---------- UC6 Addition ----------

    @Test
    public void addFeetAndInches() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        Length result = feet.add(inches);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // ---------- UC7 Addition With Target Unit ----------

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        Length result =
                Length.add(feet, inches, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    // ---------- UC8 LengthUnit Enum Tests ----------

    @Test
    public void testConvertToBaseUnit_FeetToFeet() {
        assertEquals(5.0,
                LengthUnit.FEET.convertToBaseUnit(5.0),
                EPSILON);
    }

    @Test
    public void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0,
                LengthUnit.INCHES.convertToBaseUnit(12.0),
                EPSILON);
    }

    @Test
    public void testConvertToBaseUnit_YardsToFeet() {
        assertEquals(3.0,
                LengthUnit.YARDS.convertToBaseUnit(1.0),
                EPSILON);
    }

    @Test
    public void testConvertToBaseUnit_CentimetersToFeet() {
        assertEquals(1.0,
                LengthUnit.CENTIMETERS.convertToBaseUnit(30.48),
                EPSILON);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToInches() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertFromBaseUnit(1.0),
                EPSILON);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToYards() {
        assertEquals(1.0,
                LengthUnit.YARDS.convertFromBaseUnit(3.0),
                EPSILON);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToCentimeters() {
        assertEquals(30.48,
                LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0),
                EPSILON);
    }
    @Test
    void testEquality_KilogramToKilogram_SameValue() {

        Weight a = new Weight(1, WeightUnit.KILOGRAM);
        Weight b = new Weight(1, WeightUnit.KILOGRAM);

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_KilogramToGram_EquivalentValue() {

        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight g = new Weight(1000, WeightUnit.GRAM);

        assertTrue(kg.equals(g));
    }

    @Test
    void testEquality_GramToKilogram_EquivalentValue() {

        Weight g = new Weight(1000, WeightUnit.GRAM);
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);

        assertTrue(g.equals(kg));
    }

    @Test
    void testEquality_NullComparison() {

        Weight w = new Weight(1, WeightUnit.KILOGRAM);

        assertFalse(w.equals(null));
    }

    @Test
    void testEquality_SameReference() {

        Weight w = new Weight(1, WeightUnit.KILOGRAM);

        assertTrue(w.equals(w));
    }

    // Conversion Tests

    @Test
    void testConversion_KilogramToGram() {

        Weight kg = new Weight(1, WeightUnit.KILOGRAM);

        Weight result = kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_KilogramToPound() {

        Weight kg = new Weight(1, WeightUnit.KILOGRAM);

        Weight result = kg.convertTo(WeightUnit.POUND);

        assertEquals(2.20462, result.getValue(), EPSILON);
    }

    // Addition Tests

    @Test
    void testAddition_SameUnit_KilogramPlusKilogram() {

        Weight a = new Weight(1, WeightUnit.KILOGRAM);
        Weight b = new Weight(2, WeightUnit.KILOGRAM);

        Weight result = a.add(b);

        assertEquals(3, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_KilogramPlusGram() {

        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight g = new Weight(1000, WeightUnit.GRAM);

        Weight result = kg.add(g);

        assertEquals(2, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit() {

        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight g = new Weight(1000, WeightUnit.GRAM);

        Weight result = Weight.add(kg, g, WeightUnit.GRAM);

        assertEquals(2000, result.getValue(), EPSILON);
    }

}