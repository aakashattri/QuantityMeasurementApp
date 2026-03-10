package com.apps.QuantityMeasurement;

import com.apps.QuantityMeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

    static void test(double v1,LengthUnit u1,double v2,LengthUnit u2){
        Length l1=new Length(v1,u1);
        Length l2=new Length(v2,u2);
        System.out.println(l1.equals(l2));
    }

    public static void main(String[] args){

        test(1,LengthUnit.YARDS,3,LengthUnit.FEET);
        test(1,LengthUnit.YARDS,36,LengthUnit.INCHES);
        test(1,LengthUnit.CENTIMETERS,0.393701,LengthUnit.INCHES);
        test(2,LengthUnit.YARDS,72,LengthUnit.INCHES);
    }
}
