package alethio.ksql.functions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Topic2AddressUdfTests {
    @ParameterizedTest(name = "topic2address({0})= {1}")
    @CsvSource({
            ",",
            "\"\",",
            "0000,",
            "5152abf959f6564662358c2e52b702259b78bac5ee7842a0f01937e670efcc7d, 52b702259b78bac5ee7842a0f01937e670efcc7d"
    })
    void topic2address(final String source, final String expectedResult) {
        final Topic2AddressUdf topic2AddressUdf = new Topic2AddressUdf();
        final String actualResult = topic2AddressUdf.topic2address(source);
        assertEquals(expectedResult, actualResult, "Expected " + expectedResult + " but got "+actualResult);
    }
}
