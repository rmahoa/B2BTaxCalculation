package hml.com;

import javax.jws.WebParam;
import javax.xml.bind.annotation.*;

@XmlType(propOrder = {
		"company",
		"address",
		
		
		
		
})

public class SellerType {
	
	 protected AddressType address;
	 
	    public AddressType getAddress() {
		return address;
	}
	public void setAddress(AddressType address) {
		this.address = address;
	}

	
	@XmlAttribute(name = "company", required = true)
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
		
	  
	    
	    protected String company;

}
