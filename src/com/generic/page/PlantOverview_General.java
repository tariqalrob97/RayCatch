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
			return TestUtilities.valueParser(GrneralExtraIncomeValue);
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

	// get all general data
	public static void getGeneralPlantInfo(plant tmpPlant) throws Exception {
		try {
			getCurrentFunctionName(true);
			tmpPlant.PEI_value = getPlantOverallExtraIncomeValue();
			tmpPlant.PEI_percentage = getPlantOverallExtraIncomePercent();

			tmpPlant.PERF_value = getOverallPlantPerformanceValue();
			tmpPlant.PERF_percentage = getOverallPlantPerformancePercent();

			tmpPlant.Avilability_value = getOverallPlantavailabilityValue();
			tmpPlant.Avilability_percentage = getOverallPlantavailabilityPercent();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// checks the aggregation of the availability losses of the inverters in the
	// plant, returns 0 if
	// pass and double value if fails
	public static double getCalculatedInvertersAvilability(plant tmpPlant) throws Exception {
		try {
			getCurrentFunctionName(true);
			getCurrentFunctionName(false);

			return tmpPlant.inverters___downtime;
		} catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// checks the aggregation of the performance losses of the inverters in
	// the plant, returns 0 if
	// pass and double value if fails
	public static double getCalcualtedInvertersPerformance(plant tmpPlant) throws Exception {
		try {
			getCurrentFunctionName(true);
			getCurrentFunctionName(false);

			return (tmpPlant.inverters_efficiency_below_spec
					+ tmpPlant.inverters_relative_efficiency + tmpPlant.inverters_Mppt);

		} catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// checks the aggregation of the performance losses of the strings in the plant,
	// returns 0 if
	// pass and double value if fails
	public static double getCalculatedStringsPerformance(plant tmpPlant) throws Exception {
		try {
			getCurrentFunctionName(true);
			getCurrentFunctionName(false);

			return tmpPlant.strings___panel_degradation
					+ tmpPlant.strings___disconnected_strings;

		} catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// checks the aggregation of the availability losses of the strings in the
	// plant, returns 0 if
	// pass and double value if fails
	public static double getCalculatedStringsAvilability(plant tmpPlant) throws Exception {
		try {
			getCurrentFunctionName(true);
			getCurrentFunctionName(false);

			return 0;

		} catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

}
