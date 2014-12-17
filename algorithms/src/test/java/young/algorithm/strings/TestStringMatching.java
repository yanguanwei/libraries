package young.algorithm.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-22
 */
public class TestStringMatching {

    @Test
    public void testKMP() {
        String pattern = "abab";
        String str = "abacabbabbbadbababc";

        int pos = StringMatching.kmp(str, pattern);
        Assert.assertEquals(14, pos);
    }

    @Test
    public void testBF() {
        String pattern = "abab";
        String str = "abacabbabbbadbababcababc";

        int pos = StringMatching.bf(str, pattern);
        Assert.assertEquals(14, pos);
    }
}
