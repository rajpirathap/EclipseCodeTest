package com.raj.demo.data;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.raj.demo.model.Partner;
import com.raj.demo.repository.PartnerRepository;

@Component
public class DataAccess {

	@Autowired
	PartnerRepository partnerRepository;

	public List<Partner> getPopulatedData() {
		List<Partner> partners = new ArrayList<>();
		Partner p1 = new Partner();
		p1.setName("A");
		p1.setAvailable(100.0);
		p1.setRate(1.3);
		partners.add(p1);

		Partner p2 = new Partner();
		p2.setName("B");
		p2.setAvailable(50.0);
		p2.setRate(1.35);
		partners.add(p2);

		Partner p3 = new Partner();
		p3.setName("C");
		p3.setAvailable(20.0);
		p3.setRate(1.37);
		partners.add(p3);

		return partners;
	}

	/**
	 * Get all partners
	 * 
	 * @return
	 */
	public List<Partner> getAllPartners() {
		List<Partner> partners = null;
		try {
			partners = partnerRepository.findAll();
		} catch (Exception e) {
			System.out.println("Database access issue occured");
		}

		return partners;
	}

	/**
	 * Save all partners
	 * 
	 * @param partners
	 */
	public void SaveAllPartners(List<Partner> partners) {
		try {
			partnerRepository.saveAll(partners);
		} catch (Exception e) {
			System.out.println("Database issue occured");
		}
	}

	/**
	 * Helper function used for populate data
	 */
	public void populateData() {
		List<Partner> partners = new ArrayList<>();
		Partner p1 = new Partner();
		p1.setName("A");
		p1.setAvailable(1000.0);
		p1.setRate(1.3);
		p1.setTxnfee(0.0);
		partners.add(p1);

		Partner p2 = new Partner();
		p2.setName("B");
		p2.setAvailable(2000.0);
		p2.setRate(1.305);
		p2.setTxnfee(0.0);
		partners.add(p2);

		Partner p3 = new Partner();
		p3.setName("C");
		p3.setAvailable(2000.0);
		p3.setRate(1.31);
		p3.setTxnfee(5.0);
		partners.add(p3);

		Partner p4 = new Partner();
		p4.setName("D");
		p4.setAvailable(1000.0);
		p4.setRate(1.315);
		p4.setTxnfee(10.0);
		partners.add(p4);

		Partner p5 = new Partner();
		p5.setName("E");
		p5.setAvailable(1000.0);
		p5.setRate(1.32);
		p5.setTxnfee(5.0);
		partners.add(p5);

		Partner p6 = new Partner();
		p6.setName("F");
		p6.setAvailable(4000.0);
		p6.setRate(1.325);
		p6.setTxnfee(15.0);
		partners.add(p6);

		Partner p7 = new Partner();
		p7.setName("G");
		p7.setAvailable(2000.0);
		p7.setRate(1.335);
		p7.setTxnfee(5.0);
		partners.add(p7);

		Partner p8 = new Partner();
		p8.setName("H");
		p8.setAvailable(1000.0);
		p8.setRate(1.34);
		p8.setTxnfee(0.0);
		partners.add(p8);

		Partner p9 = new Partner();
		p9.setName("I");
		p9.setAvailable(3000.0);
		p9.setRate(1.35);
		p9.setTxnfee(30.0);
		partners.add(p9);

		Partner p10 = new Partner();
		p10.setName("J");
		p10.setAvailable(3000.0);
		p10.setRate(1.365);
		p10.setTxnfee(50.0);
		partners.add(p10);

		partnerRepository.saveAll(partners);

	}
}
