
package vertexinc.o_series.tps._7._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxpayerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxpayerType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:7:0}PartyType">
 *       &lt;sequence>
 *         &lt;element name="Company" type="{urn:vertexinc:o-series:tps:7:0}EntityCodeType" minOccurs="0"/>
 *         &lt;element name="Division" type="{urn:vertexinc:o-series:tps:7:0}EntityCodeType" minOccurs="0"/>
 *         &lt;element name="Department" type="{urn:vertexinc:o-series:tps:7:0}EntityCodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxpayerType", propOrder = {
    "company",
    "division",
    "department"
})
@XmlSeeAlso({
    BuyerType.class,
    InvoiceVerificationBuyerType.class,
    SellerType.class,
    OwnerType.class,
    ERSBuyerType.class
})
public class TaxpayerType
    extends PartyType
{

    @XmlElement(name = "Company")
    protected String company;
    @XmlElement(name = "Division")
    protected String division;
    @XmlElement(name = "Department")
    protected String department;

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the division property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets the value of the division property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivision(String value) {
        this.division = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

}
