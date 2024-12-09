package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.example.generalstoreapp.BaseClass;

//It's a Listener class, basically it's return the result of test suite that test suite has passed, failed or skipped.
public class SuiteListener implements ITestListener, IAnnotationTransformer {

	// When test suite will have failed, then this method will return the failed
	// status of test suite.
	public void onTestFailure(ITestResult iTestResult) {
//		System.out.println("On_Test_Failure");
//		String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
//				+ iTestResult.getMethod().getMethodName();
//		File f = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(f, new File(fileName + ".png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		BaseClass.logger.fail("Test failed: " + iTestResult.getMethod().getMethodName());
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		System.out.println("On_Test_Success");
//		String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
//				+ result.getMethod().getMethodName();
//		File f = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(f, new File(fileName + ".png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		BaseClass.logger.pass("Test passed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
