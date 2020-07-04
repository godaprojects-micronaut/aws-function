package aws.function;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.goda.aws.bean.HelloBean;
import io.goda.aws.function.v2.HelloFunction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HelloFunctionTest {

    private static HelloFunction helloFunction;

    @BeforeAll
    public static void setupServer() {
        helloFunction = new HelloFunction();
    }

    @AfterAll
    public static void stopServer() {
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
