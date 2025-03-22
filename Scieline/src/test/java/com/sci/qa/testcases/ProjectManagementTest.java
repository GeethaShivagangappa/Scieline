package com.sci.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sci.qa.base.TestBase;
import com.sci.qa.pages.LoginPage;
import com.sci.qa.pages.ProjectManagementPage;

public class ProjectManagementTest extends TestBase{
	LoginPage loginPage;
	
	ProjectManagementPage PMpage;
	
	public ProjectManagementTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		PMpage = new ProjectManagementPage();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void ProjectManagementAction()
	{
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		PMpage.ProjectManagement_click();
		PMpage.ExpirementValue_click();
		PMpage.CreateComposition_click();
		PMpage.validate_CompositionValues();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
	
	
	
	


