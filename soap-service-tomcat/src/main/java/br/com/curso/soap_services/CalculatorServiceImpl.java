
package br.com.curso.soap_services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ICalculator", targetNamespace = "http://Example.org")
@XmlSeeAlso({
    ObjectFactory.class
})
public class CalculatorServiceImpl implements ICalculator{


    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod(operationName = "Add", action = "http://Example.org/ICalculator/Add")
    @WebResult(name = "result", targetNamespace = "http://Example.org")
    @RequestWrapper(localName = "Add", targetNamespace = "http://Example.org", className = "br.com.curso.soap_services.Add")
    @ResponseWrapper(localName = "AddResponse", targetNamespace = "http://Example.org", className = "br.com.curso.soap_services.AddResponse")
    public Integer add(
        @WebParam(name = "a", targetNamespace = "http://Example.org")
        Integer a,
        @WebParam(name = "b", targetNamespace = "http://Example.org")
        Integer b){
    	return a+b;
    }

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod(operationName = "Subtract", action = "http://Example.org/ICalculator/Subtract")
    @WebResult(name = "result", targetNamespace = "http://Example.org")
    @RequestWrapper(localName = "Subtract", targetNamespace = "http://Example.org", className = "br.com.curso.soap_services.Subtract")
    @ResponseWrapper(localName = "SubtractResponse", targetNamespace = "http://Example.org", className = "br.com.curso.soap_services.SubtractResponse")
    public Integer subtract(
        @WebParam(name = "a", targetNamespace = "http://Example.org")
        Integer a,
        @WebParam(name = "b", targetNamespace = "http://Example.org")
        Integer b){
    	return a-b;
    }

}
