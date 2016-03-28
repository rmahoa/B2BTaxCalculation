package hml.com;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlType(propOrder = {
		"loginType",
		"sellerType",
		"customerType",
		"lineItem",
				
})

public class OrderTaxCaluculationRequest {
	
	
    protected CustomerType customerType;
    
    protected LoginType loginType;
    
    @XmlElement(name = "loginType", required = true)
    public LoginType getLoginType() {
		return loginType;
	}
	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}
	protected SellerType sellerType;
	
	
    public SellerType getSellerType() {
		return sellerType;
	}
    @XmlElement(name = "sellerType")
	public void setSellerType(SellerType sellerType) {
		this.sellerType = sellerType;
	}
	protected List<LineItemType> lineItem;
	

    protected XMLGregorianCalendar documentDate;
	
	
	@XmlAttribute(name = "documentDate", required = true)
    @XmlSchemaType(name = "date")
	public XMLGregorianCalendar getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(XMLGregorianCalendar documentDate) {
		this.documentDate = documentDate;
	}
	
	@XmlElement(name = "customerType")
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	
	@XmlElement(name = "LineItem", required = true)
	public List<LineItemType> getLineItem() {
		return lineItem;
	}
	public void setLineItem(List<LineItemType> lineItem) {
		this.lineItem = lineItem;
	}
    

}
