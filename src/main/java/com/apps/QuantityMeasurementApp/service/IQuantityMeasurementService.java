package com.apps.QuantityMeasurementApp.service;

import com.apps.QuantityMeasurementApp.dto.QuantityDTO;

public interface IQuantityMeasurementService {

    QuantityDTO addQuantity(QuantityDTO q1, QuantityDTO q2);

    boolean compareQuantity(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO subQuantity(QuantityDTO q1, QuantityDTO q2);

    double divQuantity(QuantityDTO q1, QuantityDTO q2);

}