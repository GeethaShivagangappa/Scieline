package com.sci.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.util.WorkbookUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sci.qa.base.TestBase;


public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;


	public static WebDriverWait wait = new WebDriverWait( driver, 20);
	
	public static void Pageload()
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	public static void SwitchToFrame(String frameid)
	{
		driver.switchTo().frame(frameid);
	}
	public static void doubleclick(WebElement e)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(e).perform();
	}
	public static boolean waitaction(long seconds) {
		try {

			TimeUnit.SECONDS.sleep(seconds);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	 public static boolean  explwait(String btnComposition) {
         
     	try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnComposition)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         return true;
     } 
	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
	//	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	
	}


