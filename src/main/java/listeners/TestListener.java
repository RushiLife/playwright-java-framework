package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.webReausableMethods;

public class TestListener implements ITestListener{

    @Override
    public void onTestFailure(ITestResult result) {
            webReausableMethods.attachScreenshot(result.getName());
    }
    
}
