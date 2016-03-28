package com.hml;

import hml.com.LineItemType;
import hml.com.OrderTaxCalculationResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import vertexinc.o_series.tps._7._0.CurrencyType;
import vertexinc.o_series.tps._7._0.CustomerCodeType;
import vertexinc.o_series.tps._7._0.CustomerType;
import vertexinc.o_series.tps._7._0.LineItemQSIType;
import vertexinc.o_series.tps._7._0.LineItemQSOType;
import vertexinc.o_series.tps._7._0.LocationType;
import vertexinc.o_series.tps._7._0.LoginType;
import vertexinc.o_series.tps._7._0.MeasureType;
import vertexinc.o_series.tps._7._0.Product;
import vertexinc.o_series.tps._7._0.QuotationRequestType;
import vertexinc.o_series.tps._7._0.QuotationResponseType;
import vertexinc.o_series.tps._7._0.SaleTransactionType;
import vertexinc.o_series.tps._7._0.SellerType;
import vertexinc.o_series.tps._7._0.VertexEnvelope;

import com.vertexinc.oseries.services.calculatetax70.CalculateTaxWS70;
import com.vertexinc.oseries.services.calculatetax70.CalculateTaxWSService70;

public class VertexTaxCalculationResolveClient {
	
	
	static Logger log = Logger.getLogger(VertexTaxCalculationResolveClient.class.getName());
	
	 CalculateTaxWSService70 ss = new CalculateTaxWSService70();
		
	 CalculateTaxWS70 port = ss.getCalculateTax70();
	 
