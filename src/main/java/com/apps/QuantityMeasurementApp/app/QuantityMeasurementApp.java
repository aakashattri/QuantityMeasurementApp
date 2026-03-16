package com.apps.QuantityMeasurementApp.app;

import com.apps.QuantityMeasurementApp.controller.QuantityMeasurementController;
import com.apps.QuantityMeasurementApp.dto.QuantityDTO;
import com.apps.QuantityMeasurementApp.service.*;

public class QuantityMeasurementApp {

	public static void main(String[] args) {

		IQuantityMeasurementService service = new QuantityMeasurementServiceImpl();

		QuantityMeasurementController controller = new QuantityMeasurementController(service);

		QuantityDTO q1 = new QuantityDTO(10, "FEET", "LENGTH");
		QuantityDTO q2 = new QuantityDTO(5, "FEET", "LENGTH");

		controller.performAddition(q1, q2);
	}
}