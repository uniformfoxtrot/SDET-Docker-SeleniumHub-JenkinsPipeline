package remoteTesting;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class firefoxStandAloneTest
{
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities desc = new DesiredCapabilities().firefox();
        //        DesiredCapabilities desc ;
//        desc = new DesiredCapabilities(BrowserType.FIREFOX,
//                "",
//                Platform.ANY);
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, desc);
        driver.get("https://wwww.google.com");
        System.out.println(driver.getTitle());
    }
}
