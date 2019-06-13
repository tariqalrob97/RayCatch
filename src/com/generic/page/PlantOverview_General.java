package com.generic.page;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

import com.generic.selector.PlantOverViewSelector;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;
import com.generic.util.TestUtilities;

public class PlantOverview_General extends SelTestCase {
	// get Plant yearly potential extra income value
	public static double getPlantOverallExtraIncomeValue() throws Exception {
		try {
			getCurrentFunctionName(true);

			SelectorUtil.initializeSelectorsAndDoActions(PlantOverViewSelector.PlantPotentialExtraIncomeValue);
			String GrneralExtraIncomeValue = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return TestUtilities.valueParser(GrneralExtraIncomeValue) ;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// get Plant yearly potential extra income percent
	public static double getPlantOverallExtraIncomePercent() throws Exception {
		try {
			getCurrentFunctionName(true);

			SelectorUtil.initializeSelectorsAndDoActions(PlantOverViewSelector.PlantPotentialExtraIncomePercent);
			String GrneralExtraIncomePercent = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return TestUtilities.valueParser(GrneralExtraIncomePercent);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// get Plant overall performance value
	public static double getOverallPlantPerformanceValue() throws Exception {
		try {
			getCurrentFunctionName(true);

			SelectorUtil.initializeSelectorsAndDoActions(PlantOverViewSelector.PlantPerformanceValue);
			String GrneralExtraIncomePercent = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return TestUtilities.valueParser(GrneralExtraIncomePercent);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// get Plant overall performance percent
	public static double getOverallPlantPerformancePercent() throws Exception {
		try {
			getCurrentFunctionName(true);

			SelectorUtil.initializeSelectorsAndDoActions(PlantOverViewSelector.PlantPerformancePrecent);
			String GrneralExtraIncomePercent = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return TestUtilities.valueParser(GrneralExtraIncomePercent);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

//  get Plant overall availability value 
	public static double getOverallPlantavailabilityValue() throws Exception {
		try {
			getCurrentFunctionName(true);

			SelectorUtil.initializeSelectorsAndDoActions(PlantOverViewSelector.PlantAvailabilityValue);
			String GrneralExtraIncomePercent = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return TestUtilities.valueParser(GrneralExtraIncomePercent);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// get Plant overall availability percent
	public static double getOverallPlantavailabilityPercent() throws Exception {
		try {
			getCurrentFunctionName(true);

			SelectorUtil.initializeSelectorsAndDoActions(PlantOverViewSelector.PlantAvailabilityPrecent);
			String GrneralExtraIncomePercent = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return TestUtilities.valueParser(GrneralExtraIncomePercent);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	

}
