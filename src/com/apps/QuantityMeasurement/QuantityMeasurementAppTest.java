package com.apps.QuantityMeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // UC1

    @Test
    public void testFeetEquality() {

        Length a = new Length(1.0, Length.Unit.FEET);
        Length b = new Length(1.0, Length.Unit.FEET);

        assertTrue(a.equals(b));
    }

    @Test
    public void testFeetInequality() {

        Length a = new Length(1.0, Length.Unit.FEET);
        Length b = new Length(2.0, Length.Unit.FEET);

        assertFalse(a.equals(b));
    }


    // UC2

    @Test
    public void testInchesEquality() {

        Length a = new Length(1.0, Length.Unit.INCHES);
        Length b = new Length(1.0, Length.Unit.INCHES);

        assertTrue(a.equals(b));
    }

    @Test
    public void testInchesInequality() {

        Length a = new Length(1.0, Length.Unit.INCHES);
        Length b = new Length(2.0, Length.Unit.INCHES);

        assertFalse(a.equals(b));
    }


    //UC3

    @Test
    public void testFeetInchesComparison() {

        Length feet = new Length(1.0, Length.Unit.FEET);
        Length inches = new Length(12.0, Length.Unit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void testCrossUnitInequality() {

        Length feet = new Length(1.0, Length.Unit.FEET);
        Length inches = new Length(10.0, Length.Unit.INCHES);

        assertFalse(feet.equals(inches));
    }


    // UC4

    @Test
    public void yardEquals36Inches() {

        Length yard = new Length(1.0, Length.Unit.YARDS);
        Length inches = new Length(36.0, Length.Unit.INCHES);

        assertTrue(yard.equals(inches));
    }

    @Test
    public void centimeterEquals39Point3701Inches() {

        Length cm = new Length(1.0, Length.Unit.CENTIMETERS);
        Length inch = new Length(0.393701, Length.Unit.INCHES);

        assertTrue(cm.equals(inch));
    }

    @Test
    public void threeFeetEqualsOneYard() {

        Length feet = new Length(3.0, Length.Unit.FEET);
        Length yard = new Length(1.0, Length.Unit.YARDS);

        assertTrue(feet.equals(yard));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {

        Length cm = new Length(30.48, Length.Unit.CENTIMETERS);
        Length foot = new Length(1.0, Length.Unit.FEET);

        assertTrue(cm.equals(foot));
    }

    @Test
    public void yardNotEqualToInches() {

        Length yard = new Length(1.0, Length.Unit.YARDS);
        Length inches = new Length(12.0, Length.Unit.INCHES);

        assertFalse(yard.equals(inches));
    }



    @Test
    public void referenceEqualitySameObject() {

        Length length = new Length(1.0, Length.Unit.FEET);

        assertTrue(length.equals(length));
    }

    @Test
    public void equalsReturnsFalseForNull() {

        Length length = new Length(1.0, Length.Unit.FEET);

        assertFalse(length.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length a = new Length(1.0, Length.Unit.YARDS);
        Length b = new Length(3.0, Length.Unit.FEET);
        Length c = new Length(36.0, Length.Unit.INCHES);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {

        Length a = new Length(1.0, Length.Unit.FEET);
        Length b = new Length(2.0, Length.Unit.FEET);

        assertFalse(a.equals(b));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {

        Length feet = new Length(1.0, Length.Unit.FEET);
        Length inches = new Length(12.0, Length.Unit.INCHES);

        assertTrue(feet.equals(inches));
    }


    //UC5

    @Test
    public void convertFeetToInches() {

        double result =
                Length.convert(1.0, Length.Unit.FEET, Length.Unit.INCHES);

        assertEquals(12.0, result);
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {

        double result =
                Length.convert(1.0, Length.Unit.YARDS, Length.Unit.INCHES);

        assertEquals(36.0, result);
    }


    // UC6

    @Test
    public void addFeetAndInches() {

        Length feet = new Length(1.0, Length.Unit.FEET);
        Length inches = new Length(12.0, Length.Unit.INCHES);

        Length result = feet.add(inches);

        assertEquals(new Length(2.0, Length.Unit.FEET), result);
    }


    // UC7

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {

        Length feet = new Length(1.0, Length.Unit.FEET);
        Length inches = new Length(12.0, Length.Unit.INCHES);

        Length result =
                Length.add(feet, inches, Length.Unit.INCHES);

        assertEquals(new Length(24.0, Length.Unit.INCHES), result);
    }

}