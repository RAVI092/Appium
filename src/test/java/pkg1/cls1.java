package pkg1;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class cls1 {
public static void main(String[] args) throws InterruptedException, AWTException, IOException {
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.0");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//	dc.setCapability(MobileCapabilityType.APP,
//			"C:\\Users\\Ravi\\Downloads\\Apk.apk");
dc.setCapability("appPackage", "com.android.chrome");
dc.setCapability("appActivity","com.google.android.apps.chrome.Main");
	URL u=new URL("http://localhost:4723/wd/hub");
	AndroidDriver<WebElement> ad=new AndroidDriver<WebElement>(u,dc);
	System.out.println("xbcj hcx");
//	ad.findElement(By.id("com.hindi.jagran.android.activity:id/inputSearch")).sendKeys("bcjkbjsb");
//	ad.findElementById("com.hindi.jagran.android.activity:id/inputSearch\")).sendKeys(\"bcjkbjsb");
	System.out.println("ncjbkbcjbhc bsjb");
	ad.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	Thread.sleep(5000);
	ad.findElement(By.id("com.android.chrome:id/terms_accept")).click();
	ad.findElement(By.id("com.android.chrome:id/next_button")).click();
	ad.findElement(By.id("com.android.chrome:id/negative_button")).click();
	ad.findElement(By.id("com.android.chrome:id/search_box_text")).click();
	
	FileInputStream f=new FileInputStream("D:\\Book2.xlsx");
	XSSFWorkbook x=new XSSFWorkbook(f);
	XSSFCell y=x.getSheetAt(0).getRow(0).getCell(0);
	String s=y.getStringCellValue();
	
	
	ad.findElement(By.id("com.android.chrome:id/url_bar")).sendKeys(s);
	
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
	System.out.println("ravi ");
	org.openqa.selenium.Dimension dim=ad.manage().window().getSize();
	Double sp=(double) dim.getHeight()*.5;
	int st=sp.intValue();
	Double ep=(double) dim.getHeight()*.2;
	int en=ep.intValue();
	System.out.println(st);
	System.out.println(en);
	
	
	TouchAction t=new TouchAction(ad);
	t.longPress(PointOption.point(0, 160)).moveTo(PointOption.point(0, 400)).release().perform();
	System.out.println("lkdhfdshlfjsdvh");
	Thread.sleep(5000);
	t.longPress(PointOption.point(0, 160)).moveTo(PointOption.point(0, 400)).release().perform();
	Thread.sleep(8000);
	t.longPress(PointOption.point(0, 100)).moveTo(PointOption.point(0, 50)).release().perform();
//	JavascriptExecutor j=(JavascriptExecutor)ad;
//
//	j.executeScript("window.scrollBy(0, 100)");
	
//	System.out.println(ad.getCurrentUrl());
//	System.out.println(ad.getTitle());
//	System.out.println(ad.getBatteryInfo());
//	System.out.println(ad.getKeyboard());
//	ad.findElement(By.id("com.android.calculator2:id/digit_8")).click();
	
	

	
	
	
}
}
