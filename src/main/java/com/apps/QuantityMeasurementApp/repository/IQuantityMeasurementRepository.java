package com.apps.QuantityMeasurementApp.repository;

import com.apps.QuantityMeasurementApp.entity.QuantityMeasurementEntity;
import java.util.List;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> findAll();
}