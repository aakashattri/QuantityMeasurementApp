package com.apps.QuantityMeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.QuantityMeasurement.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_YardToYard_SameValue() {
        assertEquals(new Length(1.0,LengthUnit.YARDS),
                     new Length(1.0,LengthUnit.YARDS));
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        assertNotEquals(new Length(1.0,LengthUnit.YARDS),
                        new Length(2.0,LengthUnit.YARDS));
    }

    
    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        assertEquals(new Length(1.0,LengthUnit.YARDS),
                     new Length(3.0,LengthUnit.FEET));
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        assertEquals(new Length(3.0,LengthUnit.FEET),
                     new Length(1.0,LengthUnit.YARDS));
    }

    
    @Test
    void testEquality_YardToInches_EquivalentValue() {
        assertEquals(new Length(1.0,LengthUnit.YARDS),
                     new Length(36.0,LengthUnit.INCHES));
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {
        assertEquals(new Length(36.0,LengthUnit.INCHES),
                     new Length(1.0,LengthUnit.YARDS));
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        assertNotEquals(new Length(1.0,LengthUnit.YARDS),
                        new Length(2.0,LengthUnit.FEET));
    }

  
    @Test
    void testEquality_centimetersToInches_EquivalentValue() {
        assertEquals(new Length(1.0,LengthUnit.CENTIMETERS),
                     new Length(0.393701,LengthUnit.INCHES));
    }

    @Test
    void testEquality_centimetersToFeet_NonEquivalentValue() {
        assertNotEquals(new Length(1.0,LengthUnit.CENTIMETERS),
                        new Length(1.0,LengthUnit.FEET));
    }


    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        Length a=new Length(1.0,LengthUnit.YARDS);
        Length b=new Length(3.0,LengthUnit.FEET);
        Length c=new Length(36.0,LengthUnit.INCHES);
        assertTrue(a.equals(b)&&b.equals(c)&&a.equals(c));
    }
    @Test
    void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class,
                ()-> new Length(1.0,null));
    }

    @Test
    void testEquality_CentimetersWithNullUnit() {
        assertThrows(IllegalArgumentException.class,
                ()-> new Length(1.0,null));
    }

    
    @Test
    void testEquality_YardSameReference() {
        Length a=new Length(1.0,LengthUnit.YARDS);
        assertEquals(a,a);
    }

    @Test
    void testEquality_YardNullComparison() {
        assertNotEquals(new Length(1.0,LengthUnit.YARDS),null);
    }

    @Test
    void testEquality_CentimetersSameReference() {
        Length a=new Length(1.0,LengthUnit.CENTIMETERS);
        assertEquals(a,a);
    }

    @Test
    void testEquality_CentimetersNullComparison() {
        assertNotEquals(new Length(1.0,LengthUnit.CENTIMETERS),null);
        
    }
    
    @Test
    void testEquality_AllUnits_ComplexScenario() {
        assertEquals(new Length(2.0,LengthUnit.YARDS),
                     new Length(6.0,LengthUnit.FEET));
        assertEquals(new Length(6.0,LengthUnit.FEET),
                     new Length(72.0,LengthUnit.INCHES));
    }
    
    private static final double EPSILON = 1e-6;

    @Test
    void testConversion_FeetToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    void testConversion_InchesToFeet() {
        double result = Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testConversion_YardsToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES);
        assertEquals(36.0, result, EPSILON);
    }

    @Test
    void testConversion_InchesToYards() {
        double result = Length.convert(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testConversion_CentimetersToInches() {
        double result = Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testConversion_FeetToYard() {
        double result = Length.convert(6.0, Length.LengthUnit.FEET, Length.LengthUnit.YARDS);
        assertEquals(2.0, result, EPSILON);
    }


    @Test
    void testConversion_RoundTrip_PreservesValue() {
        double original = 5.75;

        double temp = Length.convert(original, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        double finalValue = Length.convert(temp, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);

        assertEquals(original, finalValue, EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {
        double result = Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(0.0, result, EPSILON);
    }

    @Test
    void testConversion_NegativeValue() {
        double result = Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(-12.0, result, EPSILON);
    }

    @Test
    void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1.0, null, Length.LengthUnit.INCHES));

        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1.0, Length.LengthUnit.FEET, null));
    }

    @Test
    void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));

        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
    }

    @Test
    void testConversion_PrecisionTolerance() {
        double result = Length.convert(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        assertEquals(0.393701, result, EPSILON);
    }

    @Test
    void testAddition_SameUnit_FeetPlusFeet(){
        Length a=new Length(1.0,Length.LengthUnit.FEET);
        Length b=new Length(2.0,Length.LengthUnit.FEET);
        assertEquals(new Length(3.0,Length.LengthUnit.FEET),a.add(b));
    }

    @Test
    void testAddition_SameUnit_InchPlusInch(){
        Length a=new Length(6.0,Length.LengthUnit.INCHES);
        Length b=new Length(6.0,Length.LengthUnit.INCHES);
        assertEquals(new Length(12.0,Length.LengthUnit.INCHES),a.add(b));
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches(){
        Length a=new Length(1.0,Length.LengthUnit.FEET);
        Length b=new Length(12.0,Length.LengthUnit.INCHES);
        assertEquals(new Length(2.0,Length.LengthUnit.FEET),a.add(b));
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet(){
        Length a=new Length(12.0,Length.LengthUnit.INCHES);
        Length b=new Length(1.0,Length.LengthUnit.FEET);
        assertEquals(new Length(24.0,Length.LengthUnit.INCHES),a.add(b));
    }

    @Test
    void testAddition_CrossUnit_YardPlusFeet(){
        Length a=new Length(1.0,Length.LengthUnit.YARDS);
        Length b=new Length(3.0,Length.LengthUnit.FEET);
        assertEquals(new Length(2.0,Length.LengthUnit.YARDS),a.add(b));
    }

    @Test
    void testAddition_CrossUnit_CentimeterPlusInch(){
        Length a=new Length(2.54,Length.LengthUnit.CENTIMETERS);
        Length b=new Length(1.0,Length.LengthUnit.INCHES);
        assertEquals(5.08,a.add(b).convertTo(Length.LengthUnit.CENTIMETERS),EPSILON);
    }

    @Test
    void testAddition_Commutativity(){
        Length a=new Length(1.0,Length.LengthUnit.FEET);
        Length b=new Length(12.0,Length.LengthUnit.INCHES);
        assertEquals(a.add(b),b.add(a));
    }

    @Test
    void testAddition_WithZero(){
        Length a=new Length(5.0,Length.LengthUnit.FEET);
        Length b=new Length(0.0,Length.LengthUnit.INCHES);
        assertEquals(new Length(5.0,Length.LengthUnit.FEET),a.add(b));
    }

    @Test
    void testAddition_NegativeValues(){
        Length a=new Length(5.0,Length.LengthUnit.FEET);
        Length b=new Length(-2.0,Length.LengthUnit.FEET);
        assertEquals(new Length(3.0,Length.LengthUnit.FEET),a.add(b));
    }

    @Test
    void testAddition_NullSecondOperand(){
        Length a=new Length(1.0,Length.LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class,()->a.add(null));
    }

    @Test
    void testAddition_LargeValues(){
        Length a=new Length(1e6,Length.LengthUnit.FEET);
        Length b=new Length(1e6,Length.LengthUnit.FEET);
        assertEquals(new Length(2e6,Length.LengthUnit.FEET),a.add(b));
    }

    @Test
    void testAddition_SmallValues(){
        Length a=new Length(0.001,Length.LengthUnit.FEET);
        Length b=new Length(0.002,Length.LengthUnit.FEET);
        assertEquals(0.003,a.add(b).convertTo(Length.LengthUnit.FEET),EPSILON);
    }
}
