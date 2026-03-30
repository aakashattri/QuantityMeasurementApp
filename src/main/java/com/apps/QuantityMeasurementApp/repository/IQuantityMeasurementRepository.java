package com.apps.QuantityMeasurementApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apps.QuantityMeasurementApp.entity.QuantityMeasurementEntity;

@Repository
public interface IQuantityMeasurementRepository 
        extends JpaRepository<QuantityMeasurementEntity, Long> {
}