	 ClassLoader classLoader = VertexTaxCalculationResolveClient.class.getClassLoader();
	

		
		
	
	
		
		private VertexEnvelope createTaxCalculationRequest(String address1,
				String address2,
				String city,
				String state,
				String zip,
				String country,
				int taxAreaId,
				String customervalue,
				String customerCode,
				String company,
				String userName,String passWord,
				List<LineItemType> lineItemReq, 
				XMLGregorianCalendar reqdocumentDate,
				OrderTaxCalculationResponse response,
				String adminaddress1,String adminaddress2,String admincity,String adminstate,String adminsubdivision,String adminzip,String admincountry,int administrativeTaxAreaId) throws DatatypeConfigurationException {
			String MethodName="createTaxCalculationRequest()";
			
			 log.info(MethodName+"   : Begin");
			
		       VertexEnvelope taxPart= new VertexEnvelope();
			   LoginType login=new LoginType();
			 
			  
			   QuotationRequestType quotationRequestType= new QuotationRequestType();
			   CurrencyType currencyType= new CurrencyType();
			   CustomerType customer= new CustomerType();
			   SellerType seller = new SellerType();
			   LocationType locationType=new LocationType();
			   LocationType SellerLocationType=new LocationType();
			   LocationType adminLocationType=new LocationType();
			   CustomerCodeType customerCodeType=new CustomerCodeType();
			   //LineItemQSIType lineItem=new LineItemQSIType();
			  
			   MeasureType measureType= new MeasureType();
			 			   
			   GregorianCalendar gregorianCalendar = new GregorianCalendar();
			   DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
			   XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
			   
			   String sellerTaxAreaId="";
			   String sellerAddress1="";
			   String sellerCity="";
			   String sellerZip="";
			   String sellerState="";
		    	Properties prop = new Properties();
		    	try {
					prop.load(classLoader.getResourceAsStream("Constant.properties"));
					sellerTaxAreaId=prop.getProperty("HM_TAXAREA_ID", "");
					sellerAddress1=prop.getProperty("HM_OFFICE_ADDRESS1", "");
					sellerCity=prop.getProperty("HM_OFFICE_CITY", "");
					sellerZip=prop.getProperty("HM_OFFICE_ZIP", "");
					sellerState=prop.getProperty("HM_OFFICE_STATE", "");
					log.info("sellerTaxAreaId ====>"+sellerTaxAreaId);
					log.info("sellerAddress1 ====>"+sellerAddress1);
					log.info("sellerCity ====>"+sellerCity);
					log.info("sellerZip ====>"+sellerZip);
					log.info("sellerState ====>"+sellerState);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error("Error while loading Properties File");
				}
			
			try{
		    
			
				
				
			    
				login.setUserName(userName);
				login.setPassword(passWord);
			
			currencyType.setIsoCurrencyName("USD");
			currencyType.setIsoCurrencyCodeAlpha("USD");
			
			//Setting Up destination Location
			locationType.setTaxAreaId(Integer.valueOf(taxAreaId));
			locationType.setStreetAddress1(address1);
			locationType.setStreetAddress2(address2);
			locationType.setCity(city);
			locationType.setMainDivision(state);
			locationType.setPostalCode(zip);
			locationType.setCountry("US");
			customer.setDestination(locationType);
			
			//Setting Up Administrative destination Location
			adminLocationType.setTaxAreaId(Integer.valueOf(administrativeTaxAreaId));
			adminLocationType.setStreetAddress1(adminaddress1);
			adminLocationType.setStreetAddress2(adminaddress2);
			adminLocationType.setCity(admincity);
			adminLocationType.setMainDivision(adminstate);
			adminLocationType.setPostalCode(adminzip);
			locationType.setCountry("US");			
			customer.setAdministrativeDestination(adminLocationType);
			
			customerCodeType.setValue(customervalue);
			customerCodeType.setClassCode(customerCode);
			customer.setCustomerCode(customerCodeType);
			
			//Setting Up HermanMiller office Address Details Details
			SellerLocationType.setTaxAreaId(Integer.parseInt(sellerTaxAreaId));			
			SellerLocationType.setStreetAddress1(sellerAddress1);
			SellerLocationType.setCity(sellerCity);			
			SellerLocationType.setCountry("US");
			SellerLocationType.setMainDivision(sellerState);
			SellerLocationType.setPostalCode(sellerZip);
			seller.setAdministrativeOrigin(SellerLocationType);
			seller.setPhysicalOrigin(SellerLocationType);
			seller.setCompany(company);
			
			quotationRequestType.setSeller(seller);
			quotationRequestType.setCustomer(customer);	
			quotationRequestType.setCurrency(currencyType);
			quotationRequestType.setTransactionType(SaleTransactionType.SALE);
			if(null!=reqdocumentDate && !"".equalsIgnoreCase(reqdocumentDate.toString()) && !"?".equalsIgnoreCase(reqdocumentDate.toString()))
			{
				quotationRequestType.setDocumentDate(reqdocumentDate);	
			}else{
			quotationRequestType.setDocumentDate(now);
			}
			
			// adding up LineItem
			 for(LineItemType lineType : lineItemReq){
			
			LineItemQSIType lineItem_ =new LineItemQSIType();
			Product prod_=new Product();
			lineItem_.setTaxDate(lineType.getTaxDate());	
			log.info("TaxDate====>"+lineType.getTaxDate());
			measureType.setValue(lineType.getQuantity());
			log.info("Quantity====>"+lineType.getQuantity());
			lineItem_.setQuantity(measureType);
			
			try{
			
			lineItem_.setLineItemNumber(lineType.getLineItemNumber());
			log.info("LineItemNumber====>"+lineType.getLineItemNumber());
			lineItem_.setTaxDate(lineType.getTaxDate());
			prod_.setProductClass(lineType.getProductClass());
			log.info("ProductClass====>"+lineType.getProductClass());
			prod_.setValue(lineType.getProduct());
			log.info("ProductValue====>"+lineType.getProduct());
			}catch(Exception e){
				//Since Part Number and LineItem Number is not mandatory 
			}
			lineItem_.setProduct(prod_);
			lineItem_.setExtendedPrice(lineType.getExtendedPrice());
			
			quotationRequestType.getLineItem().add(lineItem_);
			}
			taxPart.setLogin(login);
			taxPart.setQuotationRequest(quotationRequestType);
			
			
			}catch(Exception e){
				String errorMsg="While Creating Request for Tax Calculation Service Error :"+e.getMessage();
				
				response.setResponseMsg(errorMsg);
				log.error(errorMsg);
			}
			
			 log.info(MethodName+"   : End");
			return taxPart;
			
		}
		
