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

public class PlantOverview_PlantStrings extends SelTestCase {

	public static double getStringsDataGeneral(String selector) throws Exception {
		try {
			getCurrentFunctionName(true);

			SelectorUtil.initializeSelectorsAndDoActions(selector);
			String GrneralExtraIncomeValue = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return TestUtilities.valueParser(GrneralExtraIncomeValue);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// get Strings overall performance value
	public static double getStringsTabOverallPerformanceValue() throws Exception {
		return getStringsDataGeneral(PlantOverViewSelector.PlantPerformanceValue);
	}

	// get Strings overall performance percent
	public static double getStringsTabOverallPerformancePercent() throws Exception {
		return getStringsDataGeneral(PlantOverViewSelector.PlantPerformancePrecent);
	}

//  get Strings overall availability value 
	public static double getStringsTabOverallAvailabilityValue() throws Exception {
		return getStringsDataGeneral(PlantOverViewSelector.PlantAvailabilityValue);
	}

	// get Strings overall availability percent
	public static double getStringsTabOverallAvailabilityPercent() throws Exception {
		return getStringsDataGeneral(PlantOverViewSelector.PlantAvailabilityPrecent);
	}

	public static void getStringsTabGeneralInfo(plant tmpPlant) throws Exception {
		try {
			getCurrentFunctionName(true);

			tmpPlant.strings___performance = getStringsTabOverallPerformanceValue();
			tmpPlant.strings___availability = getStringsTabOverallAvailabilityValue();
			tmpPlant.strings___disconnected_strings = tmpPlant.Disconnected_Strings_value;
			tmpPlant.strings___panel_degradation = tmpPlant.Panel_Degradation_value;

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

}
