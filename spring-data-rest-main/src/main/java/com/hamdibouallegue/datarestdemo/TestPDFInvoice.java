package com.hamdibouallegue.datarestdemo;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class TestPDFInvoice {
	
	public static void main(String[] args) throws Exception{
		
		String dest = "/Users/nitingupta/Desktop/addingTable.pdf"; 
		
		 PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD); 
		
		PdfWriter writer = new PdfWriter(dest);
		  
	    PdfDocument pdfDoc = new PdfDocument(writer); 
		
		Document document = new Document(pdfDoc); 
		
		String para1= "GSTIN No.- 09AAACI2341F1ZY                    TAX INVOICE                    PAN NO. AAACI2341F"; 
		
		String para2 = "IANS INDIA PRIVATE LIMITED";
		
		String para3 = "A - 45 to 50, Pioneer House, First Floor, Right Wing, Sector - 16, Noida – 201301. U.P. INDIA";
		
		String para4 = "Tel. : +91-120-4822400. Fax : +91-120-4822403/04";
		
		String para5 = "email : accounts@ians.in";
		
		String para6 = "HINDEX MEDIA UK LTD"
				+ "ASIAN LITE"
				+ "OFFICE GOLD BUILDING 3"
				+ "CHISWICK PARK 566"
				+ "CHISWICK HIGH ROAD"
				+ "LONDON W4 5YA";
		
		String para7 = "Invoice no.: IANS/21-22/N347";
		String para8 = "Dated : 1-Jul-2021";
		
		
		String para9 = "For IANS INDIA PRIVATE LIMITED";
		
		String para10 = "TERMS OF PAYMENTS";
		String para11 = "Bills are payable on presentation";
		String para12 = "Payments should be made in favour of IANS INDIA PRIVATE LIMITED";
			
		
		String para13 = "NOTE: SUPPLY MEANT FOR EXPORT UNDER LETTER OF UNDERTAKING WITHOUT PAYMENT OF INTEGRATED TAX.";
		
		String para14 = "* This is a computer generated invoice and therefore does not require a signature.";
		
		 float [] pointColumnWidths1 = {250f, 645f}; 		
		 Table table1 = new Table(pointColumnWidths1); 
	     
		 float [] pointColumnWidths2 = {482f, 45f}; 		
		 Table table2 = new Table(pointColumnWidths2); 
		 
		 float [] pointColumnWidths3 = {40f, 345f, 100f}; 		
		 Table table3 = new Table(pointColumnWidths3);
		
		  Cell headerColumn1 = new Cell();       
		  headerColumn1.add("S. NO."); 
		  table3.addCell("S. NO.");		
	      
	      Cell headerColumn2 = new Cell();       
	      headerColumn2.add("DESCRIPTION"); 
	      table3.addCell("DESCRIPTION");		
	      
	      Cell headerColumn3 = new Cell();       
	      headerColumn3.add("Amount"); 
	      table3.addCell("Amount");		
		 
		 
	      
	      Cell column1 = new Cell();       
	      column1.add("S. NO."); 
		  table3.addCell("1");		
	      
	      Cell column2 = new Cell();       
	      column2.add("DESCRIPTION"); 
	      table3.addCell("SUBSCRIPTION CHARGES FOR \"IANS ENGLISH NEWS SREVICE\n"
	      		+ "FOR THE PERIOD OF 1 ST JULY 2021 TO 31 ST JULY 2021 \n SAC CODE – 998443").setFontSize(10);		
	      
	 	
	      Cell column3 = new Cell();       
	      column3.add("Amount"); 
		  table3.addCell("150.00");	
	      
	      
		  Cell column4 = new Cell();       
		  column4.add("S. NO."); 
		  table3.addCell("2");		
	      
	      Cell column5 = new Cell();       
	      column5.add("DESCRIPTION"); 
	      table3.addCell("SUBSCRIPTION CHARGES FOR \"IANS ENGLISH NEWS SREVICE\n"
	      		+ "FOR THE PERIOD OF 1 ST JULY 2021 TO 31 ST JULY 2021 \n SAC CODE – 998443").setFontSize(10);		
	      
	 	
	      Cell column6 = new Cell();       
	      column6.add("Amount"); 
		  table3.addCell("150.00");	
		  
		  
		  Cell column7 = new Cell();       
		  column7.add("S. NO."); 
		  table3.addCell("3");		
	      
	      Cell column8 = new Cell();       
	      column8.add("DESCRIPTION"); 
	      table3.addCell("SUBSCRIPTION CHARGES FOR \"IANS ENGLISH NEWS SREVICE\n"
	      		+ "FOR THE PERIOD OF 1 ST JULY 2021 TO 31 ST JULY 2021 \n SAC CODE – 998443").setFontSize(10);		
	      
	 	
	      Cell column9 = new Cell();       
	      column9.add("Amount"); 
		  table3.addCell("150.00");	
	      
	      
	      Cell cellnewtab1 = new Cell();       
	      cellnewtab1.add("Bill To:"); 
	      table1.addCell(para6);		
				
	      Cell cellnewtab2 = new Cell();       
	      cellnewtab2.add("Invoice No:"); 
	      table2.addCell(para7+" "+para8);
	      

		
		// Creating an Area Break    
		Paragraph paragraph1 = new Paragraph (para1).setFontSize(12);
		paragraph1.setFont(font);
		paragraph1.setMarginTop(0);
		
		Paragraph paragraph2 = new Paragraph (para2).setFontSize(15);; 
		paragraph2.setFont(font);
		paragraph2.setTextAlignment(TextAlignment.CENTER);
		
		Paragraph paragraph3 = new Paragraph (para3).setFontSize(8); 
		paragraph3.setTextAlignment(TextAlignment.CENTER);
		paragraph2.setFont(font);
		
		
		Paragraph paragraph4 = new Paragraph (para4).setFontSize(8); 
		paragraph4.setTextAlignment(TextAlignment.CENTER);
		
		Paragraph paragraph5 = new Paragraph (para5).setFontSize(8); 
		paragraph5.setTextAlignment(TextAlignment.CENTER);
		
		Paragraph paragraph6 = new Paragraph (para9).setFontSize(8); 
		paragraph6.setTextAlignment(TextAlignment.RIGHT);
		
		
		Paragraph paragraph7 = new Paragraph (para10).setFont(font).setFontSize(8); 
		paragraph7.setTextAlignment(TextAlignment.LEFT);
		
		
		Paragraph paragraph8 = new Paragraph (para11).setFontSize(8); 
		paragraph8.setTextAlignment(TextAlignment.LEFT);
		
		
		Paragraph paragraph9 = new Paragraph (para12).setFontSize(8); 
		paragraph9.setTextAlignment(TextAlignment.LEFT);
		
		Paragraph paragraph10= new Paragraph (para13).setFont(font).setFontSize(8); 
		paragraph9.setTextAlignment(TextAlignment.LEFT);
		
		
		Paragraph paragraph11 = new Paragraph (para14).setFontSize(8); 
		paragraph9.setTextAlignment(TextAlignment.LEFT);
		
	
		document.add(paragraph1); 
		document.add(paragraph2); 
		document.add(paragraph3); 
		document.add(paragraph4); 
		document.add(paragraph5); 
		
		
		
		document.add(table2); 
		document.add(table1);
		document.add(table3);
		document.add(paragraph6); 
		
		document.add(paragraph7); 
		document.add(paragraph8); 
		document.add(paragraph9); 
		document.add(paragraph10); 
		document.add(paragraph11); 
		
		document.close();
		
	}

}
