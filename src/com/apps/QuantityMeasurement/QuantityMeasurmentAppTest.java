

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurmentAppTest {


    @Test
    void testInchesEquality_SameValue() {
        assertEquals(new QuantityMeasurmentApp.Inches(2.5), new QuantityMeasurmentApp.Inches(2.5));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        assertNotEquals(new QuantityMeasurmentApp.Inches(5.0), new QuantityMeasurmentApp.Inches(7.0));
    }

    @Test
    void testInchesEquality_NullComparison() {
        assertNotEquals(new QuantityMeasurmentApp.Inches(5.2), null);
    }

    @Test
    void testInchesEquality_NonNumericInput() {
        assertNotEquals(new QuantityMeasurmentApp.Inches(4.1), "Other String");
    }

    @Test
    void testInchesEquality_SameReference() {
        QuantityMeasurmentApp.Inches f1=new QuantityMeasurmentApp.Inches(8.3);
        assertEquals(f1,f1);
    }

    // FEET TESTS

    @Test
    void testFeetEquality_SameValue() {
        assertEquals(new QuantityMeasurmentApp.Feet(2.5), new QuantityMeasurmentApp.Feet(2.5));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertNotEquals(new QuantityMeasurmentApp.Feet(5.0), new QuantityMeasurmentApp.Feet(7.0));
    }

    @Test
    void testFeetEquality_NullComparison() {
        assertNotEquals(new QuantityMeasurmentApp.Feet(5.2), null);
    }

    @Test
    void testFeetEquality_NonNumericInput() {
        assertNotEquals(new QuantityMeasurmentApp.Feet(4.1), "Other String");
    }

    @Test
    void testFeetEquality_SameReference() {
        QuantityMeasurmentApp.Feet f1=new QuantityMeasurmentApp.Feet(8.3);
        assertEquals(f1,f1);
    }
}
