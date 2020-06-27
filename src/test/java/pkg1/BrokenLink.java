package pkg1;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrokenLink {
	static DesiredCapabilities dc=new DesiredCapabilities();
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
	//	DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.0");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		dc.setCapability(MobileCapabilityType.APP,
//				"C:\\Users\\Ravi\\Downloads\\Apk.apk");
	dc.setCapability("appPackage", "com.hindi.jagran.android.activity");
	dc.setCapability("appActivity","com.hindi.jagran.android.activity.ui.Activity.MainActivity");
		URL u=new URL("http://localhost:4723/wd/hub");
		AndroidDriver<WebElement> ad=new AndroidDriver<WebElement>(u,dc);
		System.out.println("xbcj hcx");
		ad.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ScreenSht();
		System.out.println("abcde");
		List<WebElement> l=	ad.findElements(By.tagName("androidx"));
//		for(int i=0;i<l.size();i++)
//		{
//			String s=l.get(i).getAttribute("href");
//			urlChe(s);
//		}
		

}
	public static void urlChe(String s1) throws IOException
	{
		URL u=new URL(s1);
		HttpURLConnection h=(HttpURLConnection)u.openConnection();
		h.setConnectTimeout(5000);
		h.connect();
		if(h.getResponseCode()==400)
		{
			System.out.println("Active Link "+h.getResponseMessage());
		}
		else {
			System.out.println("Broken Link "+h.getResponseMessage());
		}
		
	}
	public static void ScreenSht() throws IOException
	{
		URL u=new URL("http://localhost:4723/wd/hub");
		AndroidDriver<WebElement> ad=new AndroidDriver<WebElement>(u,dc);
		TakesScreenshot t=((TakesScreenshot)ad);
		File s=t.getScreenshotAs(OutputType.FILE);
		File d=new File("C:\\Users\\Ravi\\eclipse-workspace\\Appium_Prj1\\ScrSht\\abc.png");
		FileUtil.copyFile(s, d);
//		Files.copy(s, d);
	}
}