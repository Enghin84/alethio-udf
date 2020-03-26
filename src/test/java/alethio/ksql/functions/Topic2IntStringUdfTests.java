package alethio.ksql.functions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Topic2IntStringUdfTests {
    @ParameterizedTest(name = "topic2int_string({0})= {1}")
    @CsvSource({
            ",",
            "\"\",",
            "0000,",
            "00000000000000000000000000000000000000000000000000000000000991ab, 627115"
    })
    void topic2intString(final String source, final String expectedResult) {
        final Topic2IntStringUdf t = new Topic2IntStringUdf();
        final String actualResult = t.topic2intString(source);
        assertEquals(expectedResult, actualResult);
    }
}
