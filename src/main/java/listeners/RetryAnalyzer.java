package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import io.qameta.allure.Allure;
import utils.LoggerUtil;

public class RetryAnalyzer implements IRetryAnalyzer{

    private int count = 0;
    private static final int maxRetry = 0;

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetry) {
            count++;

            String testName = result.getName();

            // Logging
            LoggerUtil.error("Retrying test: " + testName + " | Attempt: " + count);

            // Allure Reporting
            Allure.step("Retrying test: " + testName + " | Attempt: " + count);

            return true;
        }

        // Final failure log
        LoggerUtil.error("Test failed after retries: " + result.getName());

        return false;
    }
}
