package com.sci.qa.pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sci.qa.base.TestBase;
import com.sci.qa.util.*;


public class ProjectManagementPage extends TestBase {

	String value=prop.getProperty("value");

	@FindBy(xpath="//img[contains(@src,'../skylineFormWebapp/images/Property 1=Project Management Hollow (1).svg')]")
	WebElement Sidebar;

	@FindBy(xpath="//a[text()='PROJECT MANAGEMENT']")
	WebElement ProjectManagement;



	@FindBy(xpath="//*[@id=\"ui-id-16\"]/span")
	WebElement btnCreateComposition1;

	@FindBy(xpath="//h2[text()='Experiment']")
	WebElement lblExperiment;

	String xpathexp="//td[text()='"+value+"']";
	//	String filename="UploadPO_"+i+".xlsx";
	@FindBy(xpath="//td[text()='2510-01-001-0005']")
	WebElement lblExperimentval;

	@FindBy(xpath="//button[text()='Composition Details']")
	WebElement btnComposition;

	@FindBy(xpath="//li[@class='ui-tabs-tab ui-corner-top ui-state-default ui-tab ui-tabs-active ui-state-active']")
	WebElement btnCreateComposition;

	@FindBy(xpath="//a[text()='General']")
	WebElement General;

	@FindBy(xpath="//a[text()='Compositions']")
	WebElement Compositions;
	@FindBy(xpath="//*[@class='button dataTableApiButton dataTableApiOptional1  ui-button ui-corner-all ui-widget btn-white-border-blue']")
	WebElement btnCompositiondetails;

	@FindBy(xpath="//*[@id=\"ui-id-16\"]/span")
	WebElement btnCompositiondetails1;
	@FindBy(xpath="	//*[@id=\"compositionDetails\"]/tbody/tr[1]/td[2]")
	WebElement lblValueA;

	@FindBy(xpath="//span[text()='Compound A']")
	WebElement lblCompoundA;

	//*[@id="compositionDetails"]/tbody/tr[1]/td[2]
	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[2]/td[1]/span")
	WebElement lblMaterialH;

	@FindBy(xpath="//span[text()='Material F']")
	WebElement lblMaterialF1;

	@FindBy(xpath="//span[text()='Material G (Plasticizer/Adhesive)']")
	WebElement lblMaterialG;

	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[1]/td[1]/span")
	WebElement lblMaterialG1;

	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[1]/td[2]")
	WebElement lblMaterialGval;

	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[2]/td[1]/span")
	WebElement lblMaterialF;
	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[2]/td[2]")
	WebElement lblMaterialFval;

	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[3]/td[1]/span")
	WebElement lblCompoundA1;
	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[2]/td[2]")
	WebElement lblCompoundAval;

	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[4]/td[1]/span")
	WebElement lblCompoundB1;
	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[2]/td[2]")
	WebElement lblCompoundBval;

	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[5]/td[1]/span")
	WebElement lblMaterialH1;
	@FindBy(xpath="//*[@id=\"compositionDetails\"]/tbody/tr[5]/td[2]")
	WebElement lblMaterialHval;
	// Initializing the Page Objects:
	public ProjectManagementPage() {
		PageFactory.initElements(driver, this);
	}


	public void  ProjectManagement_click()

	{
		Sidebar.click();
		ProjectManagement.click();

	}
	public void ExpirementValue_click()

	{
		TestUtil.waitaction(3);
		Boolean label=	lblExperiment.isDisplayed();
		Assert.assertTrue(true, "ExperimentLabel is Displayed");
		TestUtil.waitaction(2);
		TestUtil.doubleclick(lblExperimentval);	
	}
	public void CreateComposition_click()
	{
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		btnCreateComposition.click();
		TestUtil.waitaction(5);
		//btnCompositiondetails.click();
		TestUtil.doubleclick(btnCompositiondetails);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}



	public void validate_CompositionValues()
	{
		//btnComposition.click();
		//	TestUtil.SwitchToFrame("spreadsheetExcel_spreadIframe");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formIframeId")));
		TestUtil.SwitchToFrame("formIframeId");
		
		//Material G
		String MaterialG=lblMaterialG.getText();
		System.out.println("Material G "+MaterialG);
		String MaterialGval=lblMaterialGval.getText();
		System.out.println("Material G "+MaterialGval);
		assertEquals(MaterialG, "Material G (Plasticizer/Adhesive)", "Material G header is correct");
assertEquals(MaterialGval, "15", "Material G Value is correct");
		
//Material F
		String MaterialF=lblMaterialF.getText();
		System.out.println("Material F "+MaterialF);
		String MaterialFval=lblMaterialFval.getText();
		System.out.println("Material F "+MaterialFval);
		assertEquals(MaterialF, "Material F", "Material F header is correct");
		assertEquals(MaterialFval, "35", "Material F Value is correct");
		
		//Compound A		
		String CompoundA=lblCompoundA1.getText();
		System.out.println("Compound A"+CompoundA);
		String CompoundAval= lblCompoundAval.getText();
		System.out.println("Compound A "+lblCompoundAval);
		assertEquals(CompoundA, "Compound A", "CompoundA header is correct");
		assertEquals(CompoundAval, "20", "Compound A Value is correct");
		
		//Compound B
		String CompoundB=lblCompoundB1.getText();
		System.out.println("Compound B "+CompoundB);
		String CompoundBval=lblCompoundBval.getText();
		System.out.println("Compound B"  +CompoundBval);
		assertEquals(CompoundB, "Compound B", "Compound B header is correct");
		assertEquals(CompoundBval, "10", "CompoundB value is correct");

		//Material H
		String MaterialH1=lblMaterialH1.getText();
		System.out.println("CompoundB1 "+MaterialH1);
		String MaterialHval=lblMaterialHval.getText();
		System.out.println("MaterialH val "+MaterialHval);
		assertEquals(MaterialH1, "Material H", "Material H header is correct");
		assertEquals(MaterialHval, "20", "Material H value is correct");
	}
}






