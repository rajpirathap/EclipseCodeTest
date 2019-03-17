package com.raj.demo;

import static org.junit.Assert.assertEquals;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.raj.demo.model.Partner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Codetest1ApplicationTests {

	private static DecimalFormat df = new DecimalFormat(".###");

	@Test
	public void contextLoads() {
	}

	@Test
	public void testExchangerateCal() {
		double amount = 2000.0;
		double expected = 1.334;
		List<Partner> partners = populateData();
		double actual = Double.parseDouble(df.format(getExchangeRate(partners, amount)));
		assertEquals(expected, actual, 0.0);
	}

	public double getExchangeRate(List<Partner> partners, double amount) {
		partners.sort(Comparator.comparing((Partner a) -> a.getSortFactor()).reversed());
		double remain = amount;
		double transactionFee = 0.0;
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
			transactionFee += partners.get(i).getTxnfee();
		}
		return (totalRate / (amount + transactionFee));
	}

	public List<Partner> populateData() {
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

		return partners;

	}

}
