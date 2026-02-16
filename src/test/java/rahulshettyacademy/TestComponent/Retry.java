package rahulshettyacademy.TestComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int count = 0;
    int maxTryy = 1;

    @Override
    public boolean retry(ITestResult iTestResult)
    {
        if(count<maxTryy)
        {
            count++;
            return true;
        }
        return false;
    }
}