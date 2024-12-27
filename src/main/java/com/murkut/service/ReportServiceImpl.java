package com.murkut.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.murkut.entity.CitizenPlan;
import com.murkut.repo.CitizenPlanRepository;
import com.murkut.request.SearchRequest;
import com.murkut.util.EmailUtils;
import com.murkut.util.ExcelGenerator;
import com.murkut.util.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;
@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	public CitizenPlanRepository planRepo;
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfGenerator;
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public List<String> getPlanNames() {
		List<String> planNames = planRepo.getPlanNames();
		return planNames;
	}

	@Override
	public List<String> getPlanStatuses() {
		List<String> planStatus = planRepo.getPlanStatus();
		return planStatus;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();
		BeanUtils.copyProperties(request,entity);

		if (null != request.getPlanName() && !" ".equals(request.getPlanName())) {

			entity.setPlanName(request.getPlanName());
		}

		if (null != request.getPlanStatus() && !" ".equals(request.getPlanStatus())) {

			entity.setPlanStatus(request.getPlanStatus());
		}

		if (null != request.getGender() && !" ".equals(request.getGender())) {

			entity.setGender(request.getGender());
		}
		
		

		if (null != request.getPlanStartDate() && !" ".equals(request.getPlanStartDate())) {
			String startDate = request.getPlanStartDate();
			
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			
			entity.setPlanStartDate((localDate));
		}
		
		
		if (null != request.getPlanEndDate() && !" ".equals(request.getPlanEndDate())) {
			String EndDate = request.getPlanEndDate();
			
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(EndDate,formatter);
			
			entity.setPlanStartDate((localDate));
		} 


		
		
		return planRepo.findAll(Example.of(entity));	
		
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
		File f = new File("plans.xls");
		
		List<CitizenPlan> plans = planRepo.findAll();
		excelGenerator.generate(response,plans,f);
		
		String subject ="test mail subject";
		String body ="<h1> test mail body </h1>";
		String to="parmeshwarmurkut28@gmail.com";
		
				
		emailUtils.sendEmail(subject,body,to,f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception{
		File f = new File("plans.pdf");
		
		List<CitizenPlan> plans = planRepo.findAll();
		pdfGenerator.generate(response,plans,f);
		String subject ="test mail subject";
		String body ="<h1> test mail body </h1>";
		String to="parmeshwarmurkut28@gmail.com";
		
				
		emailUtils.sendEmail(subject,body,to,f);
		f.delete();
		
		return true;
	}

}