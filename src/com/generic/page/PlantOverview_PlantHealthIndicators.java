package com.generic.page;

import java.text.MessageFormat;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.TestUtilities;

public class PlantOverview_PlantHealthIndicators extends SelTestCase {

	public static double getPRDailyHealthValue(String HealthContainerString) {
		getCurrentFunctionName(true);
		
		String startingIndexIndicator = "PRDaily";
		int startingIndex = HealthContainerString.indexOf(startingIndexIndicator)+startingIndexIndicator.length();
		try {
			if (HealthContainerString.contains(startingIndexIndicator)) {
				getCurrentFunctionName(false);
				return TestUtilities.valueParser(HealthContainerString.substring(startingIndex,startingIndex+5));
			}else
				getCurrentFunctionName(false);
				return 0;
		} catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static double getPRSTCDailyHealthValue(String HealthContainerString) {
		getCurrentFunctionName(true);
		
		String startingIndexIndicator = "PRSTCDaily";
		int startingIndex = HealthContainerString.indexOf(startingIndexIndicator)+startingIndexIndicator.length();

		try {
			if (HealthContainerString.contains(startingIndexIndicator)) {
				getCurrentFunctionName(false);
				return TestUtilities.valueParser(HealthContainerString.substring(startingIndex,startingIndex+5));
			}else
				getCurrentFunctionName(false);
				return 0;
		} catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static double getDataIntegrityHealthValue(String HealthContainerString) {
		getCurrentFunctionName(true);
		String startingIndexIndicator = "DataIntegrityDaily";
		int startingIndex = HealthContainerString.indexOf(startingIndexIndicator)+startingIndexIndicator.length();

		try {
			if (HealthContainerString.contains(startingIndexIndicator)) {
				getCurrentFunctionName(false);
				return TestUtilities.valueParser(HealthContainerString.substring(startingIndex,startingIndex+5));
			}else
				getCurrentFunctionName(false);
				return 0;
		}

		catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static double getAvilabilityHealthValue(String HealthContainerString) {
		getCurrentFunctionName(true);
		String startingIndexIndicator = "AvailabilityDaily";
		int startingIndex = HealthContainerString.indexOf(startingIndexIndicator)+startingIndexIndicator.length();

		try {
			if (HealthContainerString.contains(startingIndexIndicator)) {
				getCurrentFunctionName(false);
				return TestUtilities.valueParser(HealthContainerString.substring(startingIndex,startingIndex+5));
			}else
				getCurrentFunctionName(false);
				return 0;
		}

		catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static double getPowerFactorValue(String HealthContainerString) {
		getCurrentFunctionName(true);
		String startingIndexIndicator = "PowerfactorDaily";
		int startingIndex = HealthContainerString.indexOf(startingIndexIndicator)+startingIndexIndicator.length();
		
		try {
			if (HealthContainerString.contains(startingIndexIndicator)) {
				getCurrentFunctionName(false);
				return TestUtilities.valueParser(HealthContainerString.substring(startingIndex,startingIndex+5));
			}else
				getCurrentFunctionName(false);
				return 0;
		}

		catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	//Get and store all health indicators of each plant
	public static void getPlantHealthIndicators(plant tmpPlant, String HealthContainerString) {
		getCurrentFunctionName(true);
		try {
			HealthContainerString = HealthContainerString.trim().replace("\n", "").replace("\r", "").replace("arrow_drop_down", "").replace(" ", "");
			tmpPlant.Health_PRpercentage = getPRDailyHealthValue(HealthContainerString);
			tmpPlant.Health_PR_STCpercentage = getPRSTCDailyHealthValue(HealthContainerString);
			tmpPlant.Health_Data_integrity_percentage = getDataIntegrityHealthValue(HealthContainerString);
			tmpPlant.Health_plantAvilability_percentage = getAvilabilityHealthValue(HealthContainerString);
			tmpPlant.Health_Power_Factor_percentage = getPowerFactorValue(HealthContainerString);
			
			logs.debug("pr "+ tmpPlant.Health_PRpercentage +" prstc"+ tmpPlant.Health_PR_STCpercentage +" dataintig" +tmpPlant.Health_Data_integrity_percentage
					+ " avilla"+tmpPlant.Health_plantAvilability_percentage  + " power factor "+ tmpPlant.Health_Power_Factor_percentage+"ttttttttt");
			getCurrentFunctionName(false);
		} catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
		}

	}
	
	

}
