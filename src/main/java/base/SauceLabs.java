package base;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabs extends Driver {
	
	DesiredCapabilities caps;
	
	public void setSauceLabs() {
		
		 final String USERNAME = "YOUR_USERNAME";
		 final String ACCESS_KEY = "YOUR_ACCESS_KEY";
		 final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		 
		 setCapabilities();
		   try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		 
		
	}
	
	public void setCapabilities() {
		
        if(getSaucelabsProperties("browser").equalsIgnoreCase("chrome")) {	
        	caps = DesiredCapabilities.chrome();
        	
        } else if(getSaucelabsProperties("browser").equalsIgnoreCase("firefox")) {
        	caps = DesiredCapabilities.firefox();
        	
        } else if(getSaucelabsProperties("browser").equalsIgnoreCase("safari")) {
        	caps = DesiredCapabilities.safari();
        	
        } else if(getSaucelabsProperties("browser").equalsIgnoreCase("IE")) {
        	caps = DesiredCapabilities.internetExplorer();
        	
        } else {
        	caps = DesiredCapabilities.firefox();
        	
        }
	    caps.setCapability("platform", getSaucelabsProperties("operatingSystem"));
	    caps.setCapability("version", getSaucelabsProperties("browserVersion"));
		
		
	}

}
