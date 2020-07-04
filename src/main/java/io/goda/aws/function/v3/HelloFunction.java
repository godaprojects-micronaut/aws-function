package io.goda.aws.function.v3;

import io.goda.aws.bean.HelloBean;
import io.goda.aws.service.HelloService;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.FunctionBean;
import io.micronaut.function.aws.MicronautRequestHandler;

import javax.inject.Inject;
import java.util.function.Function;

//@FunctionBean("hello-function")
@FunctionBean("test")
public class HelloFunction implements  Function<HelloBean, String> {
    private HelloService helloService;

    public HelloFunction(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String apply(HelloBean bean) {
        return helloService.sayHello(bean, "v3 - using java.util.function.Function");
    }
}
