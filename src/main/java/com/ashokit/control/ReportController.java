package com.ashokit.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.entity.Citizen;
import com.ashokit.searchreq.SearchRequest;
import com.ashokit.servce.Reportservice;



@Controller
public class ReportController {
	
	@Autowired
	private Reportservice repo;
	
	@GetMapping("/")
	public String loadpage(Model model) {
		
		//SearchRequest r=new SearchRequest();
		
		//model.addAttribute("book", r);
		init(model);
		
		
		return "index";
	}
		
		
	
	private void init(Model model) {
		model.addAttribute("request", new SearchRequest());
		model.addAttribute("plannames", repo.getplannames());
		model.addAttribute("planstatus", repo.getplanstatus());
	}
	@PostMapping("/search")
	public String handleSearchRequest(@ModelAttribute("search") SearchRequest request, Model model) {
		System.out.println(request);
		List<Citizen> listPlans = repo.search(request);
		model.addAttribute("plans", listPlans);
		
		init(model);
		return "index";

	}
	

	

}

