package com.hml;

import hml.com.AddressType;
import hml.com.CustomerType;
import hml.com.LineItemType;
import hml.com.OrderTaxCalculationResponse;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;


public class CalculateTaxMiddleLayer {
	static Logger log = Logger.getLogger(CalculateTaxMiddleLayer.class.getName());
	
	private VertexTaxAreaResolveClient clientTaxArea1 = new VertexTaxAreaResolveClient();
	private VertexTaxAreaResolveClient clientTaxArea2 = new VertexTaxAreaResolveClient();
	private VertexTaxCalculationResolveClient calculationClient = new VertexTaxCalculationResolveClient();
	  String adminaddress1="";
	  String adminaddress2="";
	  String admincity="";
	  String adminzip="";
	  String adminstate="";
	  String adminsubdivision="";
	  String adminmaindivision="";
	  String admincountry="";
	  boolean isAdmin=false;
	
	public Integer connector(String address1,String address2,String city,
			String state,String subdivision,String zip,String country,String customervalue,String customerCode,String company,String userName,String passWord,AddressType administrativeAddressReq,List<LineItemType> lineItemReq,XMLGregorianCalendar reqdocumentDate,OrderTaxCalculationResponse response) {
		String MethodName="connector()";
		log.info(MethodName+"   : Begin");
		BigDecimal taxAmount=new BigDecimal("9999999");		
		Integer taxAreaId=new Integer(-1);
		try {
			taxAreaId = clientTaxArea1.handleRequest(address1,address2,city,state,subdivision,zip,country,reqdocumentDate,userName,passWord,response,isAdmin);
		} catch (RemoteException e1) {
			response.setResponseMsg("FAILED : TIMEOUT EXCEPTION WHILE TAXAREAID LOOKUP FOR ADDRESS");
		}
		log.info("taxAreaId after lookup in CalculateTaxMiddleLayer==>"+taxAreaId);
		
		      if(null!=administrativeAddressReq.getStreetAddress1() && !"?".equalsIgnoreCase(administrativeAddressReq.getStreetAddress1()))
			       adminaddress1=administrativeAddressReq.getStreetAddress1();
			  log.info("adminaddress1==========>"+adminaddress1);
			  if(null!=administrativeAddressReq.getStreetAddress2() && !"?".equalsIgnoreCase(administrativeAddressReq.getStreetAddress2())) 
				  adminaddress2=administrativeAddressReq.getStreetAddress2();
			  log.info("adminaddress2==========>"+adminaddress2);
			  if(null!=administrativeAddressReq.getCity() && !"?".equalsIgnoreCase(administrativeAddressReq.getCity()))
				  admincity=administrativeAddressReq.getCity().toUpperCase();
			  log.info("admincity==========>"+admincity);
			  if(null!=administrativeAddressReq.getCountry() && !"?".equalsIgnoreCase(administrativeAddressReq.getCountry()))
				  admincountry=administrativeAddressReq.getCountry();
			  log.info("admincountry==========>"+admincountry);
			  if(null!=administrativeAddressReq.getSubDivision() && !"?".equalsIgnoreCase(administrativeAddressReq.getSubDivision()))
				  adminsubdivision=administrativeAddressReq.getSubDivision();
			  log.info("adminsubdivision==========>"+adminsubdivision);
			  if(null!=administrativeAddressReq.getMainDivision() && !"?".equalsIgnoreCase(administrativeAddressReq.getMainDivision()))
				  adminstate=administrativeAddressReq.getMainDivision();
			  log.info("adminstate==========>"+adminstate);
			  if(null!=administrativeAddressReq.getPostalCode() && !"?".equalsIgnoreCase(administrativeAddressReq.getPostalCode()))
				  adminzip=administrativeAddressReq.getPostalCode();
			  log.info("adminzip==========>"+adminzip);
			  isAdmin=true;
			  Integer administrativeTaxAreaId=new Integer(-1);
			try {
				administrativeTaxAreaId = clientTaxArea2.handleRequest(adminaddress1,adminaddress2,admincity,adminstate,adminsubdivision,adminzip,admincountry,reqdocumentDate,userName,passWord,response,isAdmin);
			} catch (RemoteException e) {
				response.setResponseMsg("FAILED: TIMEOUT EXCEPTION WHILE TAXAREA LOOKUP FOR ADMINISTRATIVE ADDRESS");
			}
		log.info("administrativeTaxAreaId after lookup in CalculateTaxMiddleLayer==>"+administrativeTaxAreaId);
		
		if(-1!=taxAreaId && -1!=administrativeTaxAreaId){
			if(null!=lineItemReq ){
				
		taxAmount = calculationClient.handleRequest(address1,address2,city,state,subdivision,zip,country,customervalue,customerCode,company,userName,passWord,lineItemReq,reqdocumentDate,response,taxAreaId,adminaddress1,adminaddress2,admincity,adminstate,adminsubdivision,adminzip,admincountry,administrativeTaxAreaId);
			}else{
				
				response.setResponseMsg("SUCCESS: With Empty LineItem");
			}
		}else{
			if(-1==taxAreaId){
				if(-1!=administrativeTaxAreaId){
					if(null==lineItemReq ){
					response.setResponseMsg("SUCCESS: With Empty LineItem and Wrong or Missing Address");
					}else{
						response.setResponseMsg("FAILED: Wrong or Missing Address");	
					}
				}else{
					if(null==lineItemReq ){
						response.setResponseMsg("Failed: With Empty or Bad Request");
						}else{
							response.setResponseMsg("FAILED: Wrong or Missing Address and Administrative Address");	
						}
					
				}
			}else if(-1==administrativeTaxAreaId){
				if(-1!=taxAreaId){
					if(null==lineItemReq ){
					response.setResponseMsg("SUCCESS: With Empty LineItem and Wrong or Missing Administrative Address");
					}else{
						response.setResponseMsg("FAILED: Wrong or Missing Administrative Address");	
					}
				}else{
					if(null==lineItemReq ){
						response.setResponseMsg("Failed: With Empty or Bad Request");
						}else{
							response.setResponseMsg("FAILED: Wrong or Missing Address and Administrative Address");	
						}
					
				}
			}
		}
		log.info(MethodName+"   : End");
		return administrativeTaxAreaId;
	}
	
}
