 package com.apps.QuantityMeasurementApp.service;

import com.apps.QuantityMeasurementApp.dto.QuantityDTO;
import com.apps.QuantityMeasurementApp.entity.QuantityMeasurementEntity;
import com.apps.QuantityMeasurementApp.enums.*;
import com.apps.QuantityMeasurementApp.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {

        double v1 = convertToBase(q1);
        double v2 = convertToBase(q2);

        return Double.compare(v1, v2) == 0;
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        double v1 = convertToBase(q1);
        double v2 = convertToBase(q2);

        double result = v1 + v2;

        repository.save(
                new QuantityMeasurementEntity(
                        q1.getValue(),
                        q2.getValue(),
                        result,
                        "ADD"
                )
        );

        return new QuantityDTO(result, q1.getUnit());
    }

    @Override
    public QuantityDTO convert(QuantityDTO q, Enum<?> unit) {

        if (q.getUnit() instanceof TemperatureUnit) {

            if (q.getUnit() == TemperatureUnit.CELSIUS && unit == TemperatureUnit.FAHRENHEIT) {
                double f = (q.getValue() * 9 / 5) + 32;
                return new QuantityDTO(f, unit);
            }

            if (q.getUnit() == TemperatureUnit.FAHRENHEIT && unit == TemperatureUnit.CELSIUS) {
                double c = (q.getValue() - 32) * 5 / 9;
                return new QuantityDTO(c, unit);
            }
        }

        return new QuantityDTO(q.getValue(), unit);
    }

    private double convertToBase(QuantityDTO q) {

        if (q.getUnit() instanceof LengthUnit) {

            if (q.getUnit() == LengthUnit.INCH) return q.getValue() / 12;
            if (q.getUnit() == LengthUnit.FEET) return q.getValue();
        }

        if (q.getUnit() instanceof WeightUnit) {

            if (q.getUnit() == WeightUnit.GRAM) return q.getValue() / 1000;
            if (q.getUnit() == WeightUnit.KILOGRAM) return q.getValue();
        }

        if (q.getUnit() instanceof VolumeUnit) {

            if (q.getUnit() == VolumeUnit.MILLILITRE) return q.getValue() / 1000;
            if (q.getUnit() == VolumeUnit.LITRE) return q.getValue();
            if (q.getUnit() == VolumeUnit.GALLON) return q.getValue() * 3.78;
        }

        return q.getValue();
    }
}
