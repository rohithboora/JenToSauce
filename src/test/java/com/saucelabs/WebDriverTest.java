package com.saucelabs;
import com.saucelabs.common.SauceOnDemandAuthentication; 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import static junit.framework.Assert.assertEquals;

/**
 * Simple {@link RemoteWebDriver} test that demonstrates how to run your Selenium tests with <a href="http://ondemand.saucelabs.com/ondemand">Sauce OnDemand</a>.
 * *
 * @author Ross Rowe
 */
public class WebDriverTest {

    private WebDriver driver;
    private String sessionId;
    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication();

    @Before
	public void setUp() throws Exception {

    	DesiredCapabilities capabilities = new DesiredCapabilities();
        String version = Utils.readPropertyOrEnv("SELENIUM_VERSION", "");
        if (!version.equals("")) {
            capabilities.setCapability("version", version);
        }
        capabilities.setCapability("platform", Utils.readPropertyOrEnv("SELENIUM_PLATFORM", "XP"));
        capabilities.setCapability("browserName", Utils.readPropertyOrEnv("SELENIUM_BROWSER", "firefox"));
        String username = Utils.readPropertyOrEnv("SAUCE_USER_NAME", "");
        String accessKey = Utils.readPropertyOrEnv("SAUCE_API_KEY", "");
        this.driver = new RemoteWebDriver(
                new URL("http://" + username + ":" + accessKey + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
        //this.sessionId = ((RemoteWebDriver)driver).getSessionId().toString();
        
    	 /*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
         capabilities.setCapability("version", "5");
         capabilities.setCapability("platform", Platform.XP);
        
        this.driver = new RemoteWebDriver(
					  new URL("http://rohithboora:f55a6595-3f95-4da3-a0f2-c330059dcd50@ondemand.saucelabs.com:80/wd/hub"),
					  capabilities);*/
    }

    @Test
	public void basic() throws Exception {
        driver.get("http://www.amazon.com/");
        assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }

    @After
	public void tearDown() throws Exception {
        driver.quit();
    }

}
