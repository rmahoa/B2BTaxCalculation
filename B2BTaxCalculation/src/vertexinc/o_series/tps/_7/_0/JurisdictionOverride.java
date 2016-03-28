
package vertexinc.o_series.tps._7._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:7:0}DeductionOverride" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:7:0}RateOverride" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="jurisdictionLevel" use="required" type="{urn:vertexinc:o-series:tps:7:0}JurisdictionLevelCodeType" />
 *       &lt;attribute name="impositionType">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="0"/>
 *             &lt;maxLength value="60"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "deductionOverride",
    "rateOverride"
})
@XmlRootElement(name = "JurisdictionOverride")
public class JurisdictionOverride {

    @XmlElement(name = "DeductionOverride")
    protected DeductionOverride deductionOverride;
    @XmlElement(name = "RateOverride")
    protected RateOverride rateOverride;
    @XmlAttribute(name = "jurisdictionLevel", required = true)
    protected JurisdictionLevelCodeType jurisdictionLevel;
    @XmlAttribute(name = "impositionType")
    protected String impositionType;

    /**
     * Gets the value of the deductionOverride property.
     * 
     * @return
     *     possible object is
     *     {@link DeductionOverride }
     *     
     */
    public DeductionOverride getDeductionOverride() {
        return deductionOverride;
    }

    /**
     * Sets the value of the deductionOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeductionOverride }
     *     
     */
    public void setDeductionOverride(DeductionOverride value) {
        this.deductionOverride = value;
    }

    /**
     * Gets the value of the rateOverride property.
     * 
     * @return
     *     possible object is
     *     {@link RateOverride }
     *     
     */
    public RateOverride getRateOverride() {
        return rateOverride;
    }

    /**
     * Sets the value of the rateOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateOverride }
     *     
     */
    public void setRateOverride(RateOverride value) {
        this.rateOverride = value;
    }

    /**
     * Gets the value of the jurisdictionLevel property.
     * 
     * @return
     *     possible object is
     *     {@link JurisdictionLevelCodeType }
     *     
     */
    public JurisdictionLevelCodeType getJurisdictionLevel() {
        return jurisdictionLevel;
    }

    /**
     * Sets the value of the jurisdictionLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JurisdictionLevelCodeType }
     *     
     */
    public void setJurisdictionLevel(JurisdictionLevelCodeType value) {
        this.jurisdictionLevel = value;
    }

    /**
     * Gets the value of the impositionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpositionType() {
        return impositionType;
    }

    /**
     * Sets the value of the impositionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpositionType(String value) {
        this.impositionType = value;
    }

}
