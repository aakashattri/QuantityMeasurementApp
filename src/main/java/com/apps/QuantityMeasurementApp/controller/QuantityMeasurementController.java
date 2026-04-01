package com.apps.QuantityMeasurementApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apps.QuantityMeasurementApp.dto.QuantityDTO;
import com.apps.QuantityMeasurementApp.service.IQuantityMeasurementService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/quantity")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @PostMapping("/add")
    public QuantityDTO add(@RequestBody QuantityDTO[] quantities) {
        return service.addQuantity(quantities[0], quantities[1]);
    }

    @PostMapping("/compare")
    public boolean compare(@RequestBody QuantityDTO[] quantities) {
        return service.compareQuantity(quantities[0], quantities[1]);
    }

    @PostMapping("/subtract")
    public QuantityDTO subtract(@RequestBody QuantityDTO[] quantities) {
        return service.subQuantity(quantities[0], quantities[1]);
    }

    @PostMapping("/divide")
    public double divide(@RequestBody QuantityDTO[] quantities) {
        return service.divQuantity(quantities[0], quantities[1]);
    }
}