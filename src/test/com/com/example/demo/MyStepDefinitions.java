package com.example.demo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.demo.service.DriverInitializer;
import com.example.demo.service.ServiceUpdateSubscriberAddress;

import static org.assertj.core.api.Assertions.assertThat;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class MyStepDefinitions {
	
	@Mock
	private ServiceUpdateSubscriberAddress updateAddressService = new ServiceUpdateSubscriberAddress();
	
	public WebDriver webDriver;
	
	 Subscriber mockedSubscriber = new Subscriber("Colombe Paris", "Paris", true, new Date());
	 
	
	
	public ServiceUpdateSubscriberAddress  updateAdresssService;
	
	@Given("Abonné avec adresse principale en france sans ou avec date d'effet")
	public void abonné_avec_adresse_principale_en_france_sans_ou_avec_date_d_effet() {
		webDriver = DriverInitializer.getDriver("chrome");
		webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
		webDriver.get("file:///C:/Users/Naciri/Desktop/demo/src/main/resources/updateAddress.html");
	}

	@When("le conseiller connecté à canal pour modifier l{string}un abonné avec une adresse principale active ou inactive en france avec ou sans date d'effet")
	public void le_conseiller_connecté_à_canal_pour_modifier_l_un_abonné_avec_une_adresse_principale_active_ou_inactive_en_france_avec_ou_sans_date_d_effet(String string) {
		WebElement webElement = webDriver.findElement(By.id("address"));
        webElement.sendKeys("noisy le grand paris");
        
        
       
	}

	@Then("l{string}abonné modifiée et enregistrée sur l'ensemble des contrats")
	public void l_abonné_modifiée_et_enregistrée_sur_l_ensemble_des_contrats(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 WebElement webElement = webDriver.findElement(By.id("update-btn"));
	     webElement.click();
	     WebElement webElementAddress = webDriver.findElement(By.id("address"));
	     mockedSubscriber.setAddress(webElementAddress.getText());
	     updateAddressService.updateSubscriberAddressIfValid(mockedSubscriber);
	     assertThat(mockedSubscriber.getAddress().compareToIgnoreCase(webElementAddress.getText()));
	     
	}

	@Then("un mouvement de modification est créé")
	public void un_mouvement_de_modification_est_créé() {
	    // Write code here that turns the phrase above into concrete actions
		webDriver.get("file:///C:/Users/Naciri/Desktop/demo/src/main/resources/index.html");
	      
        webDriver.quit();
	    
	}



}
