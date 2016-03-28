package hml.com;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

public class LineItemType {
	
	
    protected BigDecimal unitPrice;
    
       
    protected BigDecimal extendedPrice;
    
    protected BigInteger lineItemNumber;
    
    protected String product;
   
    protected String productClass;
    
    protected XMLGregorianCalendar taxDate;
    
    protected BigDecimal totalTax;
    
    protected BigDecimal quantity;
    
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	
	@XmlAttribute(name = "taxDate", required = true)
    @XmlSchemaType(name = "date")
	public XMLGregorianCalendar getTaxDate() {
		return taxDate;
	}
	public void setTaxDate(XMLGregorianCalendar taxDate) {
		this.taxDate = taxDate;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public BigDecimal getExtendedPrice() {
		return extendedPrice;
	}
	public void setExtendedPrice(BigDecimal extendedPrice) {
		this.extendedPrice = extendedPrice;
	}
	public BigInteger getLineItemNumber() {
		return lineItemNumber;
	}
	public void setLineItemNumber(BigInteger lineItemNumber) {
		this.lineItemNumber = lineItemNumber;
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
    

}
