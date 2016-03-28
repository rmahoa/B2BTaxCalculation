
package vertexinc.o_series.tps._7._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Rollback Request message.
 * 
 * <p>Java class for RollbackRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RollbackRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:7:0}TaxSynchronizationRequestType">
 *       &lt;attGroup ref="{urn:vertexinc:o-series:tps:7:0}RollbackTransactionGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RollbackRequestType")
public class RollbackRequestType
    extends TaxSynchronizationRequestType
{

    @XmlAttribute(name = "transactionId", required = true)
    protected String transactionId;

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

}
