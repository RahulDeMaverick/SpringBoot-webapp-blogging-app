package com.foodapp.myapp.pojo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView {
	
	
protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Image> imglist = (List<Image>) model.get("viewitem");
		Paragraph title = new Paragraph("Thank you for Downloading the recipie");
	
		
		PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 1.0f});
        table.setSpacingBefore(10);
		
		PdfPCell cell = new PdfPCell();

        cell.setPadding(5);
		
        cell.setPhrase(new Phrase("Product Title"));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Description"));
        table.addCell(cell);
 
     
        for (Image ccc : imglist) {
            table.addCell(ccc.getPostName());
            table.addCell(ccc.getDescription());
            table.addCell(ccc.getImagePath());
        }
        
		pdfdoc.add(title);
		pdfdoc.add(table);
	}


}
