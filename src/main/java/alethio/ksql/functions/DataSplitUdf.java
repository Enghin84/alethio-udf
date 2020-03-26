package alethio.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UdfDescription(
        name = "datasplit",
        description = "Split string",
        version = "0.1.0",
        author = "Alethio"
)

public class DataSplitUdf {
    @Udf(description = "Split string")
    public String[] datasplit(
            @UdfParameter(value = "source", description = "topic string value")
            final String source
    ) {
        if (source == null) {
            return null;
        }

        String s = source.replaceFirst("^0x", "");
        if (s.length() < 64) {
            return null;
        }

        return splitToNChar(source, 64);
    }

    protected static String[] splitToNChar(String text, int size) {
        List<String> parts = new ArrayList<>();

        int length = text.length();
        for (int i = 0; i < length; i += size) {
            parts.add(text.substring(i, Math.min(length, i + size)));
        }
        return parts.toArray(new String[0]);
    }
}
