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

	public double getExchangeRateForScenario2(double amount) {
		List<Partner> partners = ds.getAllPartners();
		double rate = getExchangeRate(partners, amount);
		ds.SaveAllPartners(partners);

		return rate;
	}

	@Transactional
	public double getExchangeRate(List<Partner> partners, double amount) {
		partners.sort(Comparator.comparing((Partner a) -> a.getSortFactor()).reversed());
		double remain= amount;
		double transactionFee=0.0;
		double totalRate=0;
		for(int i=0;i<partners.size() && remain >0;i++){
		    double available =partners.get(i).getAvailable();
		    if(available<=0 ){
		        continue;
		    }else if(available >= remain){
		        totalRate += remain* partners.get(i).getRate();

		        remain = 0;
		    }else if(available < remain){
		        totalRate += available* partners.get(i).getRate();
		        remain = remain -available;
		    }
		    transactionFee+=partners.get(i).getTxnfee();
		}
		return (totalRate / (amount + transactionFee));
	}
	
	public void getpopulateData() {
		ds.populateData();
	}
}
