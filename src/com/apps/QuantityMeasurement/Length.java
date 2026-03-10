package com.apps.QuantityMeasurement;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factor;
        LengthUnit(double factor){ this.factor=factor; }

        double toInches(double v){ return v*factor; }
    }

    public Length(double value,LengthUnit unit){
        if(unit==null) throw new IllegalArgumentException("Unit cannot be null");
        if(value<0) throw new IllegalArgumentException("Length cannot be negative");
        this.value=value;
        this.unit=unit;
    }

    private double base(){ return unit.toInches(value); }

    private boolean nearlyEqual(double a,double b){
        return Math.abs(a-b)<0.0001;
    }

    public boolean compare(Length other){
        return nearlyEqual(this.base(),other.base());
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Length)) return false;
        return compare((Length)o);
    }

    @Override
    public int hashCode(){
        return Objects.hash(Math.round(base()*1000));
    }
}
