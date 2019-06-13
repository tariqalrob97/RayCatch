package com.generic.page;

import java.text.MessageFormat;
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
	}

}
