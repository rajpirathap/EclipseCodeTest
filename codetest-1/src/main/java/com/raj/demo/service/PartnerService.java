package com.raj.demo.service;

import java.util.Comparator;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.demo.data.DataAccess;
import com.raj.demo.model.Partner;

@Service
public class PartnerService implements PartnerServiceImpl {

	@Autowired
	DataAccess ds;

	public double getExchangeRateForScenario1(double amount) {
		return getExchangeRate(ds.getPopulatedData(), amount);
	}

	/**
	 * This function returns the final exchange rate
	 * 
	 * @param amount
	 * @return
	 */
	public double getExchangeRateForScenario2(double amount) {
		List<Partner> partners = ds.getAllPartners();
		double rate = getExchangeRate(partners, amount);
		ds.SaveAllPartners(partners);

		return rate;
	}

	/**
	 * This function calculates the effective exchange rate for a given amount
	 * 
	 * @param partners
	 * @param amount
	 * @return
	 */
	@Transactional
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
				partners.get(i).setAvailable(available - remain);
				remain = 0;
			} else if (available < remain) {
				totalRate += available * partners.get(i).getRate();
				partners.get(i).setAvailable(0);
				remain = remain - available;
			}

		}

		return totalRate / amount;
	}
}
