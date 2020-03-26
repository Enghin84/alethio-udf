package alethio.ksql.functions;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Hex2BytesUdfTests {
    public static  Map<String, byte[]> tests;
    static {
        tests = new HashMap<>();
        tests.put("a33e3ef4", new byte[]{0, -93, 62, 62, -12});
    }
    @Test
    void topic2intString() {
        Hex2BytesUdf h = new Hex2BytesUdf();
        tests.forEach((source, expected) -> assertArrayEquals(expected, h.hex2bytes(source)));
    }
}
