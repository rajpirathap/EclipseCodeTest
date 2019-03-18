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

	private static DecimalFormat df = new DecimalFormat(".#####");

	@Test
	public void contextLoads() {
	}

	@Test
	public void testExchangeRate() {
		double actual = getExchangeRate(getPopulatedData(), 70);
		assertEquals(1.35571, Double.parseDouble(df.format(actual)), 0.0);
	}

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
