package aws.function;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.goda.aws.bean.HelloBean;
import io.goda.aws.function.v2.HelloFunction;
import io.goda.aws.service.HelloService;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.*;

import javax.inject.Inject;

@MicronautTest
public class HelloFunctionTest {

    private static HelloFunction helloFunction;

    @Inject
    HelloService helloService;

    @BeforeEach
    public void setupServer() {
        helloFunction = new HelloFunction();
    }

    @AfterEach
    public void stopServer() {
        if (helloFunction != null) {
            helloFunction.getApplicationContext().close();
        }
    }

    @Test
    public void testHandler() {
        HelloBean helloBean = new HelloBean();
        helloBean.setName("Goda");
        String functionReturn = helloFunction.execute(helloBean);
        assertEquals("Hello Goda (v2 - Using MicronautRequestHandler)", functionReturn);
    }
}
