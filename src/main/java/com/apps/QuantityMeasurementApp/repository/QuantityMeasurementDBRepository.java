
package com.apps.QuantityMeasurementApp.repository;

import com.apps.QuantityMeasurementApp.entity.QuantityMeasurementEntity;
import com.apps.QuantityMeasurementApp.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDBRepository implements IQuantityMeasurementRepository {

    @Override
    public void save(QuantityMeasurementEntity entity) {

        String query = "INSERT INTO quantity_meausurement(operand1, operand2, result, operation) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setDouble(1, entity.getOperand1());
            ps.setDouble(2, entity.getOperand2());
            ps.setDouble(3, entity.getResult());
            ps.setString(4, entity.getOperation());

            ps.executeUpdate();

            System.out.println("Operation saved to database");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {

        List<QuantityMeasurementEntity> list = new ArrayList<>();

        String query = "SELECT operand1, operand2, result, operation FROM quantity_measurement";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                double operand1 = rs.getDouble("operand1");
                double operand2 = rs.getDouble("operand2");
                double result = rs.getDouble("result");
                String operation = rs.getString("operation");

                QuantityMeasurementEntity entity =
                        new QuantityMeasurementEntity(operand1, operand2, result, operation);

                list.add(entity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
