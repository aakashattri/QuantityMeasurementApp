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
}
