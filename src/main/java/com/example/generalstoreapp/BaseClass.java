package com.example.generalstoreapp;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.DeviceDetails;
import utilities.EnvConstants;
import java.net.URL;

public class BaseClass {

	public static AndroidDriver driver;
	public static WebDriverWait wait;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public DeviceRotation landScape;

	@BeforeSuite
	public void Configuration(ITestContext testContext) throws MalformedURLException, InterruptedException {
		System.out.println("It'll run first Before suite");

		// Create reports directory if it doesn't exist
		File reportsDir = new File(System.getProperty("user.dir") + File.separator + "reports");
		if (!reportsDir.exists()) {
			reportsDir.mkdirs();
		}

		// Initialize ExtentHtmlReporter
		htmlReporter = new ExtentHtmlReporter(reportsDir + File.separator + "Test_Report.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("General Store App Test Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// Add system information to the report
		extent.setSystemInfo("Environment", EnvConstants.Environment);
		extent.setSystemInfo("Tester", "XYZ");

//		logger = extent.createTest(testContext.getName());
		setupDriver(DeviceDetails.MobileBrowserName);
	}

	@AfterSuite
	public void tearDown() {
//		driver.quit();
		// service.stop();

		if (driver != null) {
			driver.quit();
		}
		// Ensure the report is flushed to save the changes
		if (extent != null) {
			extent.flush();
		}
	}

	// This function will handle the browser capabilities and browser setup.
	public static void setupDriver(String browserName) throws MalformedURLException, InterruptedException {

		if (EnvConstants.Environment.equals("qa_environment")) {
			System.out.println("Enviroment: QA");
			DesiredCapabilities cap = new DesiredCapabilities();

			if (DeviceDetails.DeviceName.equals("10BCAB1V1E000CX")) {

				System.out.println("Device Name: 10BCAB1V1E000CX");

				cap.setCapability("platformName", "Android");
				cap.setCapability("platformVersion", "14");
				cap.setCapability("deviceName", "10BCAB1V1E000CX");
				// cap.setCapability("app",
				// "D:\\Android-Automation-2024\\general-store-app\\src\\test\\resources\\General-Store.apk");
				// Path to the APK
				cap.setCapability("appPackage", "com.androidsample.generalstore");
				cap.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");

			} else if (DeviceDetails.DeviceName.equals("Samsung Note 10")) {

				System.out.println("Device Name: Samsung Note 10");

				cap.setCapability("platformName", "Android");
				cap.setCapability("platformVersion", "12");
				cap.setCapability("deviceName", "Galaxy Note10");
				cap.setCapability("app",
						"D:\\Android-Automation-2024\\general-store-app\\src\\test\\resources\\General-Store.apk");
				cap.setCapability("appPackage", "com.androidsample.generalstore");
				cap.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
			}

			// Create an AndroidDriver instance
			driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			System.out.println("Driver created!");

			// Wait for 10 seconds to observe the result
			Thread.sleep(10000);

		} else if (EnvConstants.Environment.equals("staging")) {
			System.out.println("Staging Enviroment");

			DesiredCapabilities cap = new DesiredCapabilities();

			if (DeviceDetails.DeviceName.equals("10BCAB1V1E000CX")) {

				System.out.println("Device Name: 10BCAB1V1E000CX");

				cap.setCapability("platformName", "Android");
				cap.setCapability("platformVersion", "14");
				cap.setCapability("deviceName", "10BCAB1V1E000CX");
				// cap.setCapability("app",
				// "D:\\Android-Automation-2024\\general-store-app\\src\\test\\resources\\General-Store.apk");
				// Path to the APK
				cap.setCapability("appPackage", "com.androidsample.generalstore");
				cap.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");

			} else if (DeviceDetails.DeviceName.equals("Samsung Note 10")) {

				System.out.println("Device Name: Samsung Note 10");

				cap.setCapability("platformName", "Android");
				cap.setCapability("platformVersion", "12");
				cap.setCapability("deviceName", "Galaxy Note10");
				cap.setCapability("app",
						"D:\\Android-Automation-2024\\general-store-app\\src\\test\\resources\\General-Store.apk");
				cap.setCapability("appPackage", "com.androidsample.generalstore");
				cap.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
			}
			// Create an AndroidDriver instance
			driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			System.out.println("Driver created!");

			// Wait for 10 seconds to observe the result
			Thread.sleep(10000);

		}
	}

	// Custom Commands
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

//	public void scrollToEndAction() throws InterruptedException {
//		boolean canScrollMore;
//		do {
//			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
//					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 4.0));
//			Thread.sleep(2000);
//		} while (canScrollMore);
//	}

	public void swipeAction(WebElement firstImg, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) firstImg).getId(), "direction", direction, "percent", 0.75));
	}

	public void dragDrop(WebElement drag) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) drag).getId(), "endX", 618, "endY", 589));
	}

	public DeviceRotation landScape(int x, int y, int z) {
		return this.landScape = new DeviceRotation(x, y, z);
	}

	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

}
