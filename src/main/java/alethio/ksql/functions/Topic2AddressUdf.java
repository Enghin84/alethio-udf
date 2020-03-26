package alethio.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(
        name = "topic2address",
        description = "Extract address from topic",
        version = "0.1.0",
        author = "Alethio"
)
public class Topic2AddressUdf {
    @Udf(description = "Extract address from topic")
    public String topic2address(
            @UdfParameter(value = "source", description = "topic string value")
            final String source
    ) {
        if (source == null) {
            return null;
        }

        String s = source.replaceFirst("^0x", "");
        if (s.length() < 24) {
            return null;
        }
        return s.substring(24);
    }
}
