package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.generic.selector.PlantOverViewSelector;
import com.generic.selector.SignInSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;
import com.generic.util.TestUtilities;

public class PlantOverview_PlantInverters extends SelTestCase {
	
	
	public static void getInvertersTabGeneralInfo(plant tmpPlant) throws Exception {
		try {
			getCurrentFunctionName(true);
			String[] generalInfoContainerStrings = HomePage.getInvertersGeneralInfoContainer().getText().trim().split("\n");
			
			// String in the array looks like this
			/*
			 * Plant yearly potential extra income
			 * $16.46K 
			 * 5.06% 
			 * This percentage is relative to your current plant income(current income = 100%) 
			 * Performance 
			 * Performance yearly potential income 
			 * $16.46K 
			 * 5.06% 
			 * Availability 
			 * Availability daily potential income 
			 * $0.00 
			 * 0.00%
			 */

			// Indexes to use with the array
			int PEI_value_index = 1;
			int PEI_percentage_index = 2;
			int PERF_value_index = 5;
			int PERF_percentage_index = 6;
			int Avilability_value_index = 9;
			int Avilability_percentage_index = 10;


			tmpPlant.inverters___Performance = TestUtilities.valueParser(generalInfoContainerStrings[PERF_value_index]);
			//getInvertersTabOverallPerformancePercentage
			// TestUtilities.valueParser(generalInfoContainerStrings[PERF_percentage_index]);

			tmpPlant.inverters___availability = TestUtilities.valueParser(generalInfoContainerStrings[Avilability_value_index]);
			
			//tmpPlant.Avilability_percentage = TestUtilities.valueParser(generalInfoContainerStrings[Avilability_percentage_index]);
			
			tmpPlant.inverters_efficiency_below_spec = tmpPlant.Inverter_Efficiency_Below_Spec_value;
			tmpPlant.inverters_relative_efficiency = tmpPlant.Inverter_Relative_Efficiency_value;
			tmpPlant.inverters_Mppt = tmpPlant.Mppt_value;
			tmpPlant.inverters___downtime = tmpPlant.Inverter_Downtime_value;
		
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
}
