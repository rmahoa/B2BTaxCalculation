package hml.com;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;

import com.hml.CalculateTaxMiddleLayer;
import com.hml.DataBaseDateFetch;

@WebService(endpointInterface="hml.com.CalculateTax",
portName="calculateTaxPort",serviceName="calculateTax")

public class CalculateTaxService implements CalculateTax {
	
	static Logger log = Logger.getLogger(CalculateTaxService.class.getName());
	
	@Resource
	  WebServiceContext wsContext; 

	@Override
	public OrderTaxCalculationResponse getTax(
			OrderTaxCaluculationRequest request) {
		
        String MethodName= "getTax()";
        MessageContext mc = wsContext.getMessageContext();
        HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
        System.out.println("<<<========================================START============================================>>>");
        log.info("Client IP = " + req.getRemoteAddr()); 
       
        long startTime=System.currentTimeMillis();
        log.info(MethodName+"   : Begin");
        
       	System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
		
		  CustomerType customerReqType;
		  SellerType sellerReqType;
		  List<LineItemType> lineItemReq;
		  XMLGregorianCalendar reqdocumentDate;
		  AddressType addressReq;
		  AddressType selleraddressReq;
		  AddressType administrativeAddressReq;
		  LoginType loginType;
		  String address1="";
		  String address2="";
		  String city="";
		  String zip="";
		  String state="";
		  String subdivision="";
		  String maindivision="";
		  String country="";
		  String customerCode="";
		  String customervalue="";
		  String selleraddress1="";
		  String selleraddress2="";
		  String sellercity="";
		  String sellerzip="";
		  String sellerstate="";
		  String company="";
		  String responseMsg="SUCCESS";
		  String[] valueFromDB=DataBaseDateFetch.fetchDate();
		  String password=valueFromDB[0];
		  String userName=valueFromDB[1];
		  String hmUserName="";
		  String hmPassword="";
		  
		 
		  
	
		  
		  
		  customerReqType=request.getCustomerType();
		  loginType=request.getLoginType();
		  hmUserName=loginType.getLoginId();
		  hmPassword=loginType.getPassword();
		  sellerReqType=request.getSellerType();
		  reqdocumentDate= request.getDocumentDate();
		  log.info("DocumentDate==========>"+request.getDocumentDate());
		//  log.info("hmPassword==========>"+hmPassword);
		  log.info("hmUserName==========>"+hmUserName);
		 
		  addressReq=customerReqType.getAddress();
		  administrativeAddressReq=customerReqType.getAdministrativeAddress();
		  
		  if(null!=customerReqType.getCustomerNumber() && !"?".equalsIgnoreCase(customerReqType.getCustomerNumber()))
		  customervalue=customerReqType.getCustomerNumber();
		  log.info("customervalue==========>"+customervalue);
		  if(null!=customerReqType.getClassCode() && !"?".equalsIgnoreCase(customerReqType.getClassCode()))
		  customerCode=customerReqType.getClassCode();
		  log.info("customerCode==========>"+customerCode);
		  if(null!=addressReq.getStreetAddress1() && !"?".equalsIgnoreCase(addressReq.getStreetAddress1()))
		  address1=addressReq.getStreetAddress1();
		  log.info("address1==========>"+address1);
		  if(null!=addressReq.getStreetAddress2() && !"?".equalsIgnoreCase(addressReq.getStreetAddress2())) 
		  address2=addressReq.getStreetAddress2();
		  log.info("address2==========>"+address2);
		  if(null!=addressReq.getCity() && !"?".equalsIgnoreCase(addressReq.getCity()))
		  city=addressReq.getCity().toUpperCase();
		  log.info("city==========>"+city);
		  if(null!=addressReq.getCountry() && !"?".equalsIgnoreCase(addressReq.getCountry()))
		  country=addressReq.getCountry();
		  log.info("country==========>"+country);
		  if(null!=addressReq.getSubDivision() && !"?".equalsIgnoreCase(addressReq.getSubDivision()))
		  subdivision=addressReq.getSubDivision();
		  log.info("subdivision==========>"+subdivision);
		  if(null!=addressReq.getMainDivision() && !"?".equalsIgnoreCase(addressReq.getMainDivision()))
		  state=addressReq.getMainDivision();
		  log.info("state==========>"+state);
		  if(null!=addressReq.getPostalCode() && !"?".equalsIgnoreCase(addressReq.getPostalCode()))
		  zip=addressReq.getPostalCode();
		  log.info("zip==========>"+zip);
		  
		  
		
		  
		  selleraddressReq=sellerReqType.getAddress();
		  if(null!=sellerReqType.getCompany() && !"?".equalsIgnoreCase(sellerReqType.getCompany()))
		  company=sellerReqType.getCompany();
		  log.info("company==========>"+company);
		  if(null!=selleraddressReq.getStreetAddress1() && !"?".equalsIgnoreCase(selleraddressReq.getStreetAddress1()))
		  selleraddress1=selleraddressReq.getStreetAddress1();
		  log.info("selleraddress1==========>"+selleraddress1);
		  if(null!=selleraddressReq.getStreetAddress2() && !"?".equalsIgnoreCase(selleraddressReq.getStreetAddress2())) 
		  selleraddress2=selleraddressReq.getStreetAddress2();
		  log.info("selleraddress2==========>"+selleraddress2);
		  if(null!=selleraddressReq.getCity() && !"?".equalsIgnoreCase(selleraddressReq.getCity()))
			  sellercity=selleraddressReq.getCity().toUpperCase();
		  log.info("sellercity==========>"+sellercity);	 
		  if(null!=selleraddressReq.getMainDivision() && !"?".equalsIgnoreCase(selleraddressReq.getMainDivision()))
			  sellerstate=selleraddressReq.getMainDivision();
		  log.info("sellerstate==========>"+sellerstate);
		  if(null!=selleraddressReq.getPostalCode() && !"?".equalsIgnoreCase(selleraddressReq.getPostalCode()))
			  sellerzip=selleraddressReq.getPostalCode();
		  log.info("sellerzip==========>"+sellerzip);
		  
		  lineItemReq=request.getLineItem();
		
		OrderTaxCalculationResponse response= new OrderTaxCalculationResponse();
		response.setCustomerType(customerReqType);
		CalculateTaxMiddleLayer midLayer = new CalculateTaxMiddleLayer();
		if(DataBaseDateFetch.getHmUserName().equalsIgnoreCase(hmUserName)&& 
				   DataBaseDateFetch.getHmPassword().endsWith(hmPassword)){
			
				/*if(((null!=zip && (!"".equalsIgnoreCase(zip)))||(null!=state&&(!"".equalsIgnoreCase(state)))
						||(null!=city&&(!"".equalsIgnoreCase(city)))||(null!=address1&&(!"".equalsIgnoreCase(address1))))){*/
                  midLayer.connector(address1, address2, city, state,subdivision, zip, country,customervalue,customerCode,company,userName,password,administrativeAddressReq,lineItemReq,reqdocumentDate,response);
				/*}else{
					responseMsg= "FAILED :"+ "Mandatory Parameter Missing for Tax Area lookUp ";
					log.info("midLayer.connector===>"+responseMsg);
					response.setResponseMsg(responseMsg);
					response.setTaxAreaId(Integer.parseInt("-1"));
				}*/
		}else{
			
			responseMsg= "FAILED :"+ "Credential Doesn't Match";			
			response.setResponseMsg(responseMsg);
			//response.setTaxAreaId(Integer.parseInt("-1"));
	
		}
		//customerReqType.setAddress(addressReq);
		sellerReqType.setAddress(selleraddressReq);
		sellerReqType.setCompany(company);
		response.setLoginType(loginType);
		response.setSellerType(sellerReqType);
		
		response.setLineItem(lineItemReq);
		
		if(null==response.getResponseMsg() ||  "".equalsIgnoreCase(response.getResponseMsg())){
			response.setResponseMsg(responseMsg);
		}
		response.setDocumentDate(reqdocumentDate);
		long endTime=System.currentTimeMillis();
		long duration =(endTime-startTime);
		log.info("RESULT===>"+response.getResponseMsg());
		log.info("Total Time Taken by the service in MiliSec  :"+ duration);
		
		log.info(MethodName+"   : End");
		 System.out.println("<<<========================================END============================================>>>");
	    return response;
	}

}
