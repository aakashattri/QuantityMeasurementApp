package com.apps.QuantityMeasurementApp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quantity_measurement")
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value;

    private String unit;

    public QuantityMeasurementEntity() {}

    public QuantityMeasurementEntity(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}