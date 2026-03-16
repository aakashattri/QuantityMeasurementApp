package com.apps.QuantityMeasurementApp.controller;

import com.apps.QuantityMeasurementApp.dto.QuantityDTO;
import com.apps.QuantityMeasurementApp.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void performAddition(QuantityDTO q1, QuantityDTO q2) {

        QuantityDTO result = service.add(q1, q2);

        System.out.println("Result: " + result.getValue() +
                " " + result.getUnit());
    }

    public void performConversion(QuantityDTO input, String targetUnit) {

        QuantityDTO result = service.convert(input, targetUnit);

        System.out.println("Converted: " + result.getValue() +
                " " + result.getUnit());
    }
}