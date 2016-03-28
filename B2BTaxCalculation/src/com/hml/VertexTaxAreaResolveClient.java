package com.hml;

import hml.com.AddressType;
import hml.com.OrderTaxCalculationResponse;

import java.lang.invoke.MethodHandles.Lookup;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import vertexinc.o_series.tps._7._0.LoginType;
import vertexinc.o_series.tps._7._0.LookupResultType;
import vertexinc.o_series.tps._7._0.PostalAddressType;
import vertexinc.o_series.tps._7._0.TaxAreaLookupType;
import vertexinc.o_series.tps._7._0.TaxAreaRequestType;
import vertexinc.o_series.tps._7._0.TaxAreaResponseType;
import vertexinc.o_series.tps._7._0.TaxAreaResultType;
import vertexinc.o_series.tps._7._0.VertexEnvelope;
import vertexinc.o_series.tps._7._0.TaxAreaResultType.AddressCleansingResultMessage;

import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.vertexinc.oseries.services.lookuptaxareas70.LookupTaxAreasWS70;
import com.vertexinc.oseries.services.lookuptaxareas70.LookupTaxAreasWSService70;

public class VertexTaxAreaResolveClient {
	
	 
	static Logger log = Logger.getLogger(VertexTaxAreaResolveClient.class.getName());
	
	
	
			
		// Request Building
		public VertexEnvelope createRequest(String address1,
		String address2,
		String city,
		String state,
		String subdivision,
		String zip,
		String country,
		String userName,String passWord) throws DatatypeConfigurationException {
			
			String MethodName="createRequest()";
			
			 log.info(MethodName+"   : Begin");
			VertexEnvelope part= new VertexEnvelope();
			  
			   LoginType login=new LoginType();
			   TaxAreaRequestType taxAreaReq=new TaxAreaRequestType();
			   TaxAreaLookupType  taxAreaLookup=new TaxAreaLookupType(); 
			  
			   PostalAddressType postalAddress=new PostalAddressType();	
			   GregorianCalendar gregorianCalendar = new GregorianCalendar();
			   DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
			   XMLGregorianCalendar now =datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
			  
			
			log.info("userName==>"+userName);
		//	log.info("passWord==>"+passWord);
		    
			login.setUserName(userName);
			login.setPassword(passWord);
			
			
			postalAddress.setStreetAddress1(address1);
			postalAddress.setStreetAddress2(address2);
			postalAddress.setCity(city);
			postalAddress.setMainDivision(state);
			postalAddress.setPostalCode(zip);
			postalAddress.setSubDivision(subdivision);
			postalAddress.setCountry("US");
			taxAreaLookup.setAsOfDate(now);
			taxAreaLookup.setPostalAddress(postalAddress);
			
			taxAreaReq.setTaxAreaLookup(taxAreaLookup);
			
			part.setLogin(login);
			part.setTaxAreaRequest(taxAreaReq);
			log.info("Tax Area lookUp Done===>  "+taxAreaReq);
			log.info(MethodName+"   : End");
			return part;
			
		}
		
