
package hml.com.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getTax", namespace = "http://com.hml/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTax", namespace = "http://com.hml/")
public class GetTax {

    @XmlElement(name = "orderTaxCaluculationRequest", namespace = "")
    private hml.com.OrderTaxCaluculationRequest orderTaxCaluculationRequest;

    /**
     * 
     * @return
     *     returns OrderTaxCaluculationRequest
     */
    public hml.com.OrderTaxCaluculationRequest getOrderTaxCaluculationRequest() {
        return this.orderTaxCaluculationRequest;
    }

    /**
     * 
     * @param orderTaxCaluculationRequest
     *     the value for the orderTaxCaluculationRequest property
     */
    public void setOrderTaxCaluculationRequest(hml.com.OrderTaxCaluculationRequest orderTaxCaluculationRequest) {
        this.orderTaxCaluculationRequest = orderTaxCaluculationRequest;
    }

}
