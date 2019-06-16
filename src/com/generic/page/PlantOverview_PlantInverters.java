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
	
	public static double getInvertersDataGeneral (String selector) throws Exception {
		try {
			getCurrentFunctionName(true);

			SelectorUtil.initializeSelectorsAndDoActions(selector);
			String GrneralExtraIncomeValue = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return TestUtilities.valueParser(GrneralExtraIncomeValue) ;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
		
		
	}



	// get inverters overall performance value
	public static double getInvertersTabOverallPerformanceValue() throws Exception {
			return getInvertersDataGeneral(PlantOverViewSelector.PlantPerformanceValue);
	}

	// get inverters overall performance percent
	public static double getInvertersTabOverallPerformancePercent() throws Exception {
			return getInvertersDataGeneral(PlantOverViewSelector.PlantPerformancePrecent);
	}

//  get inverters overall availability value 
	public static double getInvertersTabOverallAvailabilityValue() throws Exception {
		return getInvertersDataGeneral(PlantOverViewSelector.PlantAvailabilityValue);
	}

	// get inverters overall availability percent
	public static double getInvertersTabOverallAvailabilityPercent() throws Exception {
			return getInvertersDataGeneral(PlantOverViewSelector.PlantAvailabilityPrecent);
	}
	
	
	public static void getInvertersTabGeneralInfo(plant tmpPlant) throws Exception {
		try {
			getCurrentFunctionName(true);
		

			tmpPlant.inverters___Performance = getInvertersTabOverallPerformanceValue();
			tmpPlant.inverters___availability = getInvertersTabOverallAvailabilityValue();
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
