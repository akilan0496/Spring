package com.akilan0496.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface CustomJSONRoot {

	String singular();
	String plural();
	
}
