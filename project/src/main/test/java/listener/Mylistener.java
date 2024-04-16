package listener;

import org.testng.ITestContext;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Com.Base;
import util.Driverconnection;

public abstract class Mylistener extends Base implements  ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	int count = 0;
	@Override
	public void onTestFailure(ITestResult result) {

		getScreenShot(result.getInstanceName()+"_"+result.getName()+"_"+count);
		count++;
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