		public Integer handleRequest(String address1,
				String address2,
				String city,
				String state,
				String subdivision,
				String zip,
				String country,
				XMLGregorianCalendar reqdocumentDate,
				String userName,String passWord,
				OrderTaxCalculationResponse response,
				boolean isAdmin) throws RemoteException {
			String MethodName="handleRequest()";
			
			 log.info(MethodName+"   : Begin");
			Integer TaxAreaId= new Integer(-1);
			//String responseMsg= "";
			AddressType addressType= new AddressType();
			
			vertexinc.o_series.tps._7._0.VertexEnvelope _lookupTaxAreas70_inDoc = null;
			if(((null!=zip && (!"".equalsIgnoreCase(zip)))||(null!=state&&(!"".equalsIgnoreCase(state)))
					||(null!=city&&(!"".equalsIgnoreCase(city)))||(null!=address1&&(!"".equalsIgnoreCase(address1))))){
				 
			
			try {
				
				_lookupTaxAreas70_inDoc = createRequest(address1,address2,city,state,subdivision,zip,country,userName,passWord);
				
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		try{
			LookupTaxAreasWSService70 ss = new LookupTaxAreasWSService70();
			LookupTaxAreasWS70 port = ss.getLookupTaxAreas70();
			addressType.setStreetAddress1(address1);
			addressType.setStreetAddress2(address2);
			addressType.setCity(city);
			addressType.setMainDivision(state);
			addressType.setCountry(country);
			addressType.setSubDivision(subdivision);
			addressType.setPostalCode(zip);
		/*	BindingProvider bindingProvider = (BindingProvider)port;
			Map<String, Object> context = bindingProvider.getRequestContext();
			context.put(BindingProviderProperties.CONNECT_TIMEOUT,2);
			context.put(BindingProviderProperties.REQUEST_TIMEOUT,2);*/
			log.info("lookupTaxAreas70 ====>Start");
			long startTime=System.currentTimeMillis();
	        VertexEnvelope _lookupTaxAreas70__return = port.lookupTaxAreas70(_lookupTaxAreas70_inDoc);
	        long endTime=System.currentTimeMillis();
	        log.info("lookupTaxAreas70 ====>End and time taken for this webservice call in MiliSec    :"+(endTime-startTime));
	        TaxAreaId=processResponse(_lookupTaxAreas70__return,response,isAdmin);
	           
	        
	        
	       
			}catch(Exception e){
				String responseMsg= "FAILED :"+ e.getMessage();
				
				addressType.setAddressResponse(responseMsg);
				  if(isAdmin){
					  response.getCustomerType().setAdministrativeAddress(addressType);
				  }else{
					  response.getCustomerType().setAddress(addressType); 
				  }
				
				
				response.setResponseMsg(responseMsg);
				log.error(responseMsg);
			}
		}else{
			//response.setHeader("TaxAreaErrorMsg", "Mandatory fields missing in address lookUp");
		}
		log.info(MethodName+"   : End");	
		return TaxAreaId;
	        
		}
		
		private Integer processResponse(VertexEnvelope vResponse,OrderTaxCalculationResponse ordTxResponse,boolean isAdmin){
			  TaxAreaResponseType ta=vResponse.getTaxAreaResponse();
	    	  TaxAreaResultType tr= null;
	    	  TaxAreaResultType areaResultAccepted= new TaxAreaResultType();
	    	  AddressType addressAccepted= new AddressType();
	    	  String MethodName="processResponse()";
	    	  log.info(MethodName+"   : Begin");
	    	   List lst=ta.getTaxAreaResult();
	    	   for(int i=0; i<lst.size(); i++){
	    	   tr= (TaxAreaResultType)lst.get(i);
	    	   
	    	   if(i!=0){
	    		       if(Integer.parseInt(tr.getConfidenceIndicator().toString())>Integer.parseInt(areaResultAccepted.getConfidenceIndicator().toString())){
	    		    	   areaResultAccepted.setConfidenceIndicator(tr.getConfidenceIndicator());
	    		    	   areaResultAccepted.setTaxAreaId(tr.getTaxAreaId());
	    		    	 
	    		    	 for(int j=0;tr.getPostalAddress()!=null && j<tr.getPostalAddress().size() ;j++){
	    		    		 
	    		    		 if(null!=tr.getPostalAddress().get(j)){
	    		    		 
	    		    		 addressAccepted.setStreetAddress1(((PostalAddressType)tr.getPostalAddress().get(j)).getStreetAddress1());
	    		    		 addressAccepted.setStreetAddress2(((PostalAddressType)tr.getPostalAddress().get(j)).getStreetAddress2());
	    		    		 addressAccepted.setPostalCode(((PostalAddressType)tr.getPostalAddress().get(j)).getPostalCode());
	    		    		 addressAccepted.setCity(((PostalAddressType)tr.getPostalAddress().get(j)).getCity());
	    		    		 addressAccepted.setMainDivision(((PostalAddressType)tr.getPostalAddress().get(j)).getMainDivision());
	    		    		 addressAccepted.setSubDivision(((PostalAddressType)tr.getPostalAddress().get(j)).getSubDivision());
	    		    		 addressAccepted.setCountry(((PostalAddressType)tr.getPostalAddress().get(j)).getCountry());    		    		 
	    		    		 
	    		    		 }
	    		    		 
	    		    	 }
	    		    	  
	    		    	   
	    		       }
			    	   }else{
					    	   areaResultAccepted.setConfidenceIndicator(tr.getConfidenceIndicator());
					    	   areaResultAccepted.setTaxAreaId(tr.getTaxAreaId());
					    	   
					    		 for(int k=0;tr.getPostalAddress()!=null && k<tr.getPostalAddress().size() ;k++){
			    		    		 
			    		    		 if(null!=tr.getPostalAddress().get(k)){
			    		    		 
			    		    		 addressAccepted.setStreetAddress1(((PostalAddressType)tr.getPostalAddress().get(k)).getStreetAddress1());
			    		    		 addressAccepted.setStreetAddress2(((PostalAddressType)tr.getPostalAddress().get(k)).getStreetAddress2());
			    		    		 addressAccepted.setPostalCode(((PostalAddressType)tr.getPostalAddress().get(k)).getPostalCode());
			    		    		 addressAccepted.setCity(((PostalAddressType)tr.getPostalAddress().get(k)).getCity());
			    		    		 addressAccepted.setMainDivision(((PostalAddressType)tr.getPostalAddress().get(k)).getMainDivision());
			    		    		 addressAccepted.setSubDivision(((PostalAddressType)tr.getPostalAddress().get(k)).getSubDivision());
			    		    		 addressAccepted.setCountry(((PostalAddressType)tr.getPostalAddress().get(k)).getCountry());	
			    		    		 if(null!=tr.getStatus().get(0) && null!=tr.getStatus().get(0).getLookupResult()){
			    		    		 addressAccepted.setAddressResponse(((LookupResultType)tr.getStatus().get(0).getLookupResult()).toString());
			    		    		 }else{
			    		    			 addressAccepted.setAddressResponse("No Response Code Found"); 
			    		    		 }
			    		    		 addressAccepted.setTaxAreaId(areaResultAccepted.getTaxAreaId());
			    			    	 addressAccepted.setConfidenceIndicator(areaResultAccepted.getConfidenceIndicator());
			    			    	 
			    		    		 }
			    		    		 
			    		    	 }
					    		 log.info("LookupResult===>"+tr.getStatus().get(0).getLookupResult());	 
			    	   }
	    	   
	    	 log.info("Confidence Indicator  :"+areaResultAccepted.getConfidenceIndicator()+ "taxAreaId :"+tr.getTaxAreaId()); 
	    	   }
	    	  if(isAdmin){
	    		  
	    		     ordTxResponse.getCustomerType().setAdministrativeAddress(addressAccepted);
	    	 //  ordTxResponse.setConfidenceIndicator(Integer.parseInt(areaResultAccepted.getConfidenceIndicator().toString()));
	    	  }else{
	    	 
	    	  ordTxResponse.getCustomerType().setAddress(addressAccepted);
	    	  }
	    	  // httpResponse.setHeader("ConfidanceIndicator", areaResultAccepted.getConfidenceIndicator().toString());
	    	   log.info(" Highest Confidence Indicator  :  "+areaResultAccepted.getConfidenceIndicator()+ "taxAreaId :  "+areaResultAccepted.getTaxAreaId());
	    	   log.info(MethodName+"   : End");
	    	   return areaResultAccepted.getTaxAreaId();
	}
		
	

}
