package com.generic.tests.login;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.generic.page.SignIn;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.ReportUtil;
import com.generic.util.SASLogger;

import com.generic.util.dataProviderUtils;

public class LoginBase extends SelTestCase {

	private static int testCaseID;
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
	public void LoginRegressionTest(String caseId, String runTest, String desc, String proprties, String userName,
			String fieldsValidation) {

		Testlogs.set(new SASLogger("Login " + getBrowserName()));
		// Important to add this for logging/reporting
		setTestCaseReportName(SheetVariables.loginTestCaseId);
		logCaseDetailds(MessageFormat.format(LoggingMsg.TEST_CASE_DESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- ")));

		LinkedHashMap<String, String> userdetails = null;
		if (!userName.equals("")) {
			userdetails = (LinkedHashMap<String, String>) users.get(userName);
			Testlogs.get().debug("Mail will be used is: " + userdetails);
		}

		try {

			if (proprties.equals("Success login")) {
				Testlogs.get().debug("Login username is: " + userName);
				Testlogs.get().debug((String) userdetails.get(SignIn.keys.password));
				SignIn.fillLoginFormAndClickSubmit(userName, (String) userdetails.get(SignIn.keys.password));
				sassert().assertTrue(SignIn.checkUserAccount(), LoggingMsg.USER_IS_NOT_LOGGED_IN_SUCCESSFULLY);
			}
			/*
			if (proprties.equals("invalidUserEmail")) {
				SignIn.fillLoginFormAndClickSubmit(caseMail.replace("@", ""), "1234567");
				String alertMessage = SignIn.getMailErrorMsg();
				sassert().assertTrue(alertMessage.contains(fieldsValidation),
						"Error message is not as expected" + fieldsValidation + " : " + alertMessage);
			}
			if (proprties.equals("invalidUserPassword")) {
				Testlogs.get().debug(caseMail);
				SignIn.fillLoginFormAndClickSubmit(caseMail, "");
				String passwordMessage = SignIn.getPasswrdErrorMsg();
				sassert().assertTrue(passwordMessage.contains(fieldsValidation),
						"Error message is not as expected" + fieldsValidation + " : " + passwordMessage);
				
			}
			if (proprties.equals("wrongUserPassword")) {
				Testlogs.get().debug(caseMail);
				SignIn.fillLoginFormAndClickSubmit(caseMail, "invalid123");
				String loginformMessage = SignIn.getErrologinMessage();
				String failureMessage = MessageFormat.format(LoggingMsg.ACTUAL_EXPECTED_ERROR, loginformMessage,
						fieldsValidation);
				sassert().assertTrue(loginformMessage.contains(fieldsValidation), failureMessage);
			}
			if (proprties.equals("emptyData")) {
				SignIn.fillLoginFormAndClickSubmit("", "");
				String emailMessage = SignIn.getMailErrorMsg();
				String passwordMessage = SignIn.getPasswrdErrorMsg();

				String failureMessage = MessageFormat.format(LoggingMsg.ACTUAL_EXPECTED_ERROR,
						emailMessage + "<br>" + passwordMessage, fieldsValidation);

				sassert().assertTrue(fieldsValidation.contains(emailMessage),"Mail Validation error: "+failureMessage);
				sassert().assertTrue(fieldsValidation.contains(passwordMessage),"Password Validation error"+ failureMessage);
			}

			*/
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
