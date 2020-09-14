package com.qa.base;

import com.aventstack.extentreports.Status;
import com.qa.reports.ExtentReport;
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.util.TimeUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	protected static ThreadLocal<Properties> props = new ThreadLocal<Properties>();
	protected static ThreadLocal<HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal<String> platform = new ThreadLocal<String>();
	protected static ThreadLocal<String> platformVersion = new ThreadLocal<String>();
	protected static ThreadLocal<String> dateTime = new ThreadLocal<String>();
	protected static ThreadLocal<String> deviceName = new ThreadLocal<String>();
	protected static ThreadLocal<String> udid = new ThreadLocal<String>();
	private static AppiumDriverLocalService server;
	TestUtils utils = new TestUtils();

	public AppiumDriver getDriver() {
		return driver.get();
	}

	public String getUdid(){
		return udid.get();
	}

	public void setUdid(String udid2) {
		udid.set(udid2);
	}

	public void setDriver(AppiumDriver driver2) {
		driver.set(driver2);
	}

	public Properties getProps() {
		return props.get();
	}

	public void setProps(Properties props2) {
		props.set(props2);
	}

	public HashMap<String, String> getStrings() {
		return strings.get();
	}

	public void setStrings(HashMap<String, String> strings2) {
		strings.set(strings2);
	}

	public String getPlatform() {
		return platform.get();
	}

	public void setPlatform(String platform2) {
		platform.set(platform2);
	}
	
	public String getPlatformVersion() {
		return platformVersion.get();
	}

	public void setPlatformVersion(String platformVersion2) {
		platformVersion.set(platformVersion2);
	}

	public String getDateTime() {
		return dateTime.get();
	}

	public void setDateTime(String dateTime2) {
		dateTime.set(dateTime2);
	}
	
	public String getDeviceName() {
		return deviceName.get();
	}

	public void setDeviceName(String deviceName2) {
		deviceName.set(deviceName2);
	}

	// constructor
	public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	@BeforeMethod 
	public void beforeMethod() {
//		((CanRecordScreen) getDriver()).startRecordingScreen();

	}

	@AfterMethod 
	public void afterMethod(ITestResult result) throws Exception {

//		String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
//		
//		Map <String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();		
//		String dirPath = "videos" + File.separator + params.get("platformName") + "_" + params.get("platformVersion") + "_" + params.get("deviceName") 
//		+ File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();
//		
//		File videoDir = new File(dirPath);
//		
//		synchronized(videoDir){
//			if(!videoDir.exists()) {
//				videoDir.mkdirs();
//			}	
//		}
//		FileOutputStream stream = null;
//		try {
//			stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
//			stream.write(Base64.decodeBase64(media));
//			stream.close();
//			utils.log().info("video path: " + videoDir + File.separator + result.getName() + ".mp4");
//		} catch (Exception e) {
//			utils.log().error("error during video capture" + e.toString());
//		} finally {
//			if(stream != null) {
//				stream.close();
//			}
//		}

	}

	@BeforeSuite 
	public void beforeSuite() throws Exception, Exception {
		ThreadContext.put("ROUTINGKEY", "server-logs");
		server = getAppiumServerDefault();
		if(!checkIfAppiumServerIsRunnning(4723)) {
			server.start();
			server.clearOutPutStreams();
			utils.log().info("Appium server started..");
		} else {
			utils.log().info("Appium server already running..");
		}
		
		
	}
	
	public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
	    boolean isAppiumServerRunning = false;
	    ServerSocket socket;
	    try {
	        socket = new ServerSocket(port);
	        socket.close();
	    } catch (IOException e) {
	    	System.out.println("1");
	        isAppiumServerRunning = true;
	    } finally {
	        socket = null;
	    }
	    return isAppiumServerRunning;
	}
	
	@AfterSuite 
	public void afterSuite() {
		server.stop();
		utils.log().info("Appium server stopped..");
	}
	
	public AppiumDriverLocalService getAppiumService() {
		HashMap<String, String> environment = new HashMap<String, String>();
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\ASUS\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
				.usingPort(4723)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withLogFile(new File("ServerLogs/server.log")));
	}
	
	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}
	
	@Parameters({ "emulator", "platformName", "platformVersion", "deviceName", "udid", "systemPort", "chromeDriverPort", "mjpegServerPort" })
	@BeforeTest(alwaysRun = true)
	public void beforeTest(@Optional("androidOnly") String emulator, String platformName, String platformVersion, String deviceName, String udid, @Optional("androidOnly") String systemPort, @Optional("androidOnly") String chromeDriverPort, @Optional("androidOnly") String mjpegServerPort)
			throws Exception {
		
		setDateTime(utils.getFormattedDateTime());
		setPlatform(platformName);
		setPlatformVersion(platformVersion);
		setDeviceName(deviceName);
		setUdid(udid);
		URL url;
		InputStream configInStream = null;
		InputStream stringsInStream = null;
		Properties props = new Properties();
		AppiumDriver driver;
		
		String strFile = "logs" + File.separator + platformName + "_" + platformVersion + "_" + deviceName;
		File logFile = new File(strFile);
		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		ThreadContext.put("ROUTINGKEY", strFile);
		utils.log().info("log path: " + strFile);
		
		try {
			props = new Properties();
			String propFileName = "config.properties";
			String xmlFileName = "strings/strings.xml";

			configInStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(configInStream);
			setProps(props);

			stringsInStream = getClass().getClassLoader().getResourceAsStream(xmlFileName);

			setStrings(utils.parseStringXML(stringsInStream));

			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
			url = new URL(props.getProperty("appiumURL") + "4723/wd/hub");

			switch (platformName) {
			case "Android":

				desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
						props.getProperty("androidAutomationName"));
				desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
				desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
				desiredCapabilities.setCapability("appWaitActivity", props.getProperty("androidWaitActivity"));
				desiredCapabilities.setCapability("autoGrantPermissions", true);
				if (emulator.equalsIgnoreCase("true")) {
					desiredCapabilities.setCapability("avd", deviceName);
				} 
				desiredCapabilities.setCapability("systemPort", systemPort);
				desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);
				desiredCapabilities.setCapability("mjpegServerPort", mjpegServerPort);
				desiredCapabilities.setCapability("noReset", "true");
				desiredCapabilities.setCapability("fullReset", "false");
				
			
				
//				File apk = new File(getClass().getResource(props.getProperty("androidAppLocation")).getFile());
//				String apkPath = apk.getAbsolutePath();
//				utils.log().info("app url is "+apkPath);
//				desiredCapabilities.setCapability("app", apkPath);
				
				driver = new AndroidDriver(url, desiredCapabilities);
				break;

			case "iOS":

				desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
						props.getProperty("iOSAutomationName"));
				String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
				desiredCapabilities.setCapability(MobileCapabilityType.APP, iOSAppUrl);
				desiredCapabilities.setCapability("app",
						"C:\\Users\\Asido Sibuea\\Documents\\Android.SauceLabs.Mobile.Sample.app.2.3.0.apk");
				driver = new IOSDriver<MobileElement>(url, desiredCapabilities);
				break;

			default:
				throw new Exception("Invalid platform! -" + platformName);
			}

			setDriver(driver);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (configInStream != null) {
				configInStream.close();
			}

			if (stringsInStream != null) {
				stringsInStream.close();
			}
		}

	}

	public void waitUntilTextChange(MobileElement e, String txtToCheck) {
		WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAITTEXTCHANGE);
		wait.until(ExpectedConditions.textToBePresentInElement(e, txtToCheck));
	}

	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void waitForVisibility(WebElement e){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void clear(MobileElement e) {
		waitForVisibility(e);
		e.clear();
	}

	public void click(MobileElement e) {
		waitForVisibility(e);
		e.click();
	}
	
	public void click(MobileElement e, String logTxt) {
		try {
			waitForVisibility(e);
			utils.log().info(logTxt);
			ExtentReport.getTest().log(Status.INFO, logTxt);
			e.click();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
		}
		
	}

	

	public void sendKeys(MobileElement e, String param) {
		waitForVisibility(e);
		e.sendKeys(param);
	}
	
	public void sendKeys(MobileElement e, String param, String log) {
		waitForVisibility(e);
		utils.log().info(log);
		ExtentReport.getTest().log(Status.INFO, log);
		e.sendKeys(param);
	}

	public String getAttributeValue(MobileElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

	public String getText(MobileElement e) {
		switch (getPlatform()) {
		case "Android":
			return getAttributeValue(e, "text");

		case "iOS":
			return getAttributeValue(e, "label");

		}

		return null;
	}
	
	public String getText(MobileElement e, String msg) {
		waitForVisibility(e);
		String txt = null;
		
		switch (getPlatform()) {
		case "Android":
			txt = getAttributeValue(e, "text");
			break;

		case "iOS":
			txt = getAttributeValue(e, "label");
			break;

		}
		utils.log().info(msg + txt);
		ExtentReport.getTest().log(Status.INFO, msg+txt);
		
		return txt;
	}


	// if a page contains more than one scrollview use the parent to locate the
	// child
	public MobileElement scrollToElement(String type, String txt, String logTxt) {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		
		utils.log().info(logTxt);
		ExtentReport.getTest().log(Status.INFO, logTxt);
		
		return (MobileElement) ((FindsByAndroidUIAutomator) getDriver())
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()."+type+"(\""+txt+"\").instance(0))");
	
	}

	
	
	public void swipingElement(MobileElement e, String direction, String msg) {
		if(e != null) {
			waitForVisibility(e);
		}
		
		String logTxt = "swiping -" + direction + " on "+ msg;
		
		utils.log().info(logTxt);
		ExtentReport.getTest().log(Status.INFO, logTxt);

		Dimension dim = getDriver().manage().window().getSize();
		int startX = 0;
		int endX = 0;
		int y = (int) (dim.getHeight() / 2);

		switch (direction) {
		case "left":
			startX = (int) (dim.getWidth() * 0.5);
			endX = (int) (dim.getWidth() * 0);
			break;
		case "right":
			startX = (int) (dim.getWidth() * 0);
			endX = (int) (dim.getWidth() * 0.5);
			break;
		}

		TouchAction t = new TouchAction(getDriver());
		t.press(PointOption.point(startX, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(endX, y)).release().perform();
		
	}
	
	public void switchElement(MobileElement e, String param, String log) {
		waitForVisibility(e);
		String currentStatus = e.getText().equalsIgnoreCase("aktif") ? TestUtils.ON :TestUtils.OFF;
		if(!param.equalsIgnoreCase(currentStatus)) {
			click(e, log);
		} else {
			utils.log().info("Not "+log+" because it's already "+param);
			ExtentReport.getTest().log(Status.INFO, "Not "+log+" because it's already "+param);
		}
		
	}
	
	public boolean checkVisiblityOfElement(MobileElement element, String log) {
		try {
			waitForVisibility(element);
		} catch (Exception ex) {
			utils.log().info(log+ "tidak ada");
			ExtentReport.getTest().log(Status.INFO, log+ "sudah tidak visible");
			return false;
		}
		
		utils.log().info(log+ "ada");
		ExtentReport.getTest().log(Status.INFO, log+ "visible");
		return true;
	}
	
	public void forceBack() {
		utils.log().info("Menekan tombol kembali");
		((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public void closeApp() {
		((InteractsWithApps) getDriver()).closeApp();
	}

	public void launchApp() {
		((InteractsWithApps) getDriver()).launchApp();
	}

	@AfterTest
	public void afterTest() {
		getDriver().quit();
	}

}
