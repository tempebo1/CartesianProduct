import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import java.util.Collections;

public class CartesianProduct2Test {

    @Test
    public void testEmptyString() {
        assertEquals(Collections.emptyList(), Main.CartesianProduct2(""));
    }

    @Test
    public void testOneDigit3PossibleChars() {
        List<String> output = Arrays.asList("t", "u", "v");
        assertEquals(3, Main.CartesianProduct2("8").size());
        assertEquals(output, Main.CartesianProduct2("8"));
        output = Arrays.asList("g", "h", "i");
        assertEquals(output, Main.CartesianProduct2("4"));
    }

    @Test
    public void testOneDigit4PossibleChars() {
        List<String> output = Arrays.asList("p", "q", "r", "s");
        assertEquals(4, Main.CartesianProduct2("7").size());
        assertEquals(output, Main.CartesianProduct2("7"));
    }

    @Test
    public void testFirstDigit() {
        List<String> output = Arrays.asList("a", "b", "c");
        assertEquals(output, Main.CartesianProduct2("2"));
    }

    @Test
    public void testLastDigit() {
        List<String> output = Arrays.asList("w", "x", "y", "z");
        assertEquals(output, Main.CartesianProduct2("9"));
    }

    @Test
    public void testMoreThanOneDigitOrdered() {
        List<String> output = Arrays.asList("ad", "ae", "af", "bd", "be", "bf",
                "cd", "ce", "cf");
        assertEquals(output, Main.CartesianProduct2("23"));
        output = Arrays.asList("adg", "adh", "adi", "aeg", "aeh", "aei", "afg",
                "afh", "afi", "bdg", "bdh", "bdi",
                "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh",
                "cei", "cfg", "cfh",
                "cfi");
        assertEquals(output, Main.CartesianProduct2("234"));
    }

    @Test
    public void testMoreThanOneDigitNotOrdered() {
        List<String> output = Arrays.asList("ad", "ae", "af", "bd", "be", "bf",
                "cd", "ce", "cf");
        List<String> ordered = Main.CartesianProduct2("32");
        Main.sortEachElement(ordered);
        assertEquals(output, ordered);
        output = Arrays.asList("adg", "adh", "adi", "aeg", "aeh", "aei", "afg",
                "afh", "afi", "bdg", "bdh", "bdi",
                "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh",
                "cei", "cfg", "cfh",
                "cfi");
        ordered = Main.CartesianProduct2("432");
        Main.sortEachElement(ordered);
        assertEquals(output, ordered);
    }

    @Test
    public void testInvalidLetter() throws Exception {
        assertThrows(Exception.class, () -> {
            Main.CartesianProduct2("#");
        });
    }

    @Test
    public void testInvalidNumber() throws Exception {
        try {

            Main.CartesianProduct2("0");
        } catch (Exception e) {

        }
    }

}
