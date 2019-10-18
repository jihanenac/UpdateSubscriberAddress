package com.example.demo.service;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInitializer {
	
	private static Properties properties = null;
	 
    static {
        try {
            properties = new Properties();
            properties.load(DriverInitializer.class.getClassLoader()
                    .getResourceAsStream("application.properties"));
            //System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        switch (DriverInitializer.getBrowserProperty(browser)) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        return driver;
    }
 
 
    public static  String getBrowserProperty(String key) {
        return properties == null ? null : properties.getProperty(key, "");
    }

}
