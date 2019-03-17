package com.raj.demo.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "partner_info")
@EntityListeners(AuditingEntityListener.class)

public class Partner implements Serializable {
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double rate;
    private double available;
    private double txnfee;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


    public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}


	public double getAvailable() {
		return available;
	}

	public void setAvailable(double supply) {
		this.available = supply;
	}

	public double getTxnfee() {
		return txnfee;
	}

	public void setTxnfee(double txnfee) {
		this.txnfee = txnfee;
	}

	public double getSortFactor() {
		return 1000*rate - txnfee;
	}
  
}