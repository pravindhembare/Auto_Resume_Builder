package com.dypatil.autoresumebuilder.classes;


import java.io.File;
import java.io.FileOutputStream;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class Templet1 extends Properties {
			

	static String name = getFirstName();
	
	static String filename;
	Templet1(String fname){
		filename=fname;
		createPdf();
	}
	
	
	
	
	
		
	
	public void createPdf() {
		try {
									
			String file_name="D:\\"+ filename +".pdf";
			Document document	=new Document();
			PdfWriter.getInstance(document, new FileOutputStream(new File(file_name)));
			document.open();
								
			Paragraph para = new Paragraph("Rohya and Niki");
			document.add(new Paragraph(name));	
			document.add(para);					
			
			Table td=new Table(3);
			Cell c1 = new Cell(new Phrase("Heading1"));
			td.addCell(c1);
			Cell c2 = new Cell(new Phrase("Heading2"));
			td.addCell(c2);
			Cell c3 = new Cell(new Phrase("Heading3"));
			td.addCell(c3);
			td.setLastHeaderRow(1);
			td.addCell("1.1");
			td.addCell("1.2");
			td.addCell("1.3");
			td.addCell("2.1");
			td.addCell("2.2");
			td.addCell("2.3");
			document.add(td);
						
			document.add(Image.getInstance("D:\\laptop5.jpg"));
			
			document.close();
			System.out.println("PDF generate succesfully");
											
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
