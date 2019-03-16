package com.raj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.raj.demo.model.Partner;
import com.raj.demo.repository.PartnerRepository;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PartnerController {

    @Autowired
    PartnerRepository partnerRepository;

 // Get All Partners
    @RequestMapping(value="/partners", method=RequestMethod.GET)
    public List<Partner> getAllPartners() {
    	
    	List<Partner> partners= partnerRepository.findAll();
    	
    	Partner partner = partners.get(1);
    	partner.setSupply(50);
    	partnerRepository.save(partner);
//    	for (int x=0; x< partners.size(); x++) {
//    		Partner partner = partners.get(x);
//    		if(partners.get(x).getName().equalsIgnoreCase("A")) {
//    		partner.setName("D");
//
//    		partnerRepository.saveAndFlush(partner);
//    		System.out.println(partners.get(x).getName());
//    	}
//    	}
    	
    	System.out.println(partnerRepository.findAll());
        return partnerRepository.findAll();
    }
    
    
    @RequestMapping(value="/getrate", method=RequestMethod.GET)
    
    public double solveLevel1(@RequestParam("sellamt") String sellamt) {
    	
    	
    	System.out.println(sellamt);
        return 1.33;
    }

}