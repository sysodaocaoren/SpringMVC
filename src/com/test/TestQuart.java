package com.test;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TestQuart {
    private static int  counter = 0;  
    protected void execute()  {  
        long ms = System.currentTimeMillis();  
        System.out.println("\t\t" + new Date(ms));  
        System.out.println("(" + counter++ + ")");  
    }  
}
