package io.goda.aws.function.v2;

import io.goda.aws.bean.HelloBean;
import io.goda.aws.service.HelloService;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import io.micronaut.function.executor.FunctionInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Introspected
public class HelloFunction extends MicronautRequestHandler<HelloBean, String> {
    @Inject
    private HelloService helloService;

    public static final Logger LOGGER = LoggerFactory.getLogger(HelloFunction.class);

    @Override
    public String execute(HelloBean bean) {
        LOGGER.info("In v2 of the function using MicronautRequestHandler and the input is ", bean.getName());
        return helloService.sayHello(bean, "v2 - Using MicronautRequestHandler");
    }
}
