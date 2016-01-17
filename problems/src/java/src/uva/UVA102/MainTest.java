package uva.UVA102;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Matt on 1/17/2016.
 */
public class MainTest {

    public static void main(String[] args) {
        testPermutations();
    }

    public static void testPermutations() {
        List<String> expected = Arrays.asList("BCG", "BGC", "CBG", "CGB", "GBC", "GCB");
        List<String> actual = Main.generatePermutations("BCG");
        Assert.assertEquals(6, actual.size());
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }

    }
}
