package com.myorg;



import software.amazon.awscdk.Duration;
import software.amazon.awscdk.services.events.targets.LambdaFunction;
import software.amazon.awscdk.services.lambda.*;
import software.amazon.awscdk.services.events.IRule.*;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.events.Rule;
import software.amazon.awscdk.services.events.Schedule;
import software.amazon.awscdk.services.events.IRuleTarget;

public class InfraStack extends Stack {
    public InfraStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public InfraStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // Create a new lambda function
        Function.Builder.create(this, "hello-world-lambda")
        .runtime(Runtime.JAVA_11)
        .handler("org.functions.HelloWorldLambda")
        .memorySize(128)
        .timeout(Duration.seconds(20))
        .functionName("HelloWorldLambda")
        .code(Code.fromAsset("../functions/target/functions-0.0.1-SNAPSHOT.jar"))
        .build();
        
       Function function= Function.Builder.create(this, "hello-world-eventbridge-lambda")
        .runtime(Runtime.JAVA_11)
        .handler("org.functions.HelloWorldLambdaEventBridge::handleRequest")
        .memorySize(128)
        .timeout(Duration.seconds(20))
        .functionName("HelloWorldLambdaEventBridge")
        .code(Code.fromAsset("../functions/target/functions-0.0.1-SNAPSHOT.jar"))
        .build(); 
       
       Rule rule =  Rule.Builder.create(this, "lambda-scheduler")
    		   .ruleName("LambdaRule")
    		   .schedule(Schedule.rate(Duration.minutes(1)))
    		   .build();
       
       rule.addTarget(new LambdaFunction(function));

//       Function.Builder.create(this, "lambda-input-validation")
//       .runtime(Runtime.JAVA_11)
//       .handler("org.functions.LambdaInputValidation")
//       .memorySize(128)
//       .timeout(Duration.seconds(20))
//       .functionName("LambdaInputValidation")
//       .code(Code.fromAsset("../functions/target/functions-0.0.1-SNAPSHOT.jar"))
//       .build();
       
    }
        
}
