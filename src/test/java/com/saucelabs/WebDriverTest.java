package com.saucelabs;

import com.saucelabs.common.SauceOnDemandAuthentication; 
import com.saucelabs.common.SauceOnDemandSessionIdProvider; 
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.Platform;
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
    

    @Before
	public void setUp() throws Exception {

    	 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
         capabilities.setCapability("version", "5");
         capabilities.setCapability("platform", Platform.XP);
        
        this.driver = new RemoteWebDriver(
					  new URL("http://rohithboora:f55a6595-3f95-4da3-a0f2-c330059dcd50@ondemand.saucelabs.com:80/wd/hub"),
					  capabilities);
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
