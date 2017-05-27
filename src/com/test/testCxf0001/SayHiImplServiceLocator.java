/**
 * SayHiImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.test.testCxf0001;

import org.springframework.stereotype.Service;

@Service
public class SayHiImplServiceLocator extends org.apache.axis.client.Service implements SayHiImplService {

    public SayHiImplServiceLocator() {
    }


    public SayHiImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SayHiImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SayHiImplPort
    private java.lang.String SayHiImplPort_address = "http://localhost:8090/testCxf0001/services/sayHi";

    public java.lang.String getSayHiImplPortAddress() {
        return SayHiImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SayHiImplPortWSDDServiceName = "SayHiImplPort";

    public java.lang.String getSayHiImplPortWSDDServiceName() {
        return SayHiImplPortWSDDServiceName;
    }

    public void setSayHiImplPortWSDDServiceName(java.lang.String name) {
        SayHiImplPortWSDDServiceName = name;
    }

    public SayHi getSayHiImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SayHiImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSayHiImplPort(endpoint);
    }

    public SayHi getSayHiImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SayHiImplServiceSoapBindingStub _stub = new SayHiImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSayHiImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSayHiImplPortEndpointAddress(java.lang.String address) {
        SayHiImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (SayHi.class.isAssignableFrom(serviceEndpointInterface)) {
                SayHiImplServiceSoapBindingStub _stub = new SayHiImplServiceSoapBindingStub(new java.net.URL(SayHiImplPort_address), this);
                _stub.setPortName(getSayHiImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SayHiImplPort".equals(inputPortName)) {
            return getSayHiImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://testCxf0001.testCxf.com.cn/", "SayHiImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://testCxf0001.testCxf.com.cn/", "SayHiImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SayHiImplPort".equals(portName)) {
            setSayHiImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
