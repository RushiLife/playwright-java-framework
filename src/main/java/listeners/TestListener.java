package listeners;

import utils.webReausableMethods;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener{

    @Override
    public void onTestFailure(ITestResult result) {
            webReausableMethods.attachScreenshot(result.getName());
    }
    
}
