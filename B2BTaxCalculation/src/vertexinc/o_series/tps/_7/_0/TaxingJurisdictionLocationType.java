
package vertexinc.o_series.tps._7._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxingJurisdictionLocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxingJurisdictionLocationType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:7:0}LocationType">
 *       &lt;attribute name="jurisdictionLevel" use="required" type="{urn:vertexinc:o-series:tps:7:0}JurisdictionLevelCodeType" />
 *       &lt;attribute name="impositionType">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="0"/>
 *             &lt;maxLength value="60"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxingJurisdictionLocationType")
@XmlSeeAlso({
    vertexinc.o_series.tps._7._0.InputTax.TaxingJurisdictionLocation.class
})
public class TaxingJurisdictionLocationType
    extends LocationType
{

    @XmlAttribute(name = "jurisdictionLevel", required = true)
    protected JurisdictionLevelCodeType jurisdictionLevel;
    @XmlAttribute(name = "impositionType")
    protected String impositionType;

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
