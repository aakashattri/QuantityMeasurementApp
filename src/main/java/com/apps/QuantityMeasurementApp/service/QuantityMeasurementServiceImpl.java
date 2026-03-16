package com.apps.QuantityMeasurementApp.service;

import com.apps.QuantityMeasurementApp.*;
import com.apps.QuantityMeasurementApp.dto.QuantityDTO;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    @Override
    public QuantityDTO convert(QuantityDTO input, String targetUnit) {

        LengthUnit source = LengthUnit.valueOf(input.getUnit());
        LengthUnit target = LengthUnit.valueOf(targetUnit);

        Quantity<LengthUnit> quantity =
                new Quantity<>(input.getValue(), source);

        Quantity<LengthUnit> result = quantity.convertTo(target);

        return new QuantityDTO(result.getValue(),
                target.name(),
                "LENGTH");
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {

        Quantity<LengthUnit> quantity1 =
                new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

        Quantity<LengthUnit> quantity2 =
                new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        return quantity1.equals(quantity2);
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        Quantity<LengthUnit> quantity1 =
                new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

        Quantity<LengthUnit> quantity2 =
                new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        Quantity<LengthUnit> result = quantity1.add(quantity2);

        return new QuantityDTO(result.getValue(),
                result.getUnit().name(),
                "LENGTH");
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

        Quantity<LengthUnit> quantity1 =
                new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

        Quantity<LengthUnit> quantity2 =
                new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        Quantity<LengthUnit> result = quantity1.subtract(quantity2);

        return new QuantityDTO(result.getValue(),
                result.getUnit().name(),
                "LENGTH");
    }

    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {

        Quantity<LengthUnit> quantity1 =
                new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

        Quantity<LengthUnit> quantity2 =
                new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        return quantity1.divide(quantity2);
    }
}