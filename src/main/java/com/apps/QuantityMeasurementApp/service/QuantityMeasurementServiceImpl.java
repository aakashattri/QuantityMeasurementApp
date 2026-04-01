package com.apps.QuantityMeasurementApp.service;

import org.springframework.stereotype.Service;

import com.apps.QuantityMeasurementApp.dto.QuantityDTO;
import com.apps.QuantityMeasurementApp.model.Quantity;
import com.apps.QuantityMeasurementApp.model.Unit;
import com.apps.QuantityMeasurementApp.enums.LengthUnit;
import com.apps.QuantityMeasurementApp.enums.WeightUnit;
import com.apps.QuantityMeasurementApp.enums.VolumeUnit;
import com.apps.QuantityMeasurementApp.enums.TemperatureUnit;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    // 🔥 Resolve unit dynamically (UC10 core concept)
    private Unit resolveUnit(String unit) {
        try { return LengthUnit.valueOf(unit); } catch (Exception ignored) {}
        try { return WeightUnit.valueOf(unit); } catch (Exception ignored) {}
        try { return VolumeUnit.valueOf(unit); } catch (Exception ignored) {}
        try { return TemperatureUnit.valueOf(unit); } catch (Exception ignored) {}

        throw new IllegalArgumentException("Invalid Unit: " + unit);
    }

    // 🔥 Ensure same category (Length != Temperature ❌)
    private void validateSameCategory(Unit u1, Unit u2) {

        if (u1.getCategory() != u2.getCategory()) {
            throw new IllegalArgumentException("Different unit categories not allowed");
        }
    }

    // ================= ADD =================
    @Override
    public QuantityDTO addQuantity(QuantityDTO q1, QuantityDTO q2) {

        Unit u1 = resolveUnit(q1.getUnit());
        Unit u2 = resolveUnit(q2.getUnit());

        validateSameCategory(u1, u2);

        Quantity quantity1 = new Quantity(q1.getValue(), u1);
        Quantity quantity2 = new Quantity(q2.getValue(), u2);

        Quantity result = quantity1.add(quantity2);

        return new QuantityDTO(result.getValue(), result.getUnit().toString());
    }

    // ================= COMPARE =================
    @Override
    public boolean compareQuantity(QuantityDTO q1, QuantityDTO q2) {

        Unit u1 = resolveUnit(q1.getUnit());
        Unit u2 = resolveUnit(q2.getUnit());
        

        Quantity quantity1 = new Quantity(q1.getValue(), u1);
        Quantity quantity2 = new Quantity(q2.getValue(), u2);

        return quantity1.equals(quantity2);
    }

    // ================= SUBTRACT =================
    @Override
    public QuantityDTO subQuantity(QuantityDTO q1, QuantityDTO q2) {

        Unit u1 = resolveUnit(q1.getUnit());
        Unit u2 = resolveUnit(q2.getUnit());

        validateSameCategory(u1, u2);

        Quantity quantity1 = new Quantity(q1.getValue(), u1);
        Quantity quantity2 = new Quantity(q2.getValue(), u2);

        Quantity result = quantity1.subtract(quantity2);

        return new QuantityDTO(result.getValue(), result.getUnit().toString());
    }

    // ================= DIVIDE =================
    @Override
    public double divQuantity(QuantityDTO q1, QuantityDTO q2) {

        Unit u1 = resolveUnit(q1.getUnit());
        Unit u2 = resolveUnit(q2.getUnit());

        validateSameCategory(u1, u2);

        Quantity quantity1 = new Quantity(q1.getValue(), u1);
        Quantity quantity2 = new Quantity(q2.getValue(), u2);

        return quantity1.divide(quantity2);
    }
}