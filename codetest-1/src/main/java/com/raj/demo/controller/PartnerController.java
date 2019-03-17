package com.raj.demo.controller;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.raj.demo.helper.ServiceThread;
import com.raj.demo.repository.PartnerRepository;
import com.raj.demo.service.PartnerService;

@RestController
@RequestMapping("/api")
public class PartnerController {

	@Autowired
	PartnerRepository partnerRepository;
	@Autowired
	ServiceThread th;

	@Autowired
	PartnerService service1;
	ExecutorService pool = Executors.newFixedThreadPool(10);
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
		Double res = null;
		try {
			sellamt = Double.parseDouble(request.getParameter("sellamt"));
			th.setSellAmt(sellamt);
			Future<Double> result = pool.submit(th);
			res = result.get();
			System.out.println(df.format(res));
		} catch (NumberFormatException e) {
			return "Please enetr valid amount";
		} catch (Exception e) {
			System.out.println(e);
			return "Internal server error";
		}

		return df.format(res);
	}

	@RequestMapping(value = "/polulate", method = RequestMethod.GET)
	public void solveLevel3() {
		 service1.getpopulateData();

	}
}