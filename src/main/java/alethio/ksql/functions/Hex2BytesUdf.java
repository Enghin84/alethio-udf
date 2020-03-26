package alethio.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@UdfDescription(
        name = "hex2bytes",
        description = "Convert hex2bytes",
        version = "0.1.0",
        author = "Alethio"
)

public class Hex2BytesUdf {
    @Udf(description = "Convert hex2bytes")
    public byte[] hex2bytes(
            @UdfParameter(value = "source", description = "topic string value")
            final String source
    ) {
        if (source == null) {
            return null;
        }

        return new BigInteger(source,16).toByteArray();
    }
}
