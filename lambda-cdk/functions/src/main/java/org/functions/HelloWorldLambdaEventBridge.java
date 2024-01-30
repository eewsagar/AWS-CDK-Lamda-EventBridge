package org.functions;

import java.text.SimpleDateFormat;


public class HelloWorldLambdaEventBridge {
	
	public void handleRequest() {
		// TODO Auto-generated method stub
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		System.out.println("Hello world eventbridge Lamda : "+timestamp);
		
	}

}
