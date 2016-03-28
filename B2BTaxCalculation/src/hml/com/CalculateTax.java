package hml.com;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface CalculateTax {
	
	@WebMethod
	@WebResult(name="orderTaxCaluculationResponse")
	public OrderTaxCalculationResponse getTax ( 
			
			@WebParam(name="orderTaxCaluculationRequest")
			OrderTaxCaluculationRequest request );

}
