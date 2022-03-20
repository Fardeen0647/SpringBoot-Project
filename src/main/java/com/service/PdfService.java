package com.service;import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;



public interface PdfService {
	
	public void exportPdf(HttpServletResponse response) throws  IOException;

}
