package com.raj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raj.demo.data.DataAccess;
import com.raj.demo.model.Partner;
import com.raj.demo.repository.PartnerRepository;
import com.raj.demo.service.PartnerService;

import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PartnerController {

	@Autowired
	PartnerRepository partnerRepository;

	@Autowired
	PartnerService service;

	private static DecimalFormat df = new DecimalFormat(".###");

	@RequestMapping(value = "/getrate1", method = RequestMethod.GET)
	public String solveLevel1(@RequestParam("sellamt") Double sellamt) {
		double rate = service.getExchangeRateForScenario1(sellamt);

		System.out.println(df.format(rate));
		return df.format(rate);
	}
	
	@RequestMapping(value = "/getrate2", method = RequestMethod.GET)
	public String solveLevel2(@RequestParam("sellamt") Double sellamt) {
		double rate = service.getExchangeRateForScenario2(sellamt);

		System.out.println(df.format(rate));
		return df.format(rate);
	}

	@RequestMapping(value = "/getrate3", method = RequestMethod.GET)
	public void solveLevel3() {
		service.getpopulateData();

	}
}