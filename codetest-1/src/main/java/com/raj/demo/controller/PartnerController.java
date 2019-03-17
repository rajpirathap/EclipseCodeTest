package com.raj.demo.controller;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	private static DecimalFormat df = new DecimalFormat(".###");

	/**
	 * REST api to get the rate
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getrate", method = RequestMethod.POST)
	public String solveLevel2(HttpServletRequest request, HttpServletResponse response, Model model) {
		double sellamt = 0.0;
		try {
		sellamt = Double.parseDouble(request.getParameter("sellamt"));
		}catch(Exception e) {
			return "Please enetr valid amount";
		}
		double rate = service.getExchangeRateForScenario2(sellamt);

		System.out.println(df.format(rate));
		return df.format(rate);
	}

	@RequestMapping(value = "/polulate", method = RequestMethod.GET)
	public void solveLevel3() {
		service.getpopulateData();

	}
}