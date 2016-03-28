
package vertexinc.o_series.tps._7._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:vertexinc:o-series:tps:7:0>JurisdictionLevelCodeType">
 *       &lt;attribute name="impositionType">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="0"/>
 *             &lt;maxLength value="60"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "ImpositionToProcess")
public class ImpositionToProcess {

    @XmlValue
    protected JurisdictionLevelCodeType value;
    @XmlAttribute(name = "impositionType")
    protected String impositionType;

    /**
     * Copyright Vertex Inc. 2007-2012 All Rights Reserved
     * 
     * @return
     *     possible object is
     *     {@link JurisdictionLevelCodeType }
     *     
     */
    public JurisdictionLevelCodeType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link JurisdictionLevelCodeType }
     *     
     */
    public void setValue(JurisdictionLevelCodeType value) {
        this.value = value;
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
