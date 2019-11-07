package remoteTesting;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class chromeStandAloneTest
{
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities desc = new DesiredCapabilities().chrome();
        URL u = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(u, desc);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
}
