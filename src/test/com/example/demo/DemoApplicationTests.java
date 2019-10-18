package example.demo;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	    features="src/main/resources/features/updateAddress.feature",
	    glue="com.example.demo",
	    plugin= {"pretty","html:target/cucumber-reports/cucumber-pretty",
	    		"json:report.json"},
	    monochrome=true
	    )
public class DemoApplicationTests  extends AbstractTestNGCucumberTests{
	



}
