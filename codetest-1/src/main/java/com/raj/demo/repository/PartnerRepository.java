package com.raj.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raj.demo.model.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

}