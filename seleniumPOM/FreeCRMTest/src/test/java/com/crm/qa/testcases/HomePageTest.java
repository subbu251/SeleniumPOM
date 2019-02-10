package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	
	public HomePageTest(){
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		testutil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=2)
	public void verifyHomePagetitle() {
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","title is not matched");
	}
	
	@Test(priority=3)
	public void verifyUserNameTest() {
		testutil.switchToFrame();
		Assert.assertEquals(true, homePage.VerifyDisplayUserName());
	}
	
	@Test(priority=1)
	public void VerifyContactsLinkTest() {
		testutil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
