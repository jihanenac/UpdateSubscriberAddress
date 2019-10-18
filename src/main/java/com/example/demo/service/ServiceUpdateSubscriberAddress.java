package com.example.demo.service;

import com.example.demo.Subscriber;

public class ServiceUpdateSubscriberAddress {
	
	private final static String country ="FRANCE";

	public ServiceUpdateSubscriberAddress() {
		// TODO Auto-generated constructor stub
	}
	
	public void updateSubscriberAddressIfValid(Subscriber subscriber){
		
		if(subscriber.getCountry().equals(country)){
			 subscriber.setAddress(subscriber.getAddress());
		}
		
	}

}
