package remoteTesting;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ParallelExecution1Test
{


    @Test
    public void test1() throws MalformedURLException
    {
        DesiredCapabilities des = new DesiredCapabilities().chrome();
        URL u = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(u, des);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }

    @BeforeTest
    public void hubInitialization() throws Exception {
        startDocker s1 = new startDocker();
        s1.startDockerFunction();
    }

    @AfterTest
    public void hubDeInitialization() throws Exception
    {
        stopDocker s2 = new stopDocker();
        s2.stopDockerFunction();
    }
}
