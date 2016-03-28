
package com.vertexinc.oseries.services.lookuptaxareas70;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import com.hml.DataBaseDateFetch;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LookupTaxAreasWSService70", targetNamespace = "http://www.vertexinc.com/oseries/services/LookupTaxAreas70", wsdlLocation = "http://vertex-dev.hermanmiller.com:80/vertex-ws/services/LookupTaxAreas70?wsdl")
public class LookupTaxAreasWSService70
    extends Service
{

    private final static URL LOOKUPTAXAREASWSSERVICE70_WSDL_LOCATION;
    private final static WebServiceException LOOKUPTAXAREASWSSERVICE70_EXCEPTION;
    private final static QName LOOKUPTAXAREASWSSERVICE70_QNAME = new QName("http://www.vertexinc.com/oseries/services/LookupTaxAreas70", "LookupTaxAreasWSService70");
    static String wsdlTaxAreLocation=DataBaseDateFetch.getTaxAreaLookUpUrl();
    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL(wsdlTaxAreLocation);
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LOOKUPTAXAREASWSSERVICE70_WSDL_LOCATION = url;
        LOOKUPTAXAREASWSSERVICE70_EXCEPTION = e;
    }

    public LookupTaxAreasWSService70() {
        super(__getWsdlLocation(), LOOKUPTAXAREASWSSERVICE70_QNAME);
    }

    public LookupTaxAreasWSService70(WebServiceFeature... features) {
        super(__getWsdlLocation(), LOOKUPTAXAREASWSSERVICE70_QNAME, features);
    }

    public LookupTaxAreasWSService70(URL wsdlLocation) {
        super(wsdlLocation, LOOKUPTAXAREASWSSERVICE70_QNAME);
    }

    public LookupTaxAreasWSService70(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LOOKUPTAXAREASWSSERVICE70_QNAME, features);
    }

    public LookupTaxAreasWSService70(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LookupTaxAreasWSService70(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LookupTaxAreasWS70
     */
    @WebEndpoint(name = "LookupTaxAreas70")
    public LookupTaxAreasWS70 getLookupTaxAreas70() {
        return super.getPort(new QName("http://www.vertexinc.com/oseries/services/LookupTaxAreas70", "LookupTaxAreas70"), LookupTaxAreasWS70.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LookupTaxAreasWS70
     */
    @WebEndpoint(name = "LookupTaxAreas70")
    public LookupTaxAreasWS70 getLookupTaxAreas70(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.vertexinc.com/oseries/services/LookupTaxAreas70", "LookupTaxAreas70"), LookupTaxAreasWS70.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LOOKUPTAXAREASWSSERVICE70_EXCEPTION!= null) {
            throw LOOKUPTAXAREASWSSERVICE70_EXCEPTION;
        }
        return LOOKUPTAXAREASWSSERVICE70_WSDL_LOCATION;
    }

}
