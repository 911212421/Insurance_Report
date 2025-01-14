package com.murkut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.murkut.entity.CitizenPlan;
import com.murkut.request.SearchRequest;
import com.murkut.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	@Autowired
	public ReportService service;
	
	//download the file
	
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-Stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		service.exportExcel(response);
	}
	
	@PostMapping("/search")
	public String handleSearch(SearchRequest search, Model model) {
		
		System.out.println(search);
		
		List<CitizenPlan> plans = service.search(search);
		model.addAttribute("plans",plans);
		
		model.addAttribute("search",search);
		init(model);
		
		return "index";
		
	}
	
	
	@GetMapping("/")
	public String indexPage(Model model) {		
//SearchRequest search =new SearchRequest();//searchObj sending to ui//bind to ui
		model.addAttribute("search",new SearchRequest());
		
		init(model);
				
		return "index";
	}
	private void init(Model model) {
		//model.addAttribute("search",new SearchRequest());
		model.addAttribute("names",service.getPlanNames());
		model.addAttribute("Status",service.getPlanStatuses());

		
	}

}
