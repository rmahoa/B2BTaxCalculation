package hml.com;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlType(propOrder = {
		"loginType",
		"responseMsg",
		"documentDate",
		"taxAreaId",
		"totalTax",
		"confidenceIndicator",
		"sellerType",
		"customerType",
		"lineItem",
		
})

public class OrderTaxCalculationResponse {
	
	protected String responseMsg;
	
    protected CustomerType customerType;
    
    protected SellerType sellerType;
    
	protected List<LineItemType> lineItem;

    protected XMLGregorianCalendar documentDate;
    
    protected Integer confidenceIndicator;
    
    protected Integer taxAreaId;
    
    protected BigDecimal totalTax;
    
    
    @XmlElement(name = "loginType", required = true)
    public LoginType getLoginType() {
		return loginType;
	}
	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}
	protected LoginType loginType;
    
    
    @XmlElement(name = "sellerType")
    public SellerType getSellerType() {
		return sellerType;
	}
	public void setSellerType(SellerType sellerType) {
		this.sellerType = sellerType;
	}
	
    @XmlElement(name = "totalTax")
    public BigDecimal getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	@XmlElement(name = "confidenceIndicator")
    public Integer getConfidenceIndicator() {
		return confidenceIndicator;
	}
	public void setConfidenceIndicator(Integer confidenceIndicator) {
		this.confidenceIndicator = confidenceIndicator;
	}
	@XmlElement(name = "taxAreaId")
	public Integer getTaxAreaId() {
		return taxAreaId;
	}
	public void setTaxAreaId(Integer taxAreaId) {
		this.taxAreaId = taxAreaId;
	}
	@XmlElement(name = "responseMsg")
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
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
	
	@XmlAttribute(name = "documentDate", required = true)
    @XmlSchemaType(name = "date")
	public XMLGregorianCalendar getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(XMLGregorianCalendar documentDate) {
		this.documentDate = documentDate;
	}

}
