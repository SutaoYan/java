package junit;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AssertTests {
    @Test @Ignore
    public void testAssertArrayEquals () {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }

    @Test
    public void testAssertEquals () {
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void testAssertFalse () {
        assertFalse("failure - should be false", false);
    }

    @Test
    public void testAssertNotNull () {
        assertNotNull("should not be null", new Object());
    }

    @Test
    public void testAssertNotSame () {
        assertNotSame("should not be same object", new Object(), new Object());
    }

    @Test
    public void testAssertNull () {
        assertNull("should be null", null);
    }

    @Test
    public void testAssertSame () {
        Integer aNumber = 768;
        assertSame("should be same", aNumber, aNumber);
    }

    @Test
    public void testAssertThatBothContainsString () {
        assertThat("albumen", both(containsString("a")).and(containsString("b")));
    }

    @Test
    public void testAssertThatHasItems () {
        assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
    }

    @Test
    public void testAssertThatEveryItemContainsString () {
        assertThat(Arrays.asList("fun", "ban", "net"), everyItem(containsString("n")));
    }

    @Test
    public void testAssertThatHamcrestCoreMathers () {
        assertThat("good", allOf(equalTo("good"), startsWith("good")));
        assertThat("good", not(allOf(equalTo("bad"), startsWith("bad"))));
        assertThat("good", anyOf(equalTo("bad"), startsWith("good")));
        assertThat(7, not(CombinableMatcher.<Integer>either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }
    @Test
    public void testAssertTrue () {
        assertTrue("failure - should be true", true);
    }

}
