package junit;

import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ListTests {
    private List<String> strings;

    @BeforeClass
    public static void initialization () {
        System.out.println("Should run only once");
    }

    @AfterClass
    public static void finish() {
        System.out.println("Cleaning up ater all tests have run");
    }
    
    @Before
    public void setUp () {
        System.out.println("inside setUp");
        strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
    }

    @Test
    public void defaultListHasCorrectSize() {
        assertEquals("default list should have six strings", 6, strings.size());
        strings = null;

    }

    @Test
    public void defaultListHasSixStrings () {
        assertThat(strings.size(), is(6));
    }

    @After
    public void cleanUp () {
        System.out.println("Cleaning up...");
    }
}
