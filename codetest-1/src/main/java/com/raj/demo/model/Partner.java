package com.raj.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "partner_info")
@EntityListeners(AuditingEntityListener.class)

public class Partner implements Serializable {
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