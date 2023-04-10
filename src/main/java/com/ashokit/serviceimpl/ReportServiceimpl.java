package com.ashokit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Citizen;
import com.ashokit.repo.CitizenRepo;
import com.ashokit.searchreq.SearchRequest;
import com.ashokit.servce.Reportservice;

@Service
public class ReportServiceimpl implements Reportservice {
  
	@Autowired
	public CitizenRepo repo;
	
	
	public List<String> getplannames() {
		
		return repo.getplannames();
	}

	public List<String> getplanstatus() {
		// TODO Auto-generated method stub
		return repo.getplanstatus();
	}
     
	
	public List<Citizen> search(SearchRequest request) {
		Citizen citizen = new Citizen();
		if(null !=request.getPlan_Name() && !"".equals(request.getPlan_Name())) {
			citizen.setPLAN_NAME(request.getPlan_Name());	
			
		}
		if(null !=request.getPlan_Status() && !"".equals(request.getPlan_Status())) {
			citizen.setPLAN_STATUS(request.getPlan_Status());	
			
		}
		if(null !=request.getGender() && !"".equals(request.getGender())) {
			citizen.setGENDER(request.getGender());	
			
		}
		
		
		citizen.setPLAN_START_DATE(request.getStartDate());
		citizen.setPLAN_END_DATE(request.getEndDate());
		
		Example<Citizen> example = Example.of(citizen);
		
		return repo.findAll(example);
	}

	public boolean excelexport() {
		
		return false;
	}

	public boolean pdfexport() {
		// TODO Auto-generated method stub
		return false;
	}

}
