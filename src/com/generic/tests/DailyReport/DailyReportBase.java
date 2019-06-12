package com.generic.tests.DailyReport;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.generic.page.HomePage;
import com.generic.page.PlantOverview_General;
import com.generic.page.SignIn;
import com.generic.page.plant;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.ReportUtil;
import com.generic.util.SASLogger;

import com.generic.util.dataProviderUtils;
import com.generic.util.sqLiteUtils;

public class DailyReportBase extends SelTestCase {

	// used sheet in test
	public static final String testDataSheet = SheetVariables.loginSheet;
	private static XmlTest testObject;

	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();

	@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {
		Testlogs.set(new SASLogger(test.getName() + test.getIndex()));
		testObject = test;
	}

	@DataProvider(name = "Login", parallel = true)
	// concurrency maintenance on sheet reading
	public static Object[][] loadTestData() throws Exception {
		getBrowserWait(testObject.getParameter("browserName"));
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked") // avoid warning from linked hashmap
	@Test(dataProvider = "Login")
	public void LoginRegressionTest(String caseId, String runTest, String desc, String proprties, String userName) {

		Testlogs.set(new SASLogger("DailyReport " + getBrowserName()));
		// Important to add this for logging/reporting
		setTestCaseReportName(SheetVariables.DailyReportTestCaseId);
		logCaseDetailds(MessageFormat.format(LoggingMsg.TEST_CASE_DESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- ")));

		LinkedHashMap<String, String> userdetails = null;
		if (!userName.equals("")) {
			userdetails = (LinkedHashMap<String, String>) users.get(userName);
			Testlogs.get().debug("User will be used is: " + userdetails);
		}
		
		//prepare datasheet  
				
		try {

			// Step 1 do log-in
			Testlogs.get().debug("Login username/password is: " + userName + " " + (String) userdetails.get(SignIn.keys.password) );
			SignIn.fillLoginFormAndClickSubmit(userName, (String) userdetails.get(SignIn.keys.password));
			sassert().assertTrue(SignIn.checkUserAccount(), LoggingMsg.USER_IS_NOT_LOGGED_IN_SUCCESSFULLY);

			// Step 2 get available plants from web
			List<WebElement> availblePlants = HomePage.getUserPlants();
			String accountPlantes = (String) userdetails.get(SignIn.keys.plants);
			
			Testlogs.get().debug("Found " + availblePlants.size() + " plants");
			for (int plantIndex = 0; plantIndex < availblePlants.size(); plantIndex++) {
				Testlogs.get().debug(availblePlants.get(plantIndex).getText());
			}
			Testlogs.get().debug("Account plants " + accountPlantes.replace("\n", "<br>") + " plants");
			
			
			ArrayList<plant> PlantsInfo;
			
			// Step 3 reiterate all plants and validate calculations
			for (int plantIndex = 0; plantIndex < availblePlants.size(); plantIndex++) {
				// get all plants - to avoid element is not attached to the page document
				List<WebElement> currentAvailablePlants = HomePage.getUserPlants();
				WebElement plant = currentAvailablePlants.get(plantIndex);
				
				// Step 4 Navigate to plant status
				HomePage.navigateToPlant(plant);
				sassert().assertTrue(accountPlantes.contains(plant.getText()), "Plant "+ plant.getText() + " is not exist in account plants");

				// Step 5 get plant status general information
				//Initiating new plant object to be used to store all plant object
				plant tmpPlant  = new plant();
				
				tmpPlant.PEI_value = PlantOverview_General.getPlantOverallExtraIncomeValue();
				tmpPlant.PEI_percentage = PlantOverview_General.getPlantOverallExtraIncomePercent();

				tmpPlant.PERF_value = PlantOverview_General.getOverallPlantPerformanceValue();
				tmpPlant.PERF_percentage = PlantOverview_General.getOverallPlantPerformancePercent();

				tmpPlant.Avilability_value = PlantOverview_General.getOverallPlantavailabilityValue();
				tmpPlant.Avilability_percentage = PlantOverview_General.getOverallPlantavailabilityPercent();
				
				
				
				Testlogs.get()
						.debug("<b>The Values of plant " + plant.getText() + "is  :</b><br>" + tmpPlant.PEI_value + "<br>"
								+ tmpPlant.PEI_percentage + "<br>" + tmpPlant.PERF_value + "<br>" + tmpPlant.PERF_percentage
								+ "<br>" + tmpPlant.Avilability_value + "<br>" + tmpPlant.Avilability_percentage + "<br>");

				//this statement should be after getting all data   
				//sqLiteUtils.insertData(tmpPlant, TableName, DatabaseName);
				
				//insert tmpPlant into data base
				//get the day before data from data sheet  
				//compare data provide judgment 
				//get data from other tabs (inverters, strings)
				//do aggregation and other calculations  
				//get insight panels information (4 values) 
				//compare insight information with the day before. 
				//get data for health   
				//compare health data with the previous day
				// get Plant heatmap
				// compare current plant heatmap with the day before  
								
			}

			sassert().assertAll();
			Common.testPass();
		} catch (Throwable t) {
			setTestCaseDescription(getTestCaseDescription());
			Testlogs.get().debug(MessageFormat.format(LoggingMsg.DEBUGGING_TEXT, t.getMessage()));
			t.printStackTrace();
			String temp = getTestCaseReportName();
			Common.testFail(t, temp);
			ReportUtil.takeScreenShot(getDriver(), testDataSheet + "_" + caseId);
			Assert.assertTrue(false, t.getMessage());
		} // catch
	}// test
}
