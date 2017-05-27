package com.common.config.test;

import org.apache.commons.lang3.Validate;
import org.eclipse.jetty.util.StringUtil;

public class TestLang3 {
    public static void main(String [] args){
    	Validate.isTrue(true, "234", 23);
    	System.out.println(StringUtil.isNotBlank(""));
    	System.out.println(StringUtil.isNotBlank(null));
    }
}
