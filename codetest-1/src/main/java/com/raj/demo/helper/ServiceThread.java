package com.raj.demo.helper;

import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.raj.demo.service.PartnerService;

/**
 * ServiceThread.java This class represents a task calculates exchange rate
 * 
 * 
 */
@Component
public class ServiceThread implements Callable<Double> {

	private double sellamt;

	@Autowired
	PartnerService service;

	public void setSellAmt(Double d) {
		this.sellamt = d;
	}

	public Double call() {
		System.out.println(service);
		double rate = service.getExchangeRateForScenario2(sellamt);
		try {
			Thread.sleep(200);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		return rate;
	}
}
