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
import com.generic.util.TestUtilities;
import com.generic.util.dataProviderUtils;

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
				
				// For each plant this line will get all insgits listed in the page 
				List<WebElement> availbleInsights = HomePage.getAllInsights();
				
				//Inverter Relative Efficiency arrow_drop_down0: Click Investigate to see which inverters require treatment to improve efficiency.0: Faulty (22)0: $55.59K0: 0.10%0: Total Devices220: Investigate
				
				Testlogs.get()
						.debug("<b>The Values of plant " + plant.getText() + "is  :</b><br>" + tmpPlant.PEI_value + "<br>"
								+ tmpPlant.PEI_percentage + "<br>" + tmpPlant.PERF_value + "<br>" + tmpPlant.PERF_percentage
								+ "<br>" + tmpPlant.Avilability_value + "<br>" + tmpPlant.Avilability_percentage + "<br>");
				
				// This for loop will go over all the insights to check wich ones are faulty and stores thier info
				for (int insightIndex = 0; insightIndex < availbleInsights.size(); insightIndex++) {
					WebElement insight = availbleInsights.get(insightIndex);
					
					if(insight.getText().contains("Faulty")){
						String [] values = insight.getText().replace("arrow_drop_down", "").replace("0:","\n").split("\n");
						
						if(values[0].contains("Panel Degradation") ) {
							
							tmpPlant.Panel_Degradation_total_devices = Double.parseDouble(values[2].trim().substring(8,values[2].length()-1));
							tmpPlant.Panel_Degradation_faulty_devices = Double.parseDouble(values[2].trim().substring( values[2].trim().indexOf("(")+1, values[2].trim().indexOf(")")));
							tmpPlant.Panel_Degradation_value = TestUtilities.valueParser(values[3].trim());
							tmpPlant.Panel_Degradation_percentage = TestUtilities.valueParser(values[4].trim());;
							tmpPlant.Panel_Degradation_status = values[2].trim().substring(0,values[2].trim().indexOf(" "));
							
							
							Testlogs.get().debug("Insight Name: "+values[0]+" Status is: "+tmpPlant.Panel_Degradation_status+" Total # of devices is: "+tmpPlant.Panel_Degradation_total_devices 
									+" Total # of faulty devices "+tmpPlant.Panel_Degradation_faulty_devices+" Value is: "+
									tmpPlant.Panel_Degradation_value+ " Percantage is: "+tmpPlant.Panel_Degradation_percentage);
							
							
						}
						
						else if (values[0].contains("Inverter Efficiency Below Spec ") ) {
							
							tmpPlant.Inverter_Efficiency_Below_Spec_total_devices = 0;
							tmpPlant.Inverter_Efficiency_Below_Spec_faulty_devices = 0;
							tmpPlant.Inverter_Efficiency_Below_Spec_value = 0;
							tmpPlant.Inverter_Efficiency_Below_Spec_percentage = 0;
							
						}
						
						else if (values[0].contains("Voltage Deviation") ) {
							
							tmpPlant.Voltage_Deviation_total_devices = 0;
							tmpPlant.Voltage_Deviation_faulty_devices = 0;
							tmpPlant.Voltage_Deviation_value = 0;
							tmpPlant.Voltage_Deviation_percentage = 0;
							
						}
						
						else if (values[0].contains("MPPT") ) {
							
							tmpPlant.Mppt_total_devices = 0;
							tmpPlant.Mppt_faulty_devices = 0;
							tmpPlant.Mppt_value = 0;               
							tmpPlant.Mppt_percentage = 0;
							
						}
						
						else if (values[0].contains("String Data Integrity") ) {
							
							tmpPlant.String_Data_integrity_total_devices = 0;
							tmpPlant.String_Data_integrity_faulty_devices = 0;
							tmpPlant.String_Data_integrity_value = 0;
							tmpPlant.String_Data_integrity_percentage = 0;
							
						}
						
						else if (values[0].contains("Inverter Relative Efficiency") ) {
							
							tmpPlant.Inverter_Relative_Efficiency_total_devices = 0;
							tmpPlant.Inverter_Relative_Efficiency_faulty_devices = 0;
							tmpPlant.Inverter_Relative_Efficiency_value = 0; 
							tmpPlant.Inverter_Relative_Efficiency_percentage = 0;
							
						}
						
						else if (values[0].contains("Inverter Downtime") ) {
							
							tmpPlant.Inverter_Downtime_total_devices = 0;
							tmpPlant.Inverter_Downtime_faulty_devices = 0;
							tmpPlant.Inverter_Downtime_value = 0;
							tmpPlant.Inverter_Downtime_percentage = 0;
							
						}
						
						else if (values[0].contains("Late Awakening") ) {
							
							tmpPlant.Late_Awakening_total_devices = 0;
							tmpPlant.Late_Awakening_faulty_devices = 0;
							tmpPlant.Late_Awakening_value = 0;
							tmpPlant.Late_Awakening_percentage = 0;
	
						}
						
						else if (values[0].contains("Clipping") ) {
							
							tmpPlant.Clipping_total_devices = 0;
							tmpPlant.Clipping_faulty_devices = 0;
							tmpPlant.Clipping_value = 0;
							tmpPlant.Clipping_percentage = 0;
	
						}
						else if (values[0].contains("Temperature Alert ") ) {
							
							tmpPlant.Temperature_Alert_total_devices = 0;
							tmpPlant.Temperature_Alert_faulty_devices = 0;
							tmpPlant.Temperature_Alert_value = 0;
							tmpPlant.Temperature_Alert_percentage = 0;
	
						}
	
						else if (values[0].contains("Frequency Deviation") ) {
							
							tmpPlant.Frequency_Deviation_total_devices = 0;
							tmpPlant.Frequency_Deviation_faulty_devices = 0;
							tmpPlant.Frequency_Deviation_value = 0;
							tmpPlant.Frequency_Deviation_percentage = 0;
	
						}
						
						else if (values[0].contains("Temperature Coefficient ") ) {
							
							tmpPlant.Temperature_Coefficient_total_devices = 0;
							tmpPlant.Temperature_Coefficient_faulty_devices = 0;
							tmpPlant.Temperature_Coefficient_value = 0;
							tmpPlant.Temperature_Coefficient_percentage = 0;

	
						}
	
						else if (values[0].contains("Disconnected Strings ") ) {
							
							tmpPlant.Disconnected_Strings_total_devices = 0;
							tmpPlant.Disconnected_Strings_faulty_devices = 0;
							tmpPlant.Disconnected_Strings_value = 0;
							tmpPlant.Disconnected_Strings_percentage = 0;

	
						}
						
						
						
						
	
	
						
						
						
						
					}
					
				}
				
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
