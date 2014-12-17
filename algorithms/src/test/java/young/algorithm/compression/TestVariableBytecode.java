package young.algorithm.compression;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-21
 */
public class TestVariableBytecode {

    public byte[] encoded() {
        return new byte[] {(byte)1, (byte)129, (byte)192, (byte)129};
    }

    public int[] decoded() {
        return new int[] {1, 64, 129};
    }

    @Test
    public void testEncode() {
        int[] numbers = decoded();
        byte[] expected = encoded();
        byte[] encoded = VariableBytecode.encode(numbers);
        System.out.printf("Compression ratio: %.3f\n", encoded.length * 1.0 / (numbers.length*4));
        Assert.assertArrayEquals(encoded, expected);
    }

    @Test
    public void testDecode() {
        byte[] bytes = encoded();
        int[] expected = decoded();
        int[] decoded = VariableBytecode.decode(bytes);
        Assert.assertArrayEquals(decoded, expected);
    }
}
