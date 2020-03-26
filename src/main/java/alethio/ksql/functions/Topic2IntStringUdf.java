package alethio.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.math.BigInteger;

@UdfDescription(
        name = "topic2int_string",
        description = "Extract value from topic",
        version = "0.1.0",
        author = "Alethio"
)
public class Topic2IntStringUdf {
    @Udf(description = "Extract value from topic")
    public String topic2intString(
            @UdfParameter(value = "source", description = "topic string value")
            final String source
    ) {
        if (source == null || source.length() != 64) {
            return null;
        }
        BigInteger bigInt = new BigInteger(source, 16);

        if (bigInt.toString().length() > 38) {
            return null;
        }

        return bigInt.toString();
    }
}