		private BigDecimal fireRequest(String address1,
				String address2,
				String city,
				String state,
				String zip,
				String country,
				int taxAreaId,
				String customervalue,
				String customerCode,
				String company,
				String userName,String passWord,
				List<LineItemType> lineItemReq, 
				XMLGregorianCalendar reqdocumentDate,
				OrderTaxCalculationResponse response,
				String adminaddress1,String adminaddress2,String admincity,String adminstate,String adminsubdivision,String adminzip,String admincountry,int administrativeTaxAreaId){
			
			String MethodName="fireRequest()";
			
			 log.info(MethodName+"   : Begin");
			
			vertexinc.o_series.tps._7._0.VertexEnvelope _CalculateTax70_inDoc = null;
			VertexEnvelope _CalculateTax70__return=null;
			 
			try {
				_CalculateTax70_inDoc = createTaxCalculationRequest(address1,address2,city,state,zip,country,taxAreaId,customervalue,customerCode,company,userName,passWord,lineItemReq,reqdocumentDate,response,adminaddress1,adminaddress2,admincity,adminstate,adminsubdivision,adminzip,admincountry,administrativeTaxAreaId);
				long startTime=System.currentTimeMillis();
				log.info("calculateTax70 ====>Start");
				_CalculateTax70__return = port.calculateTax70(_CalculateTax70_inDoc);
				long endTime=System.currentTimeMillis();
				log.info("calculateTax70 ====>End and time taken for this webservice call in MiliSec   :"+(endTime-startTime));
				
			} catch (Exception e) {
				String errorMsg="FAILED:"+e.getMessage();
				response.setResponseMsg(errorMsg);
				log.error(errorMsg);
			}
	        
			 log.info(MethodName+"   : End");
	        return processTaxResponse(_CalculateTax70__return,lineItemReq,response);
			
			
		}
		
		public BigDecimal handleRequest(String address1,
				String address2,
				String city,
				String state,
				String subdivision,
				String zip,
				String country,
				String customervalue,
				String customerCode,
				String company,
				String userName,String passWord,
				List<LineItemType> lineItemReq,
				XMLGregorianCalendar reqdocumentDate,
				OrderTaxCalculationResponse response,int taxAreaId,
				String adminaddress1,String adminaddress2,String admincity,String adminstate,String adminsubdivision,String adminzip,String admincountry,int administrativeTaxAreaId) {
			String MethodName="handleRequest()";
			 log.info(MethodName+"   : Begin");
			String orderTotal;
			String customerNumber;
			BigDecimal taxAmount= new BigDecimal("999999");
		
		   
			
			
			
			try{
			
			taxAmount=fireRequest(address1,address2,city,state,zip,country,taxAreaId,customervalue,customerCode,company,userName,passWord,lineItemReq,reqdocumentDate,response,adminaddress1,adminaddress2,admincity,adminstate,adminsubdivision,adminzip,admincountry,administrativeTaxAreaId);
			}catch (Exception e){
				String errorMsg="While Creating Request for Tax Calculation Service Error Happened due to bad or missing parameter:"+e.getMessage();
				log.info(errorMsg);
			}
			 log.info(MethodName+"   : End");
			return taxAmount;
			
		}
		
	
		
		//Process request and get the desired TaxAreaId
		private BigDecimal processTaxResponse(VertexEnvelope response,List<LineItemType> lineItemReq, OrderTaxCalculationResponse ordTaxResponse){
			
			      String MethodName="processTaxResponse()";
			      log.info(MethodName+"   :Begin");
				  BigDecimal totalTax = BigDecimal.ZERO;
		          QuotationResponseType quotationRes=response.getQuotationResponse();
		          log.info("processTaxResponse===>"+"Start");
		          //orderItemsResponse= 
		    	  if(null!=quotationRes){
		    		 totalTax=quotationRes.getTotalTax();
		    		 if(null!=totalTax)
		    		 ordTaxResponse.setTotalTax(totalTax);
		    		 
		    		 List<LineItemQSOType>lineItemList=quotationRes.getLineItem();
		    		 
		    		// for(LineItemType lineType : lineItemReq){
		    			 for(int j=0; j<lineItemReq.size();j++){
		    		 for(int i=0; i<lineItemList.size();i++){
		    			 LineItemQSOType lineItem_=new LineItemQSOType();
		    			 Product prod_= new Product();
		    			 lineItem_=(LineItemQSOType)lineItemList.get(i);
		    			 prod_=lineItem_.getProduct();
		    			if(i==j){
		    				lineItemReq.get(j).setTotalTax((lineItem_.getTotalTax()));
		    			    log.info(" Line Item Tax Calculated via Vertex for LineItem:  "+lineItem_.getLineItemNumber()+"  Tax Amount ==>"+lineItem_.getTotalTax());
		    			}
		    				 
		    		 } 
		    			 
		    			 
		    		 }
		    		 
		    	  }
		    	   
		    	  log.info(" totalTax Calculated via Vertex :  "+totalTax);
		    	  log.info(MethodName+"   :End");
		    	   return totalTax;
		}
		
	

}
