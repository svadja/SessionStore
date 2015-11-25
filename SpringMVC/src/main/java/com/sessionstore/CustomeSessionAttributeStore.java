package com.sessionstore;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

public class CustomeSessionAttributeStore extends DefaultSessionAttributeStore implements
InitializingBean {

	@Inject
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
	
	private Logger logger = LoggerFactory
			.getLogger(CustomeSessionAttributeStore.class.getName());
	
	@Override
	protected String getAttributeNameInSession(WebRequest request, String attributeName) {
		String cid="";
		if (request.getParameter(attributeName + "_cid") == null){
		
			cid = ""+request.getAttribute(attributeName + "_cid", WebRequest.SCOPE_REQUEST);
		}else{
			cid = request.getParameter(attributeName + "_cid");
		}
	    if (cid != null && !"".equals(cid) && !"null".equals(cid)) {
	      return super.getAttributeNameInSession(request, attributeName + "_" + cid);
	    }
	    return super.getAttributeNameInSession(request, attributeName);
	  }
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		requestMappingHandlerAdapter.setSessionAttributeStore(this);	
	}
	

}
