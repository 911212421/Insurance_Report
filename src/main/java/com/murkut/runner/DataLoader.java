package com.murkut.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.murkut.entity.CitizenPlan;
import com.murkut.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		
		repo.deleteAll();
		
		//cash plan record
		
		CitizenPlan c1=new CitizenPlan();
		
		c1.setCitizenName("john");
		c1.setGender("male");		
		c1.setPlanName("Cash");	
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(5000.00);
		
		
CitizenPlan c2=new CitizenPlan();
		
		c2.setCitizenName("smith");
		c2.setGender("male");		
		c2.setPlanName("Cash");	
		c2.setPlanStatus("denied");
		
		c2.setDenialReason("rental income");
		
		
CitizenPlan c3=new CitizenPlan();
		
		c3.setCitizenName("cris");
		c3.setGender("female");		
		c3.setPlanName("Cash");	
		c3.setPlanStatus("Approved");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmt(5000.00);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationReason("employee");
		
		//food recored
		CitizenPlan c4=new CitizenPlan();
		
		c4.setCitizenName("David");
		c4.setGender("male");		
		c4.setPlanName("food");	
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmt(4000.00);
		
		
CitizenPlan c5=new CitizenPlan();
		
		c5.setCitizenName("robert");
		c5.setGender("male");		
		c5.setPlanName("food");	
		c5.setPlanStatus("denied");
		
		c5.setDenialReason("property income");
		
		
CitizenPlan c6=new CitizenPlan();
		
		c6.setCitizenName("orlean");
		c6.setGender("female");		
		c6.setPlanName("food");	
		c6.setPlanStatus("terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmt(5000.00);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationReason("employee");
		
		
		//medical
		CitizenPlan c7=new CitizenPlan();
		
		c7.setCitizenName("charls");
		c7.setGender("male");		
		c7.setPlanName("medical");	
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmt(5000.00);
		
		
CitizenPlan c8=new CitizenPlan();
		
		c8.setCitizenName("butler");
		c8.setGender("male");		
		c8.setPlanName("medical");	
		c8.setPlanStatus("denied");
		
		c8.setDenialReason("rental income");
		
		
CitizenPlan c9=new CitizenPlan();
		
		c9.setCitizenName("neel");
		c9.setGender("female");		
		c9.setPlanName("medical");	
		c9.setPlanStatus("Approved");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenefitAmt(5000.00);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationReason("goverment job");
		
		
		//employment
		
		CitizenPlan c10=new CitizenPlan();
		
		c10.setCitizenName("gibbs");
		c10.setGender("male");		
		c10.setPlanName("employment");	
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmt(5000.00);
		
		
CitizenPlan c11=new CitizenPlan();
		
		c11.setCitizenName("morris");
		c11.setGender("male");		
		c11.setPlanName("Cash");	
		c11.setPlanStatus("denied");
		
		c11.setDenialReason("property income");
		
		
CitizenPlan c12=new CitizenPlan();
		
		c12.setCitizenName("sita");
		c12.setGender("female");		
		c12.setPlanName("Cash");	
		c12.setPlanStatus("terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenefitAmt(5000.00);
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminationReason("employee");
		
		
		List<CitizenPlan> List = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		
		repo.saveAll(List);
		
	}
	

}
