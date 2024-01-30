package org.functions;

import org.functions.pojo.Employee;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import software.amazon.lambda.powertools.validation.Validation;

public class LambdaInputValidation implements RequestHandler<Employee, String>
{

	
   @Override
   @Validation(inboundSchema = "classpath:/schema.json")
	public String handleRequest(Employee input, Context context) {
		// TODO Auto-generated method stub
		return "All ok !!";
	}
   
}