package com.generic.page;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

import com.generic.selector.SignInSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class SignIn extends SelTestCase {

	public static class keys {
		public static final String caseId = "caseId";
		public static final String id = "id";
		public static final String userName = "userName";
		public static final String name = "name";
		public static final String password = "password";
		public static final String plants = "plants";
	}

	// done RC
	public static void logIn(String userName, String Password) throws Exception {
		try {
			getCurrentFunctionName(true);
			fillLoginFormAndClickSubmit(userName, Password);
			Thread.sleep(1000);
			if (!checkUserAccount()) {
				throw new Exception("Login failed");
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done RC
	public static void fillLoginFormAndClickSubmit(String userName, String Password) throws Exception {
		try {
			getCurrentFunctionName(true);
			typeUsername(userName);
			// typePassword(Password + ",pressEnter");
			typePassword(Password);
			clickLogin();
			Thread.sleep(3000);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done RC
	public static void clickLogin() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = SignInSelectors.loginBtn;
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// done RC
	public static void typePassword(String password) throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = SignInSelectors.password;
			String valuesArr = password;
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done RC
	public static void typeUsername(String userName) throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = SignInSelectors.userName;
			String valuesArr = userName;
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done RC
	public static boolean checkUserAccount() throws Exception {
		try {
			getCurrentFunctionName(true);
			String url = getDriver().getCurrentUrl();
			getCurrentFunctionName(false);
			return url.contains("portfolio");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

}
