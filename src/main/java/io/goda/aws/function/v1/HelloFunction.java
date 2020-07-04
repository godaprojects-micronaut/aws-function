package io.goda.aws.function.v1;

import io.goda.aws.bean.HelloBean;
import io.goda.aws.service.HelloService;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.executor.FunctionInitializer;

import javax.inject.Inject;

@Introspected
public class HelloFunction extends FunctionInitializer {
    @Inject
    private HelloService helloService;

    public String sayHello(HelloBean bean){
        return helloService.sayHello(bean,"v1 - using FunctionInitializer");
    }
}
