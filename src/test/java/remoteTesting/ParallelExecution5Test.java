package remoteTesting;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ParallelExecution5Test
{
    @Test
    public void test5() throws MalformedURLException
    {
        DesiredCapabilities des = new DesiredCapabilities().chrome();
        URL u = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(u, des);
        driver.get("https://www.live.in");
        System.out.println(driver.getTitle());
    }
}
