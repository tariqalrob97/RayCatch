package com.generic.page;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.TestUtilities;


public class PlantOverview_PlantInsights extends SelTestCase {
	
	public static double getInsightTotalDevices(String totalDevicesText) {
		getCurrentFunctionName(true);	
		try {
			getCurrentFunctionName(false);
			return Double.parseDouble(totalDevicesText.trim().substring(13, totalDevicesText.length()));
		} 
		catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static double getInsightTotalFaultyDevices(String totalFaultyDevicesText) {
		getCurrentFunctionName(true);
		
		try {
			getCurrentFunctionName(false);
			return Double.parseDouble(totalFaultyDevicesText.trim().substring(
					totalFaultyDevicesText.trim().indexOf("(") + 1, totalFaultyDevicesText.trim().indexOf(")")));
		} 
		
		catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static double getInsightValue(String valueText) {
		getCurrentFunctionName(true);
		
		try {
			getCurrentFunctionName(false);
			if(valueText.contains("$"))
					return TestUtilities.valueParser(valueText.trim());
			else
					return 0;
		} 
		
		catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static double getInsightPercentage(String percantageText) {
		getCurrentFunctionName(true);
		
		try {
			getCurrentFunctionName(false);
			if( percantageText.contains("%"))
				return TestUtilities.valueParser(percantageText);
			else
				return 0;
		} 
		
		catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getInsightStatus(String statusText) {
		getCurrentFunctionName(true);
		
		try {
			getCurrentFunctionName(false);
			return statusText.trim().substring(0, statusText.trim().indexOf(" "));
		} 
		
		catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}//getInsigtStatus  
	
	public static void fillInsigtsIntoPlantObj(plant tmpPlant, String insightInfo) {
		getCurrentFunctionName(true);
		try {
			String [] insightInfoLines = insightInfo.replace("arrow_drop_down", "").replace("0:", "\n").split("\n");
			//The following is insightInfoLines 
			/*
			panel degradation
			Contact us for a full revamping plan.
			Faulty (54)
			$8.63K
			0.05%
			total devices54
			investigate
			*/
			
			//columns 
			int name = 0; 
			int status = 2;
			int numberOfNotHealtyDevices = 2; 
			int insightValue = 3;
			int insightPercent = 4;
			int totalDevices = insightInfoLines.length - 2; //NegativeIndex to cover both Faulty and OK status
			
			
			if (insightInfo.contains("Panel Degradation")) {
				tmpPlant.Panel_Degradation_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]); // This includes faulty and OK status
				tmpPlant.Panel_Degradation_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Panel_Degradation_value = PlantOverview_PlantInsights
						.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Panel_Degradation_percentage = PlantOverview_PlantInsights
						.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Panel_Degradation_status = PlantOverview_PlantInsights
						.getInsightStatus(insightInfoLines[status]);
			}

			else if (insightInfo.contains("Inverter Efficiency Below Spec ")) {

				tmpPlant.Inverter_Efficiency_Below_Spec_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Inverter_Efficiency_Below_Spec_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Inverter_Efficiency_Below_Spec_value = PlantOverview_PlantInsights
						.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Inverter_Efficiency_Below_Spec_percentage = PlantOverview_PlantInsights
						.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Inverter_Efficiency_Below_Spec_status = PlantOverview_PlantInsights
						.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("Voltage Deviation")) {

				tmpPlant.Voltage_Deviation_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Voltage_Deviation_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Voltage_Deviation_value = PlantOverview_PlantInsights.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Voltage_Deviation_percentage = PlantOverview_PlantInsights
						.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Voltage_Deviation_status = PlantOverview_PlantInsights.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("MPPT")) {

				tmpPlant.Mppt_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Mppt_faulty_devices = PlantOverview_PlantInsights.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Mppt_value = PlantOverview_PlantInsights.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Mppt_percentage = PlantOverview_PlantInsights.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Mppt_status = PlantOverview_PlantInsights.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("String Data Integrity")) {

				tmpPlant.String_Data_integrity_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.String_Data_integrity_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.String_Data_integrity_value = PlantOverview_PlantInsights.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.String_Data_integrity_percentage = PlantOverview_PlantInsights
						.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.String_Data_integrity_status = PlantOverview_PlantInsights.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("Inverter Relative Efficiency")) {

				tmpPlant.Inverter_Relative_Efficiency_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Inverter_Relative_Efficiency_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Inverter_Relative_Efficiency_value = PlantOverview_PlantInsights
						.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Inverter_Relative_Efficiency_percentage = PlantOverview_PlantInsights
						.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Inverter_Relative_Efficiency_status = PlantOverview_PlantInsights
						.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("Inverter Downtime")) {

				tmpPlant.Inverter_Downtime_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Inverter_Downtime_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Inverter_Downtime_value = PlantOverview_PlantInsights.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Inverter_Downtime_percentage = PlantOverview_PlantInsights
						.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Inverter_Downtime__status = PlantOverview_PlantInsights.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("Late Awakening")) {

				tmpPlant.Late_Awakening_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Late_Awakening_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Late_Awakening_value = PlantOverview_PlantInsights.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Late_Awakening_percentage = PlantOverview_PlantInsights.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Late_Awakening_status = PlantOverview_PlantInsights.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("Clipping")) {

				tmpPlant.Clipping_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Clipping_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Clipping_value = PlantOverview_PlantInsights.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Clipping_percentage = PlantOverview_PlantInsights.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Clipping_status = PlantOverview_PlantInsights.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("Temperature Alert ")) {

				tmpPlant.Temperature_Alert_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Temperature_Alert_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Temperature_Alert_value = PlantOverview_PlantInsights.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Temperature_Alert_percentage = PlantOverview_PlantInsights
						.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Temperature_Alert_status = PlantOverview_PlantInsights.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("Frequency Deviation")) {

				tmpPlant.Frequency_Deviation_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Frequency_Deviation_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Frequency_Deviation_value = PlantOverview_PlantInsights.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Frequency_Deviation_percentage = PlantOverview_PlantInsights
						.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Frequency_Deviation_status = PlantOverview_PlantInsights.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("Temperature Coefficient ")) {

				tmpPlant.Temperature_Coefficient_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Temperature_Coefficient_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Temperature_Coefficient_value = PlantOverview_PlantInsights.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Temperature_Coefficientpercentage = PlantOverview_PlantInsights
						.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Temperature_Coefficient__status = PlantOverview_PlantInsights.getInsightStatus(insightInfoLines[status]);

			}

			else if (insightInfoLines[0].contains("Disconnected Strings ")) {

				tmpPlant.Disconnected_Strings_total_devices = PlantOverview_PlantInsights
						.getInsightTotalDevices(insightInfoLines[totalDevices]);
				tmpPlant.Disconnected_Strings_faulty_devices = PlantOverview_PlantInsights
						.getInsightTotalFaultyDevices(insightInfoLines[numberOfNotHealtyDevices]);
				tmpPlant.Disconnected_Strings_value = PlantOverview_PlantInsights.getInsightValue(insightInfoLines[insightValue]);
				tmpPlant.Disconnected_Strings_percentage = PlantOverview_PlantInsights
						.getInsightPercentage(insightInfoLines[insightPercent]);
				tmpPlant.Disconnected_Strings_status = PlantOverview_PlantInsights.getInsightStatus(insightInfoLines[status]);

			}
		}

		catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}// fillInsigtsInfoIntoHeatMap

	public static void getPlantInsights(plant tmpPlant) throws Exception {
		getCurrentFunctionName(true);

		try {
			// get insights count / info
			List<WebElement> availbleInsights = HomePage.getAllInsights();
			// loop to iterate all insights and pick any insight is not healthy
			for (int insightIndex = 0; insightIndex < availbleInsights.size(); insightIndex++) {
				WebElement insight = availbleInsights.get(insightIndex);

				if (!insight.getText().contains("Healthy")) {
					String insightInfo = insight.getText();
					fillInsigtsIntoPlantObj(tmpPlant, insightInfo);
				}
			}
		}

		catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}// getPlantInsights

}
