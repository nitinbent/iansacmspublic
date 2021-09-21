package com.hamdibouallegue.datarestdemo.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hamdibouallegue.datarestdemo.dto.CreateInvoice;
import com.hamdibouallegue.datarestdemo.dto.DownloadInvoiceDTO;
import com.hamdibouallegue.datarestdemo.dto.GenerateInvoiceDTO;
import com.hamdibouallegue.datarestdemo.dto.LoginRequest;
import com.hamdibouallegue.datarestdemo.dto.RenewInvoice;
import com.hamdibouallegue.datarestdemo.dto.UpdateInvoice;
import com.hamdibouallegue.datarestdemo.models.IansCity;
import com.hamdibouallegue.datarestdemo.models.IansCustomer;
import com.hamdibouallegue.datarestdemo.models.IansInvoice;
import com.hamdibouallegue.datarestdemo.models.IansInvoiceSequence;
import com.hamdibouallegue.datarestdemo.models.IansState;
import com.hamdibouallegue.datarestdemo.models.UserPass;
import com.hamdibouallegue.datarestdemo.repositories.IansCityRepository;
import com.hamdibouallegue.datarestdemo.repositories.IansCustomerRepository;
import com.hamdibouallegue.datarestdemo.repositories.IansInvoiceRepository;
import com.hamdibouallegue.datarestdemo.repositories.IansInvoiceSequenceRepository;
import com.hamdibouallegue.datarestdemo.repositories.IansStateRepository;
import com.hamdibouallegue.datarestdemo.repositories.UserLoginRepository;
import com.hamdibouallegue.datarestdemo.utils.NumberInWords;
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

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class IANSAccoutingController {

	private static final Logger logger = LoggerFactory.getLogger(IANSAccoutingController.class);

	 @Autowired
	 IansStateRepository iansStateRepository;
	 
	 @Autowired
	 IansCityRepository iansCityRepository;
	 
	 @Autowired
	 UserLoginRepository userLoginRepository;
	 
	 @Autowired
	 IansInvoiceRepository iansInvoiceRepository;
	 
	 @Autowired
	 IansCustomerRepository iansCustomerRepository;
	 
	 @Autowired
	 IansInvoiceSequenceRepository iansInvoiceSequenceRepository;

	 
	 @GetMapping(value = "/getStates",produces = MediaType.APPLICATION_JSON_VALUE)
	   	public ResponseEntity<Object> getStates() {
	   	 
	   	   try {
	   		 

	   				   
	   		          List<IansState> states = iansStateRepository.findAll();
	   				   
	   				   if(states!=null)
	   				   {
	   				      return ResponseEntity.ok().body(states);
	   				   }
	   				   else
	   				   {
						  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"No State found\"}");
	   				   }
	   	
	   	} 	
	    catch (Exception e) {
	   		e.printStackTrace();
	   		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	   	}
	   	   	 
	       }
	
	 
	 @GetMapping(value = "/getCities",produces = MediaType.APPLICATION_JSON_VALUE)
	   	public ResponseEntity<Object> getCities() {
	   	 
	   	   try {
	   		 

	   				   
	   		          List<IansCity> cities = iansCityRepository.findAll();
	   				   
	   				   if(cities!=null)
	   				   {
	   				      return ResponseEntity.ok().body(cities);
	   				   }
	   				   else
	   				   {
						  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"No City found\"}");
	   				   }
	   	
	   	} 	
	    catch (Exception e) {
	   		e.printStackTrace();
	   		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	   	}
	   	   	 
	       }
	 
	 
	 @GetMapping(value = "/getAllCustomers",produces = MediaType.APPLICATION_JSON_VALUE)
	   	public ResponseEntity<Object> getAllCustomers() {
	   	 
	   	   try {
	   		 

	   				   
	   		          List<IansCustomer> customers = iansCustomerRepository.findAll();
	   				   
	   				   if(customers!=null)
	   				   {
	   				      return ResponseEntity.ok().body(customers);
	   				   }
	   				   else
	   				   {
						  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"No Customer found\"}");
	   				   }
	   	
	   	} 	
	    catch (Exception e) {
	   		e.printStackTrace();
	   		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	   	}
	   	   	 
	       }
	 
	 @GetMapping(value = "/getAllInvoices",produces = MediaType.APPLICATION_JSON_VALUE)
	   	public ResponseEntity<Object> getAllInvoices() {
	   	 
	   	   try {
 
	   		          List<IansInvoice> invoices = iansInvoiceRepository.findAll();
	   				   
	   				   if(invoices!=null)
	   				   {
	   				      return ResponseEntity.ok().body(invoices);
	   				   }
	   				   else
	   				   {
						  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"No Invoices found\"}");
	   				   }
	   	
	   	} 	
	    catch (Exception e) {
	   		e.printStackTrace();
	   		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	   	}
	   	   	 
	       }
	 
	 @GetMapping(value = "/getRenewInvoices",produces = MediaType.APPLICATION_JSON_VALUE)
	   	public ResponseEntity<Object> getRenewInvoices() {
	   	 
	   	   try {

	   	          LocalDate fifteenDaysAfterDateFromCurrent = LocalDate.now().plusDays(15);
	   	          List<IansInvoice> invoices = iansInvoiceRepository.findBySubscriptionDateBetween(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),Date.from(fifteenDaysAfterDateFromCurrent.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			
	   				   
	   				   if(invoices!=null)
	   				   {
	   				      return ResponseEntity.ok().body(invoices);
	   				   }
	   				   else
	   				   {
						  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"No Invoices found\"}");
	   				   }
	   	
	   	} 	
	    catch (Exception e) {
	   		e.printStackTrace();
	   		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	   	}
	   	   	 
	       }
	 
	 
	@PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  	public ResponseEntity<Object> doLogin(@RequestBody LoginRequest loginRequest) {
  	 
  	   try {
  		 
  			   if(loginRequest.getUserName().isEmpty())
  			   {
  				   return ResponseEntity.badRequest().body("Username cannot be blank");
  			   }
  			   
  			   else if(loginRequest.getUserPassword().isEmpty())
			      {
				   return ResponseEntity.badRequest().body("Password cannot be blank");
			       }
  			     			      			   
  			   else
  			   {
  				   UserPass userPass = userLoginRepository.findByUserNameAndLoginPasswordAndIsActive(loginRequest.getUserName(),loginRequest.getUserPassword(),"1");
  				 
  				   
  				   if(userPass!=null)
  				   {
  				      return ResponseEntity.ok().body(userPass);
  				   }
  				   else
  				      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"Username or Password not valid\"}");
  			   }
  			   
  		   
  	} 
  	 catch (Exception e) {
  		e.printStackTrace();
  		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
  	}
  	   	 
      }
	 
	
	   @PostMapping(value = "/createInvoice",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	 	public ResponseEntity<Object> createInvoice(@RequestBody CreateInvoice createInvoice) {
	 	 
	 	   try {
	 		   
	 		   IansInvoice invoice = new IansInvoice();
	 		   invoice.setCreatedBy(createInvoice.getCreatedBy());
	 		   invoice.setCgstAmount(createInvoice.getTotalCGSTAmount());
	 		   invoice.setSgstAmount(createInvoice.getTotalSGSTAmount());
	 		   invoice.setIgstAmount(createInvoice.getTotalIGSTAmount());
	 		   invoice.setTotalAmount(createInvoice.getTotalAmount());
	 		   invoice.setCustomerName(createInvoice.getCustomerName());
	 		   invoice.setSacCode(createInvoice.getSacCode());
	 		   
	 		  
	 		  // LocalDate invoiceSubscriptionOldDate = LocalDate.now();
			    
	 		   //LocalDate subscriptionMonths = invoiceSubscriptionOldDate.plusMonths(1);

	 		   //invoice.setSubscriptionDate(Date.from(subscriptionMonths.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
   
	 		   
	 		   invoice.setSubscriptionStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(createInvoice.getServiceStartDate()));
	 		   invoice.setSubscriptionDate(new SimpleDateFormat("dd/MM/yyyy").parse(createInvoice.getSubscriptionDate()));
	 		   
	 		   
	 		   //Put Invoice from invoice table itself.
	 		   //invoice.setInvoiceNo(String.format("%04d", new java.util.Random().nextInt(10000))+"_"+ Calendar.YEAR+"_"+createInvoice.getCustomerId());
	 		   
	 		   //Get latest Invoice ID
	 		  IansInvoiceSequence iansInvoiceSequence = iansInvoiceSequenceRepository.findBySequenceTypeAndYearValueAndMonthValue("I",String.valueOf(LocalDate.now().getYear()),String.valueOf(LocalDate.now().getMonth().getValue()));
	 		  invoice.setInvoiceNo(iansInvoiceSequence.getSequencePrefix()+"/"+iansInvoiceSequence.getSequenceStartValue());
	 		   
	 		   invoice.setIsPaid("0");
	 		   invoice.setInvoiceStatus("C");
	 		   invoice.setIansCustomeId(createInvoice.getCustomerId());
	 		   
	 		  invoice.setIansServiceId(createInvoice.getServiceId());
	 		  invoice.setServiceDescription(createInvoice.getServiceDescription());
	 		  invoice.setServiceStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(createInvoice.getServiceStartDate())); 
	 		  invoice.setServiceEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(createInvoice.getServiceEndDate()));
	 		   
	 		   
	 		   invoice = iansInvoiceRepository.save(invoice);
	 		   
	 		   //Update Sequence Id in case of successful invoice creation
	 		  // iansInvoiceSequenceRepository.updateSequenceStartValue(iansInvoiceSequence.getSequenceStartValue()+1, iansInvoiceSequence.getInvoiceId());
	 		   
	 		  iansInvoiceSequence.setSequenceStartValue(iansInvoiceSequence.getSequenceStartValue()+1);
	 		   
	 		  iansInvoiceSequenceRepository.save(iansInvoiceSequence);
	 		   
	 		   if(invoice.getInvoiceId()!=0) {
	 			    
	 			      Map<String,Object> map = new HashMap<>();
	 			      map.put("invoiceNo", invoice.getInvoiceNo());
                      return ResponseEntity.status(HttpStatus.CREATED).body(map);
				    
	 		   }
				      else
				      {
				      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"Error into Insertion for Invoice.\"}");
				      }
				      
	 	       
	 		   
	 	   }
	 	   
	 	  catch (Exception e) {
	 	 		e.printStackTrace();
	 	 		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	 	 	}
	 	   
	   }
	   
	   
	   
	   @PostMapping(value = "/doRenewInvoice",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	 	public ResponseEntity<Object> doRenewInvoice(@RequestBody RenewInvoice renewInvoice) {
	 	 
	 	   try {
	 		   
	 		   for (int i = 0; i < renewInvoice.getRenewServices().size(); i++) 
	 		   {
				
		 		   IansInvoice invoice = new IansInvoice();
		 		   invoice.setCreatedBy(renewInvoice.getRenewServices().get(i).getCreatedBy());
		 		   invoice.setCgstAmount(renewInvoice.getRenewServices().get(i).getTotalCGSTAmount());
		 		   invoice.setSgstAmount(renewInvoice.getRenewServices().get(i).getTotalSGSTAmount());
		 		   invoice.setIgstAmount(renewInvoice.getRenewServices().get(i).getTotalIGSTAmount());
		 		   invoice.setTotalAmount(renewInvoice.getRenewServices().get(i).getTotalAmount());
		 		   invoice.setCustomerName(renewInvoice.getRenewServices().get(i).getCustomerName());
		 		   invoice.setInvoiceId(renewInvoice.getRenewServices().get(i).getInvoiceId());

		 		   LocalDate invoiceSubscriptionOldDate = LocalDate.parse(renewInvoice.getRenewServices().get(i).getSubscriptionDate());
		 			
		 		   LocalDate invoiceSubscriptionNewStartDate = invoiceSubscriptionOldDate.plusDays(1);
		 		   
		 		   LocalDate subscriptionMonths = invoiceSubscriptionOldDate.plusMonths(Integer.parseInt(renewInvoice.getRenewServices().get(i).getSubscriptionValue()));
		 		  
		 		   invoice.setSubscriptionStartDate(Date.from(invoiceSubscriptionNewStartDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		 		   invoice.setSubscriptionDate(Date.from(subscriptionMonths.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		 		   
		 		   //Put Invoice from invoice table itself.
		 		  //invoice.setInvoiceNo(String.format("%04d", new java.util.Random().nextInt(10000))+"_"+ Calendar.YEAR+"_"+renewInvoice.getRenewServices().get(i).getCustomerId());
		 		  
		 		  
		 		   //Get latest Invoice ID
		 		  IansInvoiceSequence iansInvoiceSequence = iansInvoiceSequenceRepository.findBySequenceTypeAndYearValueAndMonthValue("B",String.valueOf(LocalDate.now().getYear()),String.valueOf(LocalDate.now().getMonth().getValue()));
		 		  invoice.setInvoiceNo(iansInvoiceSequence.getSequencePrefix()+"/"+iansInvoiceSequence.getSequenceStartValue());
		 		   
		 		  
		 		  
		 		  // invoice.setIsPaid("0");
		 		  invoice.setIansCustomeId(renewInvoice.getRenewServices().get(i).getCustomerId());
		 		   
		 		  invoice.setIansServiceId(renewInvoice.getRenewServices().get(i).getServiceId());
		 		  invoice.setServiceDescription(renewInvoice.getRenewServices().get(i).getServiceDescription());
		 		  invoice.setServiceStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(renewInvoice.getRenewServices().get(i).getServiceStartDate())); 
		 		  invoice.setServiceEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(renewInvoice.getRenewServices().get(i).getServiceEndDate()));

		 		  invoice = iansInvoiceRepository.save(invoice);
		 		  
		 		  iansInvoiceSequence.setSequenceStartValue(iansInvoiceSequence.getSequenceStartValue()+1);
		 		   
		 		  iansInvoiceSequenceRepository.save(iansInvoiceSequence);

	 			   
			   }
	 		   

				return ResponseEntity.status(HttpStatus.CREATED).body("");
	 	
	 	   
	 	   }
	 	   
	 	  catch (Exception e) {
	 	 		e.printStackTrace();
	 	 		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	 	 	}
	 	   
	   }
	   
	   
	   @GetMapping(value = "/deleteInvoice/{invoiceId}")
	   //@CrossOrigin(origins = "*")
	   	public ResponseEntity<Object> deleteInvoice(@PathVariable("invoiceId") Integer invoiceId) {

	   	   try {
	   		
	   		iansInvoiceRepository.deleteById(invoiceId);
		    return ResponseEntity.ok().body("");

	   	
	   	} 
	   	 catch (Exception e) {
	   		e.printStackTrace();
	   		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	   	}
	   	   	 
	       }
	   
	 
	   @RequestMapping(value = "/updateInvoice",method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseEntity<Object> updateInvoice(@RequestBody UpdateInvoice updateInvoice) {
        
          try {
              
              IansInvoice invoice = new IansInvoice();
              invoice.setCreatedBy(updateInvoice.getCreatedBy());
              invoice.setCgstAmount(updateInvoice.getTotalCGSTAmount());
              invoice.setSgstAmount(updateInvoice.getTotalSGSTAmount());
              invoice.setIgstAmount(updateInvoice.getTotalIGSTAmount());
              invoice.setTotalAmount(updateInvoice.getTotalAmount());
              invoice.setCustomerName(updateInvoice.getCustomerName());
              invoice.setInvoiceId(updateInvoice.getInvoiceId());
              invoice.setSubscriptionDate(new SimpleDateFormat("YYYY-MM-DD").parse(updateInvoice.getSubscriptionDate()));
              
              //Put Invoice from invoice table itself.
              invoice.setInvoiceNo(updateInvoice.getInvoiceNo());
              invoice.setIsPaid("0");
              invoice.setIansCustomeId(updateInvoice.getCustomerId());
              
             invoice.setIansServiceId(updateInvoice.getServiceId());
             invoice.setServiceDescription(updateInvoice.getServiceDescription());
             invoice.setServiceStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(updateInvoice.getServiceStartDate())); 
             invoice.setServiceEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(updateInvoice.getServiceEndDate()));
              
              
              invoice = iansInvoiceRepository.save(invoice);
              
               /*
                * if (invoice.getInvoiceId() != 0) { for (int i = 0; i <
                * createInvoice.getIansServices().size(); i++) {
                * 
                * IansInvoiceService iansInvoiceService = new IansInvoiceService();
                * iansInvoiceService.setCreatedBy(createInvoice.getIansServices().get(i).
                * getCreatedBy());
                * 
                * iansInvoiceService.setIansInvoiceId(invoice.getInvoiceId());
                * iansInvoiceService.setIansServiceId(createInvoice.getIansServices().get(i).
                * getServiceId()); iansInvoiceService
                * .setServiceDescription(createInvoice.getIansServices().get(i).
                * getServiceDescription()); iansInvoiceService.setServiceStartDate(new
                * SimpleDateFormat("dd/MM/yyyy")
                * .parse(createInvoice.getIansServices().get(i).getServiceStartDate()));
                * iansInvoiceService.setServiceEndDate(new SimpleDateFormat("dd/MM/yyyy")
                * .parse(createInvoice.getIansServices().get(i).getServiceEndDate()));
                * 
                * iansInvoiceServiceRepository.save(iansInvoiceService);
                * 
                * }
                * 
                * }
                */
              
              if(invoice.getInvoiceId()!=0) {
                     return ResponseEntity.status(HttpStatus.CREATED).body(invoice.getInvoiceId());
              }
                     else
                     {
                     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"Error into Insertion for Invoice.\"}");
                     }
                     
              
              
          }
          
         catch (Exception e) {
               e.printStackTrace();
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
           }
          
      }
	   
	   
	   @PostMapping("/downloadInvoice")
		public void download(@RequestBody GenerateInvoiceDTO generateInvoiceDTO, HttpServletRequest request,HttpServletResponse response) throws IOException 
		   {
			   

		       ByteArrayOutputStream baos = null;
		       
				try {
			
					baos = generateInvoiceReceipt(generateInvoiceDTO);
			        response.setHeader("Expires", "0");
			        response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
			        response.setHeader("Pragma", "public");
			        response.setContentType("application/pdf");
			        response.setContentLength(baos.size());
			        OutputStream os = response.getOutputStream();
			        baos.writeTo(os);
			        os.flush();
			        os.close(); 
		        
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		       
		       
			   
		   }
		   
		
	   @PostMapping("/downloadInvoices")
		public void downloadInvoices(@RequestBody DownloadInvoiceDTO downloadInvoiceDTO, HttpServletRequest request,HttpServletResponse response) throws IOException 
		   {
			   

		        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
	            ZipOutputStream zipOutputStream = new ZipOutputStream(byteOutputStream);

		      // ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
		       List<File> files = new ArrayList<>();
		       
				try {
							
				
				    for (int i = 0; i < downloadInvoiceDTO.getDownloadInvoices().size(); i++) 
				    {
						
				    	    ByteArrayOutputStream baos =   generateInvoiceReceipt(downloadInvoiceDTO.getDownloadInvoices().get(i));
				    	    InputStream targetStream = new ByteArrayInputStream(baos.toByteArray());
				            zipOutputStream.putNextEntry(new ZipEntry(downloadInvoiceDTO.getDownloadInvoices().get(i).getInvoiceNo()+".pdf"));           
				            IOUtils.copy(targetStream, zipOutputStream);
				            baos.close();
				            targetStream.close();
				            zipOutputStream.closeEntry();
				    	
					} 	
				   
			        zipOutputStream.close();
					
					
			        response.setHeader("Expires", "0");
			        response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
			        response.setHeader("Pragma", "public");
			        response.setContentType("application/zip");
			        response.setStatus(HttpServletResponse.SC_OK);
			        
			        String outputFilename = "invoices_"+System.currentTimeMillis()+".zip";
			        response.setHeader("Content-Disposition", "attachment; filename=\"invoices.zip\"");
			        
			        
			        response.setContentLength(byteOutputStream.size());
			        OutputStream os = response.getOutputStream();
			        byteOutputStream.writeTo(os);
			        os.flush();
			        os.close(); 
		        
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		       
		       
			   
		   }
	   
			/*
			 * private FileOutputStream generateBulkInvoiceReceipt(GenerateInvoiceDTO
			 * generateInvoiceDTO) throws Exception { File file = new
			 * File(generateInvoiceDTO.getInvoiceNo()); FileOutputStream fileout = new
			 * FileOutputStream(file);
			 * 
			 * PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
			 * 
			 * PdfWriter writer = new PdfWriter(fileout);
			 * 
			 * PdfDocument pdfDoc = new PdfDocument(writer);
			 * 
			 * Document document = new Document(pdfDoc);
			 * 
			 * 
			 * String para1=
			 * "GSTIN No.- 09AAACI2341F1ZY                    TAX INVOICE                    PAN NO. AAACI2341F"
			 * ;
			 * 
			 * String para15 = "UP CODE - 09";
			 * 
			 * String para2 = "IANS INDIA PRIVATE LIMITED";
			 * 
			 * String para3 =
			 * "A - 45 to 50, Pioneer House, First Floor, Right Wing, Sector - 16, Noida – 201301. U.P. INDIA"
			 * ;
			 * 
			 * String para4 = "Tel. : +91-120-4822400. Fax : +91-120-4822403/04";
			 * 
			 * String para5 = "email : accounts@ians.in";
			 * 
			 * String para6 = generateInvoiceDTO.getCompanyName()+"\n" +
			 * generateInvoiceDTO.getHeadOfficeAddress()+"\n" +
			 * generateInvoiceDTO.getGstNo();
			 * 
			 * String para7 = generateInvoiceDTO.getInvoiceNo();
			 * 
			 * String para8 = "Dated :"+ LocalDate.now();
			 * 
			 * 
			 * String para9 = "For IANS INDIA PRIVATE LIMITED";
			 * 
			 * String para10 = "TERMS OF PAYMENTS"; String para11 =
			 * "Bills are payable on presentation"; String para12 =
			 * "Payments should be made in favour of IANS INDIA PRIVATE LIMITED";
			 * 
			 * 
			 * String para13 =
			 * "NOTE: SUPPLY MEANT FOR EXPORT UNDER LETTER OF UNDERTAKING WITHOUT PAYMENT OF INTEGRATED TAX."
			 * ;
			 * 
			 * String para14 =
			 * "* This is a computer generated invoice and therefore does not require a signature."
			 * ;
			 * 
			 * float [] pointColumnWidths1 = {250f, 645f}; Table table1 = new
			 * Table(pointColumnWidths1);
			 * 
			 * float [] pointColumnWidths2 = {482f, 45f}; Table table2 = new
			 * Table(pointColumnWidths2);
			 * 
			 * float [] pointColumnWidths3 = {40f, 345f, 100f}; Table table3 = new
			 * Table(pointColumnWidths3);
			 * 
			 * 
			 * 
			 * Cell headerColumn1 = new Cell(); headerColumn1.add("S. NO.");
			 * table3.addCell("S. NO.");
			 * 
			 * Cell headerColumn2 = new Cell(); headerColumn2.add("DESCRIPTION");
			 * table3.addCell("DESCRIPTION");
			 * 
			 * Cell headerColumn3 = new Cell(); headerColumn3.add("Amount");
			 * table3.addCell("Amount");
			 * 
			 * 
			 * 
			 * Cell column1 = new Cell(); column1.add("S. NO."); table3.addCell("1");
			 * 
			 * Cell column2 = new Cell(); column2.add("DESCRIPTION");
			 * table3.addCell(generateInvoiceDTO.getServiceDescription()).setFontSize(10);
			 * 
			 * 
			 * Cell column3 = new Cell(); column3.add("Amount");
			 * table3.addCell(String.valueOf(generateInvoiceDTO.getTotalAmount()));
			 * 
			 * 
			 * Cell column4 = new Cell(); column4.add("S. NO."); table3.addCell("2");
			 * 
			 * Cell column5 = new Cell();
			 * column5.add("TAXABLE VALUE \nCGST @ 9% \nSGST @ 9% \nIGST @ 18%");
			 * table3.addCell("TAXABLE VALUE \nCGST@9% \nSGST@9% \nIGST@18%").setFontSize(10
			 * );
			 * 
			 * 
			 * Cell column10 = new Cell(); column10.add("Amount");
			 * table3.addCell(String.valueOf(generateInvoiceDTO.getTotalCGSTAmount()+
			 * generateInvoiceDTO.getTotalIGSTAmount()+generateInvoiceDTO.getTotalSGSTAmount
			 * ()));
			 * 
			 * Float totalInvoiceAmount =
			 * generateInvoiceDTO.getTotalAmount()+generateInvoiceDTO.getTotalCGSTAmount()+
			 * generateInvoiceDTO.getTotalIGSTAmount()+generateInvoiceDTO.getTotalSGSTAmount
			 * ();
			 * 
			 * Cell column11 = new Cell(); column11.add("Amt in words");
			 * table3.addCell("Amt in words").setFontSize(6);
			 * 
			 * Cell column12 = new Cell(); column12.add("NumberInWords");
			 * table3.addCell("Rs "+NumberInWords.convertNumberToWords(Integer.valueOf(
			 * String.valueOf(totalInvoiceAmount)))).setFontSize(12);
			 * 
			 * 
			 * Cell column13 = new Cell(); column13.add("Amount");
			 * table3.addCell(String.valueOf(totalInvoiceAmount));
			 * 
			 * 
			 * 
			 * Cell cellnewtab1 = new Cell(); cellnewtab1.add("Bill To:");
			 * table1.addCell(para6);
			 * 
			 * Cell cellnewtab2 = new Cell(); cellnewtab2.add("Invoice No:");
			 * table2.addCell(para7+" "+para8);
			 * 
			 * 
			 * 
			 * // Creating an Area Break Paragraph paragraph1 = new Paragraph
			 * (para1).setFontSize(12); paragraph1.setFont(font);
			 * paragraph1.setMarginTop(0);
			 * 
			 * Paragraph paragraph15 = new Paragraph (para15).setFontSize(12);
			 * paragraph15.setFont(font); paragraph15.setMarginTop(0);
			 * 
			 * Paragraph paragraph2 = new Paragraph (para2).setFontSize(15);;
			 * paragraph2.setFont(font); paragraph2.setTextAlignment(TextAlignment.CENTER);
			 * 
			 * Paragraph paragraph3 = new Paragraph (para3).setFontSize(8);
			 * paragraph3.setTextAlignment(TextAlignment.CENTER); paragraph2.setFont(font);
			 * 
			 * 
			 * Paragraph paragraph4 = new Paragraph (para4).setFontSize(8);
			 * paragraph4.setTextAlignment(TextAlignment.CENTER);
			 * 
			 * Paragraph paragraph5 = new Paragraph (para5).setFontSize(8);
			 * paragraph5.setTextAlignment(TextAlignment.CENTER);
			 * 
			 * Paragraph paragraph6 = new Paragraph (para9).setFontSize(8);
			 * paragraph6.setTextAlignment(TextAlignment.RIGHT);
			 * 
			 * 
			 * Paragraph paragraph7 = new Paragraph (para10).setFont(font).setFontSize(8);
			 * paragraph7.setTextAlignment(TextAlignment.LEFT);
			 * 
			 * 
			 * Paragraph paragraph8 = new Paragraph (para11).setFontSize(8);
			 * paragraph8.setTextAlignment(TextAlignment.LEFT);
			 * 
			 * 
			 * Paragraph paragraph9 = new Paragraph (para12).setFontSize(8);
			 * paragraph9.setTextAlignment(TextAlignment.LEFT);
			 * 
			 * Paragraph paragraph10= new Paragraph (para13).setFont(font).setFontSize(8);
			 * paragraph9.setTextAlignment(TextAlignment.LEFT);
			 * 
			 * 
			 * Paragraph paragraph11 = new Paragraph (para14).setFontSize(8);
			 * paragraph9.setTextAlignment(TextAlignment.LEFT);
			 * 
			 * 
			 * document.add(paragraph1); document.add(paragraph15);
			 * document.add(paragraph2); document.add(paragraph3); document.add(paragraph4);
			 * document.add(paragraph5);
			 * 
			 * 
			 * 
			 * document.add(table2); document.add(table1); document.add(table3);
			 * document.add(paragraph6);
			 * 
			 * document.add(paragraph7); document.add(paragraph8); document.add(paragraph9);
			 * document.add(paragraph10); document.add(paragraph11);
			 * 
			 * document.close();
			 * 
			 * return fileout; }
			 */
	   
	   private ByteArrayOutputStream generateInvoiceReceipt(GenerateInvoiceDTO generateInvoiceDTO) throws Exception
	   {
		    PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD); 
			
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter writer = new PdfWriter(baos);
			  
		    PdfDocument pdfDoc = new PdfDocument(writer); 
			
			Document document = new Document(pdfDoc); 
			
			String para1= "GSTIN No.- 09AAACI2341F1ZY                    TAX INVOICE                    PAN NO. AAACI2341F"; 
			
			String para2 = "IANS INDIA PRIVATE LIMITED";
			
			String para15 = "UP CODE -09                                                     CIN-U74899DLI994PTC063783";
			
			String para3 = "A-6,Ground Floor,Sector - 16,Noida – 201301. U.P. INDIA";
			
			String para4 = "Tel. : +91-120-4822400. Fax : +91-120-4822403/04";
			
			String para5 = "Email : accounts@ians.in";
			
			String para6 = generateInvoiceDTO.getCompanyName()+"\n"
					+ generateInvoiceDTO.getHeadOfficeAddress()+"\n"
					+ generateInvoiceDTO.getGstNo();
			
			String para7 = generateInvoiceDTO.getInvoiceNo();

			String para8 = "Dated :"+ LocalDate.now();
			
			
			String para9 = "For IANS INDIA PRIVATE LIMITED";
			
			String para10 = "TERMS OF PAYMENTS";
			String para11 = "1. Bills are payable on presentation";
			String para12 = "2. Payments should be made in favour of IANS INDIA PRIVATE LIMITED";
			String para16 = "3. Reverse Charge Mechanism (RCM) is applicable on this Invoice- No";	
			
			//String para13 = "NOTE: SUPPLY MEANT FOR EXPORT UNDER LETTER OF UNDERTAKING WITHOUT PAYMENT OF INTEGRATED TAX.";
			
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
		      table3.addCell("D E S C R I P T I O N");		
		      
		      Cell headerColumn3 = new Cell();       
		      headerColumn3.add("Amount"); 
		      table3.addCell("Amount Rs.");		
			 
			 
		      
		      Cell column1 = new Cell();       
		      column1.add("S. NO."); 
			  table3.addCell("1");		
		      	 		 			  
		      Cell column2 = new Cell();       
		      column2.add("DESCRIPTION"); 
		     // table3.addCell(generateInvoiceDTO.getServiceDescription()).setFontSize(10);		
		      table3.addCell("SUBSCRIPTION CHARGES FOR "+generateInvoiceDTO.getServiceDescription()+" FOR THE PERIOD OF "+generateInvoiceDTO.getSubscriptionStartDate()+" TO "+generateInvoiceDTO.getSubscriptionDate()+"\n\n\n\n\n"+generateInvoiceDTO.getSacCode()).setFontSize(10);	
		 	
		      Cell column3 = new Cell();       
		      column3.add("Amount"); 
			  table3.addCell(String.valueOf(generateInvoiceDTO.getTotalAmount()));	
		      
		      
			  Cell column4 = new Cell();       
			  column4.add("S. NO."); 
			  table3.addCell("2");		
		      
		      Cell column5 = new Cell();       
		      column5.add("CGST @ 9% \nSGST @ 9% \nIGST @ 18%"); 
		      table3.addCell("CGST@9% \nSGST@9% \nIGST@18%").setFontSize(10);	
		      
		    
		      Cell column10 = new Cell();       
		      column10.add("Amount"); 
		      
		      Float totalGSTAmount = 0.0f;
		      
		      if(generateInvoiceDTO.getTotalCGSTAmount()!=null && generateInvoiceDTO.getTotalIGSTAmount()==null && generateInvoiceDTO.getTotalSGSTAmount()==null)
		      {
		    	  totalGSTAmount = generateInvoiceDTO.getTotalCGSTAmount();
		      }
		      
		      else if(generateInvoiceDTO.getTotalCGSTAmount()!=null && generateInvoiceDTO.getTotalIGSTAmount()!=null && generateInvoiceDTO.getTotalSGSTAmount()==null)
		      {
		    	  totalGSTAmount = generateInvoiceDTO.getTotalCGSTAmount()+ generateInvoiceDTO.getTotalIGSTAmount();
		      }
		      
		      else if(generateInvoiceDTO.getTotalCGSTAmount()!=null && generateInvoiceDTO.getTotalIGSTAmount()!=null && generateInvoiceDTO.getTotalSGSTAmount()!=null) {
		    	  
		    	  totalGSTAmount = generateInvoiceDTO.getTotalCGSTAmount()+ generateInvoiceDTO.getTotalIGSTAmount()+generateInvoiceDTO.getTotalSGSTAmount();
		      }
		      
		      else if(generateInvoiceDTO.getTotalCGSTAmount()==null && generateInvoiceDTO.getTotalIGSTAmount()!=null && generateInvoiceDTO.getTotalSGSTAmount()==null)
		      {
		    	  totalGSTAmount = generateInvoiceDTO.getTotalIGSTAmount();
		      }
		      
			  table3.addCell(String.valueOf(totalGSTAmount));	
			  
			  Float totalInvoiceAmount = generateInvoiceDTO.getTotalAmount()+totalGSTAmount;
			  
			  Cell column11 = new Cell();       
			  column11.add("Amt in words"); 
			  table3.addCell("Amt in words").setFontSize(6);		
		      
		      Cell column12 = new Cell();       
		      column12.add("NumberInWords"); 
		      table3.addCell("Rs "+NumberInWords.convertNumberToWords(Math.round(totalInvoiceAmount))+" Only").setFontSize(12);	
		      
		    
		      Cell column13 = new Cell();       
		      column13.add("Amount"); 
			  table3.addCell(String.valueOf(totalInvoiceAmount));	
			  
		      
		      
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
			
			Paragraph paragraph15 = new Paragraph (para15).setFontSize(12);
			paragraph15.setFont(font);
			paragraph15.setMarginTop(0);
			
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
			
			Paragraph paragraph16 = new Paragraph (para16).setFontSize(8); 
			paragraph16.setTextAlignment(TextAlignment.LEFT);
			
//			Paragraph paragraph10= new Paragraph (para13).setFont(font).setFontSize(8); 
//			paragraph9.setTextAlignment(TextAlignment.LEFT);
//			
			
			Paragraph paragraph11 = new Paragraph (para14).setFontSize(8); 
			paragraph9.setTextAlignment(TextAlignment.LEFT);
			
		
			document.add(paragraph1); 
			document.add(paragraph15); 
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
			document.add(paragraph16); 
			//document.add(paragraph10); 
			document.add(paragraph11); 
			
			document.close();
		   
			return baos;
	   }
	   
	   
	   private ByteArrayOutputStream generateTempPDFFIle() throws Exception
	   {
		   PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD); 
			
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter writer = new PdfWriter(baos);
			  
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
		   
			return baos;
	   }
	
}
