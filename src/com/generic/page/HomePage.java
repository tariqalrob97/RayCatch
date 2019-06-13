package com.generic.page;

import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.selector.PlantOverViewSelector;
import com.generic.selector.SignInSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class HomePage extends SelTestCase {
	// done RC
	public static List<WebElement> getUserPlants() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> allPlants = getDriver().findElements(By.cssSelector(SignInSelectors.plantName));
			getCurrentFunctionName(false);
			return allPlants;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done RC
	public static void navigateToPlant(WebElement plant) {
		try {
			getCurrentFunctionName(true);
			logs.debug("Navigating to plant :" + plant.getText());
			plant.click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	// done RC
	public static List<WebElement> getAllInsights() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> allInsights = getDriver().findElements(By.cssSelector(PlantOverViewSelector.Insight));
			getCurrentFunctionName(false);
			logs.debug("Found "+allInsights.size()+ " Insights");
			return allInsights;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

}
