package rahulshettyacademy.TestComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rety implements IRetryAnalyzer {
    int count = 0;
    int maxTry = 1;

    public void Retry() {
    }

    public boolean retry(ITestResult iTestResult) {
        if (this.count < this.maxTry) {
            ++this.count;
            return true;
        } else {
            return false;
        }
    }
}
