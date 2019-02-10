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

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public ContactsPageTest(){
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=2)
	public void verifyContactsLabelTest() {
		Assert.assertEquals(true, contactsPage.verifyContactsLabel());
	}
	
	@Test(priority=1)
	public void selectContactTest() {
		contactsPage.selectContacts("sudheer b");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
