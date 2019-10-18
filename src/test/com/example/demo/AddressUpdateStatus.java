package example.demo;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import com.example.demo.MyStepDefinitions;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;


@RunWith(SerenityRunner.class)
public class AddressUpdateStatus {
	
	    @Steps
	    private MyStepDefinitions myStepDefinitions;
	    
	    @Test
	    public void updateAddress() {
	        myStepDefinitions.l_abonné_modifiée_et_enregistrée_sur_l_ensemble_des_contrats("test");
	    }

}
