package hml.com;

import javax.jws.WebParam;
import javax.xml.bind.annotation.*;

@XmlType(propOrder = {
		"address",
		"administrativeAddress",
		"classCode",
		"customerNumber",
		
		
})

public class CustomerType {
	
	 protected AddressType address;
	 
	 protected AddressType administrativeAddress;
	 
	    public AddressType getAdministrativeAddress() {
		return administrativeAddress;
	}
	public void setAdministrativeAddress(AddressType administrativeAddress) {
		this.administrativeAddress = administrativeAddress;
	}
		public AddressType getAddress() {
		return address;
	}
	public void setAddress(AddressType address) {
		this.address = address;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	@XmlAttribute(name = "classCode", required = true)
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
		
	    protected String customerNumber;
	    
	    protected String classCode;

}
