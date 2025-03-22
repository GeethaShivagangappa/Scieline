package com.sci.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sci.qa.base.TestBase;

import com.sci.qa.pages.LoginPage;
import com.sci.qa.pages.ProjectManagementPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	
	ProjectManagementPage PMpage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		PMpage = new ProjectManagementPage();	
	}
	
	@Test()
	public void ProjectManagementAction()
	{
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		PMpage.ProjectManagement_click();
	//	PMpage.validate_CompositionValues();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
