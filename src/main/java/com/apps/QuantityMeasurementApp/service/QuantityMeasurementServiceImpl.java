package com.apps.QuantityMeasurementApp.service;

import org.springframework.stereotype.Service;

import com.apps.QuantityMeasurementApp.dto.QuantityDTO;
import com.apps.QuantityMeasurementApp.enums.LengthUnit;
import com.apps.QuantityMeasurementApp.model.Quantity;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Override
    public QuantityDTO addQuantity(QuantityDTO q1, QuantityDTO q2) {

        LengthUnit unit1 = LengthUnit.valueOf(q1.getUnit());
        LengthUnit unit2 = LengthUnit.valueOf(q2.getUnit());

        Quantity<LengthUnit> quantity1 = new Quantity<>(q1.getValue(), unit1);
        Quantity<LengthUnit> quantity2 = new Quantity<>(q2.getValue(), unit2);

        Quantity<LengthUnit> result = quantity1.add(quantity2);

        return new QuantityDTO(result.getValue(), result.getUnit().name());
    }

    @Override
    public boolean compareQuantity(QuantityDTO q1, QuantityDTO q2) {

        LengthUnit unit1 = LengthUnit.valueOf(q1.getUnit());
        LengthUnit unit2 = LengthUnit.valueOf(q2.getUnit());

        Quantity<LengthUnit> quantity1 = new Quantity<>(q1.getValue(), unit1);
        Quantity<LengthUnit> quantity2 = new Quantity<>(q2.getValue(), unit2);

        return quantity1.equals(quantity2);
    }

    @Override
    public QuantityDTO subQuantity(QuantityDTO q1, QuantityDTO q2) {

        LengthUnit unit1 = LengthUnit.valueOf(q1.getUnit());
        LengthUnit unit2 = LengthUnit.valueOf(q2.getUnit());

        Quantity<LengthUnit> quantity1 = new Quantity<>(q1.getValue(), unit1);
        Quantity<LengthUnit> quantity2 = new Quantity<>(q2.getValue(), unit2);

        Quantity<LengthUnit> result = quantity1.subtract(quantity2);

        return new QuantityDTO(result.getValue(), result.getUnit().name());
    }

    @Override
    public double divQuantity(QuantityDTO q1, QuantityDTO q2) {

        LengthUnit unit1 = LengthUnit.valueOf(q1.getUnit());
        LengthUnit unit2 = LengthUnit.valueOf(q2.getUnit());

        Quantity<LengthUnit> quantity1 = new Quantity<>(q1.getValue(), unit1);
        Quantity<LengthUnit> quantity2 = new Quantity<>(q2.getValue(), unit2);

        return quantity1.divide(quantity2);
    }
}