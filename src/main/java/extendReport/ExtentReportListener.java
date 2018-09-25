/**
 * @author rahul.rathore
 *	
 *	24-Jul-2016
 */
package extendReport;

import java.io.IOException;
import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author rahul.rathore
 *
 *         24-Jul-2016
 *
 */
public class ExtentReportListener implements ISuiteListener,ITestListener {

	

	private ExtentReports exReport = null;
	private ExtentTest exTest = null;

	public void onFinish(ISuite arg0) {
		try {
			exReport.flush();
		} finally {
			exReport.close();
		}
	}

	public void onStart(ISuite suite) {
		exReport = new ExtentReports("./test-output//ExtendReport//"
						+ suite.getName() + new Date()
						+ ".html");
		suite.
	}

	public void onFinish(ITestContext test) {
		exReport.endTest(exTest);
	}

	public void onStart(ITestContext test) {
		exTest = exReport.startTest(test.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult test) {
		exTest.log(LogStatus.FAIL, test.getTestClass().getName() + "." + test.getMethod().getMethodName());
		exTest.log(LogStatus.FAIL, test.getThrowable());
		
			String src = GenericHelper.takeScreenShot(test.getMethod().getMethodName());
			exTest.log(LogStatus.INFO, exTest.addScreenCapture( src == null ? "" : src ));
		
	}

	public void onTestSkipped(ITestResult test) {
		exTest.log(LogStatus.SKIP, test.getTestClass().getName() + "." + test.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult test) {
		exTest.log(LogStatus.PASS, test.getTestClass().getName() + "." + test.getMethod().getMethodName());
		
	}

}
