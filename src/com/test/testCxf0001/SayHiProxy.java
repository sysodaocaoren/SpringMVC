package com.test.testCxf0001;

import org.springframework.stereotype.Service;

@Service
public class SayHiProxy implements SayHi {
  private String _endpoint = null;
  private SayHi sayHi = null;
  
  public SayHiProxy() {
    _initSayHiProxy();
  }
  
  public SayHiProxy(String endpoint) {
    _endpoint = endpoint;
    _initSayHiProxy();
  }
  
  private void _initSayHiProxy() {
    try {
      sayHi = (new SayHiImplServiceLocator()).getSayHiImplPort();
      if (sayHi != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sayHi)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sayHi)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sayHi != null)
      ((javax.xml.rpc.Stub)sayHi)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public SayHi getSayHi() {
    if (sayHi == null)
      _initSayHiProxy();
    return sayHi;
  }
  
  public java.lang.String sayHello(java.lang.String arg0) throws java.rmi.RemoteException{
    if (sayHi == null)
      _initSayHiProxy();
    return sayHi.sayHello(arg0);
  }
  
  
}