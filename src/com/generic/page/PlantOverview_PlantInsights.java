package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.generic.selector.SignInSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PlantOverview_PlantInsights extends SelTestCase {

	// Sample
	public static String checkUserPlants() throws Exception {
		try {
			getCurrentFunctionName(true);
			String plants = "";
			SelectorUtil.initializeSelectorsAndDoActions(SignInSelectors.plantName);

			List<WebElement> allPlants = getDriver().findElements(By.className(SignInSelectors.plantName));

			for (int plant = 0; plant < allPlants.size(); plant++) {
				plants += allPlants.get(plant).getText().toString() + ",";
			}
			getCurrentFunctionName(false);
			return plants;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
}
