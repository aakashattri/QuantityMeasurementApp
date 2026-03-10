package com.apps.QuantityMeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    @Test
    void testIMeasurableInterface_LengthUnitImplementation() {

        IMeasurable unit = LengthUnit.FEET;

        assertNotNull(unit);
        assertEquals("FEET", unit.getUnitName());
        assertEquals(1.0, unit.getConversionFactor());
    }

    @Test
    void testIMeasurableInterface_WeightUnitImplementation() {

        IMeasurable unit = WeightUnit.KILOGRAM;

        assertNotNull(unit);
        assertEquals("KILOGRAM", unit.getUnitName());
        assertEquals(1.0, unit.getConversionFactor());
    }

    @Test
    void testIMeasurableInterface_ConsistentBehavior() {

        IMeasurable feet = LengthUnit.FEET;
        IMeasurable kg = WeightUnit.KILOGRAM;

        assertTrue(feet.convertToBaseUnit(1) > 0);
        assertTrue(kg.convertToBaseUnit(1) > 0);
    }

    @Test
    void testGenericQuantity_LengthOperations_Equality() {

        Quantity<LengthUnit> a =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(a.equals(b));
    }


    @Test
    void testGenericQuantity_WeightOperations_Equality() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> g =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(g));
    }

 

    @Test
    void testGenericQuantity_LengthOperations_Conversion() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, inches.getValue(), EPSILON);
    }


    @Test
    void testGenericQuantity_WeightOperations_Conversion() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, grams.getValue(), EPSILON);
    }


    @Test
    void testGenericQuantity_LengthOperations_Addition() {

        Quantity<LengthUnit> a =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                a.add(b, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
    }


    @Test
    void testGenericQuantity_WeightOperations_Addition() {

        Quantity<WeightUnit> a =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> b =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                a.add(b, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue(), EPSILON);
    }


    @Test
    void testCrossCategoryPrevention_LengthVsWeight() {

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    @Test
    void testGenericQuantity_ConstructorValidation_NullUnit() {

        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    @Test
    void testGenericQuantity_ConstructorValidation_InvalidValue() {

        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
    }


    @Test
    void testEquals_GenericQuantity_ContractPreservation() {

        Quantity<LengthUnit> a =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> c =
                new Quantity<>(0.3333, LengthUnit.YARDS);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }


    @Test
    void testHashCode_GenericQuantity_Consistency() {

        Quantity<LengthUnit> a =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void testGenericQuantity_Conversion_AllUnitCombinations() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> cm =
                feet.convertTo(LengthUnit.CENTIMETERS);

        assertEquals(30.48, cm.getValue(), EPSILON);
    }


    @Test
    void testGenericQuantity_Addition_AllUnitCombinations() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> pound =
                new Quantity<>(2.20462, WeightUnit.POUND);

        Quantity<WeightUnit> result =
                kg.add(pound, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue(), 0.05);
    }


    @Test
    void testQuantityMeasurementApp_SimplifiedDemonstration_Equality() {

        Quantity<LengthUnit> a =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(12.0, LengthUnit.INCHES);

        QuantityMeasurementApp.demonstrateEquality(a, b);
    }

    @Test
    void testQuantityMeasurementApp_SimplifiedDemonstration_Conversion() {

        Quantity<LengthUnit> a =
                new Quantity<>(1.0, LengthUnit.FEET);

        QuantityMeasurementApp.demonstrateConversion(a, LengthUnit.INCHES);
    }

    @Test
    void testQuantityMeasurementApp_SimplifiedDemonstration_Addition() {

        Quantity<LengthUnit> a =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(12.0, LengthUnit.INCHES);

        QuantityMeasurementApp.demonstrateAddition(a, b, LengthUnit.FEET);
    }


    @Test
    void testImmutability_GenericQuantity() {

        Quantity<LengthUnit> a =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                a.convertTo(LengthUnit.INCHES);

        assertNotSame(a, b);
    }
    
    @Test
    void testEquality_LitreToLitre_SameValue() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_LitreToLitre_DifferentValue() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(2.0, VolumeUnit.LITRE);

        assertFalse(a.equals(b));
    }

    @Test
    void testEquality_LitreToMillilitre_EquivalentValue() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_MillilitreToLitre_EquivalentValue() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_LitreToGallon_EquivalentValue() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(0.264172, VolumeUnit.GALLON);

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_GallonToLitre_EquivalentValue() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> b =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        assertTrue(a.equals(b));
    }
    
    @Test
    void testEquality_VolumeVsLength_Incompatible() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertFalse(volume.equals(length));
    }

    @Test
    void testEquality_VolumeVsWeight_Incompatible() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(volume.equals(weight));
    }
    
    @Test
    void testConversion_LitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result.getValue(), 0.01);
    }

    @Test
    void testConversion_MillilitreToLitre() {

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                ml.convertTo(VolumeUnit.LITRE);

        assertEquals(1.0, result.getValue(), 0.01);
    }

    @Test
    void testConversion_GallonToLitre() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result =
                gallon.convertTo(VolumeUnit.LITRE);

        assertEquals(3.78541, result.getValue(), 0.01);
    }

    @Test
    void testConversion_LitreToGallon() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre.convertTo(VolumeUnit.GALLON);

        assertEquals(1.0, result.getValue(), 0.01);
    }
    
    @Test
    void testAddition_SameUnit_LitrePlusLitre() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = a.add(b);

        assertEquals(3.0, result.getValue(), 0.01);
    }

    @Test
    void testAddition_CrossUnit_LitrePlusMillilitre() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = a.add(b);

        assertEquals(2.0, result.getValue(), 0.01);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Millilitre() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                a.add(b, VolumeUnit.MILLILITRE);

        assertEquals(2000.0, result.getValue(), 0.01);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Gallon() {

        Quantity<VolumeUnit> a =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                a.add(b, VolumeUnit.GALLON);

        assertEquals(2.0, result.getValue(), 0.05);
    }
}