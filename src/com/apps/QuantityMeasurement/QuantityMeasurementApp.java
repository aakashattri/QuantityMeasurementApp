package com.apps.QuantityMeasurement;

import com.apps.QuantityMeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

    public static void demonstrateLengthEquality(double v1,LengthUnit u1,double v2,LengthUnit u2){
        Length l1=new Length(v1,u1);
        Length l2=new Length(v2,u2);
        System.out.println(l1+" == "+l2+"  :  "+l1.equals(l2));
    }

    public static void demonstrateLengthConversion(double value,LengthUnit from,LengthUnit to){
        double result=Length.convert(value,from,to);
        System.out.println(value+" "+from+" = "+result+" "+to);
    }

    public static void demonstrateLengthConversion(Length length,LengthUnit toUnit){
        double result=length.convertTo(toUnit);
        System.out.println(length+" = "+result+" "+toUnit);
    }
    public static void demonstrateLengthAddition(double v1,LengthUnit u1,double v2,LengthUnit u2) {
    	Length l1=new Length(v1,u1);
    	Length l2=new Length(v2,u2);
    	System.out.println(l1+" + "+l2+" == "+l1.add(l2));
    }

    public static void main(String[] args){
        demonstrateLengthEquality(1,LengthUnit.YARDS,3,LengthUnit.FEET);
        demonstrateLengthEquality(1,LengthUnit.YARDS,36,LengthUnit.INCHES);
        demonstrateLengthConversion(1,LengthUnit.YARDS,LengthUnit.FEET);
        demonstrateLengthConversion(24,LengthUnit.INCHES,LengthUnit.FEET);
        demonstrateLengthConversion(2.54,LengthUnit.CENTIMETERS,LengthUnit.INCHES);
        Length l=new Length(2,LengthUnit.YARDS);
        demonstrateLengthConversion(l,LengthUnit.FEET);
        demonstrateLengthAddition(3.43, LengthUnit.FEET, 4.2, LengthUnit.CENTIMETERS);
    }
}