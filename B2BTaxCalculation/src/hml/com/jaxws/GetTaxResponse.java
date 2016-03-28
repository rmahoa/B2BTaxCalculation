
package hml.com.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getTaxResponse", namespace = "http://com.hml/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTaxResponse", namespace = "http://com.hml/")
public class GetTaxResponse {

    @XmlElement(name = "orderTaxCaluculationResponse", namespace = "")
    private hml.com.OrderTaxCalculationResponse orderTaxCaluculationResponse;

    /**
     * 
     * @return
     *     returns OrderTaxCalculationResponse
     */
    public hml.com.OrderTaxCalculationResponse getOrderTaxCaluculationResponse() {
        return this.orderTaxCaluculationResponse;
    }

    /**
     * 
     * @param orderTaxCaluculationResponse
     *     the value for the orderTaxCaluculationResponse property
     */
    public void setOrderTaxCaluculationResponse(hml.com.OrderTaxCalculationResponse orderTaxCaluculationResponse) {
        this.orderTaxCaluculationResponse = orderTaxCaluculationResponse;
    }

}
