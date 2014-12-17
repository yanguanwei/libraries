package young.algorithm.compression;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-21
 */
public class VariableBytecode {
    public static byte[] encode(int[] numbers) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for (int num : numbers) {
            out.write((num & 127) + 128);
            num = num >>> 7;
            while (num > 0) {
                out.write(num & 127);
                num = num >>> 7;
            }
        }

        byte[] bytes = out.toByteArray();
        int len = bytes.length;
        byte[] encoded = new byte[len];
        for (int i=0; i<len; i++) {
            encoded[i] = bytes[len-i-1];
        }

        return encoded;
    }

    public static int[] decode(byte[] bytes) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        int num = 0;
        for (byte b : bytes) {
            int d = (int)b & 0xff;
            num = (num<<7) + d;
            if (d > 128) {
                num -= 128;
                arr.add(num);
                num = 0;
            }
        }

        int len = arr.size();
        int[] decoded = new int[len];
        for (int i=0; i<len; i++) {
            decoded[i] = arr.get(len-i-1);
        }

        return decoded;
    }
}
