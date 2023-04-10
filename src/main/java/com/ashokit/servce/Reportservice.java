package com.ashokit.servce;

import java.util.List;

import com.ashokit.entity.Citizen;
import com.ashokit.searchreq.SearchRequest;

public interface Reportservice {

	public List<String> getplannames();

	public List<String> getplanstatus();

	public List<Citizen> search(SearchRequest request);

	public boolean excelexport();

	public boolean pdfexport();







}
