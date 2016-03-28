
package vertexinc.o_series.tps._7._0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliveryTermCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeliveryTermCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="EXW"/>
 *     &lt;enumeration value="FCA"/>
 *     &lt;enumeration value="FAS"/>
 *     &lt;enumeration value="FOB"/>
 *     &lt;enumeration value="CFR"/>
 *     &lt;enumeration value="CIF"/>
 *     &lt;enumeration value="CPT"/>
 *     &lt;enumeration value="CIP"/>
 *     &lt;enumeration value="DAF"/>
 *     &lt;enumeration value="DES"/>
 *     &lt;enumeration value="DEQ"/>
 *     &lt;enumeration value="DDU"/>
 *     &lt;enumeration value="DDP"/>
 *     &lt;enumeration value="DAP"/>
 *     &lt;enumeration value="DAT"/>
 *     &lt;enumeration value="SUP"/>
 *     &lt;enumeration value="CUS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeliveryTermCodeType")
@XmlEnum
public enum DeliveryTermCodeType {


    /**
     * Ex Works (EXW)
     * 
     */
    EXW,

    /**
     * Free Carrier (FCA)
     * 
     */
    FCA,

    /**
     * Free Along Side Ship (FAS)
     * 
     */
    FAS,

    /**
     * Free Onboard Vessel (FOB)
     * 
     */
    FOB,

    /**
     * Cost and Freight (CFR)
     * 
     */
    CFR,

    /**
     * Cost Insurance and Freight (CIF)
     * 
     */
    CIF,

    /**
     * Carriage Paid To (CPT)
     * 
     */
    CPT,

    /**
     * Carriage Insurance Paid To (CIP)
     * 
     */
    CIP,

    /**
     * Delivered at Frontier (DAF)
     * 
     */
    DAF,

    /**
     * Delivered Ex Ship (DES)
     * 
     */
    DES,

    /**
     * Delivered Ex Quay Duty Unpaid (DEQ)
     * 
     */
    DEQ,

    /**
     * Delivery Duty Unpaid (DDU)
     * 
     */
    DDU,

    /**
     * Delivery Duty Paid (DDP)
     * 
     */
    DDP,

    /**
     * Delivered at Place (DAP)
     * 
     */
    DAP,

    /**
     * Delivered at Terminal (DAT)
     * 
     */
    DAT,

    /**
     * Supplier Ships (SUP)
     * 
     */
    SUP,

    /**
     * Customer Ships (CUS)
     * 
     */
    CUS;

    public String value() {
        return name();
    }

    public static DeliveryTermCodeType fromValue(String v) {
        return valueOf(v);
    }

}
