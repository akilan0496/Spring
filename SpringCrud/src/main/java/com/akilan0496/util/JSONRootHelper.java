package com.akilan0496.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class JSONRootHelper {
	
	public Map<String, Object> getResponse(String pluralization, Object object) {
		Map<String, Object> responseObject = new HashMap<>();
		responseObject.put(pluralization, object); 
		return responseObject;
	}

}
