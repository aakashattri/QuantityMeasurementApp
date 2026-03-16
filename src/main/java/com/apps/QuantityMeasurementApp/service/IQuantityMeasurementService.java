package com.apps.QuantityMeasurementApp.service;

import com.apps.QuantityMeasurementApp.dto.QuantityDTO;

public interface IQuantityMeasurementService {

    boolean compare(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO add(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO convert(QuantityDTO q, Enum<?> targetUnit);
}