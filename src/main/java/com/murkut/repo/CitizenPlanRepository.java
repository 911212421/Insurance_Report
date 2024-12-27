package com.murkut.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.murkut.entity.CitizenPlan;

public interface CitizenPlanRepository 
extends JpaRepository<CitizenPlan, Integer>{
	
	//for dropdown
	@Query("select distinct(planName)from CitizenPlan")//unique data
	public List<String> getPlanNames();
	
	@Query("select distinct(planStatus)from CitizenPlan ")//unique data
	public List<String> getPlanStatus();
}
