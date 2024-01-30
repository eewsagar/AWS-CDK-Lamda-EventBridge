package org.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Hello world!
 *
 */
public class HelloWorldLambda implements RequestHandler<String, String>
{

	

	@Override
	public String handleRequest(String input, Context context) {
		// TODO Auto-generated method stub
		return "Hello "+input;
	}
   
}
