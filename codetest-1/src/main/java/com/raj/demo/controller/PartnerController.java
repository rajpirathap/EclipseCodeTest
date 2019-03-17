package com.raj.demo.controller;

import java.text.DecimalFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.raj.demo.repository.PartnerRepository;
import com.raj.demo.service.PartnerService;

@RestController
@RequestMapping("/api")
public class PartnerController {

	@Autowired
	PartnerRepository partnerRepository;

	@Autowired
	PartnerService service;

	private static DecimalFormat df = new DecimalFormat(".#####");

	/**
	 * REST api to get the rate
	 * 
	 * @param sellamt
	 * @return
	 */
	@RequestMapping(value = "/getrate", method = RequestMethod.GET)
	public String solveLevel2(@RequestParam("sellamt") Double sellamt) {
		double rate = service.getExchangeRateForScenario2(sellamt);

		System.out.println(df.format(rate));
		return df.format(rate);
	}

}