package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.model.Cart;


@Service
public class PdfServiceImpl implements  PdfService{
	@Autowired
	private CartSerimpl cartSerimpl;
	
	@Override
	public void exportPdf(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//String path = "F:\\pdf";
		PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document  document = new Document(pdfDocument);
		
		pdfDocument.setDefaultPageSize(PageSize.A4);
		
		
		float col = 280f;
		
		float coloumnWidth [] = {col,col};
		
		Table table = new Table(coloumnWidth);
		
		table.setBackgroundColor(new DeviceRgb(63,169,219))
		.setFontColor(Color.WHITE);
		
		table.addCell(new Cell().add("INVOICE")
				.setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setMarginTop(30f)
				.setMarginBottom(30f)
				.setFontSize(30f)
				.setBorder(Border.NO_BORDER)
				);
		
		table.addCell(new Cell().add("Online Shopping\n+91123456789")
				.setTextAlignment(TextAlignment.RIGHT)
				.setMarginTop(30f)
				.setMarginBottom(30f)
				.setMarginRight(10f)
				.setBorder(Border.NO_BORDER));
		
		float productcolWidth [] = {140,140,140,140};
		Table productTable = new Table(productcolWidth);
		
		productTable.addCell(new Cell().add("product id")
				.setBackgroundColor(new DeviceRgb(63,169,219))
				.setFontColor(Color.WHITE));
		productTable.addCell(new Cell().add("product Name")
				.setBackgroundColor(new DeviceRgb(63,169,219))
				.setFontColor(Color.WHITE));
		productTable.addCell(new Cell().add("product price")
				.setBackgroundColor(new DeviceRgb(63,169,219))
				.setFontColor(Color.WHITE));
		productTable.addCell(new Cell().add("Grand total")
				.setBackgroundColor(new DeviceRgb(63,169,219))
				.setFontColor(Color.WHITE));
		
		List<Cart> cartitems= cartSerimpl.cartProducts();
		for(Cart cart : cartitems) {
			String id =Integer.toString(cart.getProduct().getId());
			String price =Integer.toString(cart.getProduct().getPrice());
		productTable.addCell(new Cell().add(id));
		productTable.addCell(new Cell().add(cart.getProduct().getName()));
		productTable.addCell(new Cell().add(price));
		productTable.addCell(new Cell().add(price));
		}
		
//		productTable.addCell(new Cell().add("12"));
//		productTable.addCell(new Cell().add("samsung"));
//		productTable.addCell(new Cell().add("1557"));
//		productTable.addCell(new Cell().add("15567"));
//		
//		
//		
//		productTable.addCell(new Cell().add("13"));
//		productTable.addCell(new Cell().add("micromax"));
//		productTable.addCell(new Cell().add("756"));
//		productTable.addCell(new Cell().add("6778"));
//		
		productTable.addCell(new Cell().add("")
				.setBackgroundColor(new DeviceRgb(63,169,219))
				.setBorder(Border.NO_BORDER));
		productTable.addCell(new Cell().add("")
				.setBackgroundColor(new DeviceRgb(63,169,219))
				.setBorder(Border.NO_BORDER));
		productTable.addCell(new Cell().add("")
				.setBackgroundColor(new DeviceRgb(63,169,219))
				.setBorder(Border.NO_BORDER));
		productTable.addCell(new Cell().add("")
				.setBackgroundColor(new DeviceRgb(63,169,219))
				.setBorder(Border.NO_BORDER));



		
		document.add(table);
		document.add(productTable);
		document.close();
	
	}

}
