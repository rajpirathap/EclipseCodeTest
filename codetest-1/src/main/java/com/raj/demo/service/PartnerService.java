package com.raj.demo.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.raj.demo.data.DataAccess;
import com.raj.demo.model.Partner;

@Service
public class PartnerService implements PartnerServiceImpl {
	/**
	 * This function returns the final exchange rate
	 * 
	 * @param amount
	 * @return
	 */
	public double getExchangeRateForScenario1(double amount) {
		DataAccess ds = new DataAccess();
		return getExchangeRate(ds.getPopulatedData(), amount);
	}

	/**
	 * This function calculates the effective exchange rate for a given amount
	 * 
	 * @param partners
	 * @param amount
	 * @return
	 */
	public double getExchangeRate(List<Partner> partners, double amount) {
		partners.sort(Comparator.comparing((Partner a) -> a.getRate()).reversed());
		double remain = amount;
		double totalRate = 0;
		for (int i = 0; i < partners.size() && remain > 0; i++) {
			double available = partners.get(i).getAvailable();
			if (available <= 0) {
				continue;
			} else if (available >= remain) {
				totalRate += remain * partners.get(i).getRate();
				remain = 0;
			} else if (available < remain) {
				totalRate += available * partners.get(i).getRate();
				remain = remain - available;
			}

		}

		return totalRate / amount;
	}
}
