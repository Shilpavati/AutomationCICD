package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {
	@Test (retryAnalyzer = TestComponents.Retry.class)
	public void submitOrder() {
	String productName = "IPHONE 13 PRO";
    landingPage.loginApplication("suhanee@khanderkar.com", "Password");
	Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage()); 
	}
}
