package io.goda.aws.function.v2;

import io.goda.aws.bean.HelloBean;
import io.goda.aws.service.HelloService;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import io.micronaut.function.executor.FunctionInitializer;

import javax.inject.Inject;

@Introspected
public class HelloFunction extends MicronautRequestHandler<HelloBean, String> {
    @Inject
    private HelloService helloService;
    @Override
    public String execute(HelloBean bean) {
        return helloService.sayHello(bean, "v2 - Using MicronautRequestHandler");
    }
}
