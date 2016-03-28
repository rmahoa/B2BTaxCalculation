package hml.com;

import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {
		"addressResponse",
		"taxAreaId",
		"confidenceIndicator",
		"streetAddress1",
		"streetAddress2",
		"city",
		"mainDivision",
		"subDivision",
		"postalCode",
		"country",
		
})
public class AddressType {
	
	 
	    protected String streetAddress1;
	 
	    protected String streetAddress2;
	   
	    protected String city;
	   
	    protected String mainDivision;
	    
	    protected String subDivision;
	    
	    protected String postalCode;
	   
	    protected String country;
	    
	    protected String addressResponse;
		   
	    protected Integer taxAreaId;
	   
	    protected Integer confidenceIndicator;
	    
	   
	    
	    
	    
	    
		public String getAddressResponse() {
			return addressResponse;
		}
		public void setAddressResponse(String addressResponse) {
			this.addressResponse = addressResponse;
		}
		public Integer getTaxAreaId() {
			return taxAreaId;
		}
		public void setTaxAreaId(Integer taxAreaId) {
			this.taxAreaId = taxAreaId;
		}
		public Integer getConfidenceIndicator() {
			return confidenceIndicator;
		}
		public void setConfidenceIndicator(Integer confidenceIndicator) {
			this.confidenceIndicator = confidenceIndicator;
		}
		public String getStreetAddress1() {
			return streetAddress1;
		}
		public void setStreetAddress1(String streetAddress1) {
			this.streetAddress1 = streetAddress1;
		}
		public String getStreetAddress2() {
			return streetAddress2;
		}
		public void setStreetAddress2(String streetAddress2) {
			this.streetAddress2 = streetAddress2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getMainDivision() {
			return mainDivision;
		}
		public void setMainDivision(String mainDivision) {
			this.mainDivision = mainDivision;
		}
		public String getSubDivision() {
			return subDivision;
		}
		public void setSubDivision(String subDivision) {
			this.subDivision = subDivision;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
	

}
