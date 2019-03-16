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

	private static DecimalFormat df = new DecimalFormat(".#####");

	@RequestMapping(value = "/getrate", method = RequestMethod.GET)
	public String solveLevel1(@RequestParam("sellamt") Double sellamt) {
		double rate = service.getExchangeRateForScenario1(sellamt);

		System.out.println(df.format(rate));
		return df.format(rate);
	}

}