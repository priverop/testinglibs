package unit;

// JUNIT

import listing.TapeListing;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// JAVA

public class TapeListingTest {

    private static final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/tape/";
    private static final String CURRENT_PROJECT_ABS_PATH = "/Users/nexmaniosis/testinglibs";
    private final String TESTS_FOLDER = "/test/";

    private final ArrayList<String> testsList = new ArrayList<String>(Arrays.asList("test-wrapper",
            "array", "asserts", "double", "fail", "ok", "second", "too_few", "a", "b", "test-a", "test-b"));

    private static TapeListing listingObject;

    @BeforeAll
    static void init(){ listingObject = new TapeListing(PROJECT_ABS_PATH); }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(PROJECT_ABS_PATH + TESTS_FOLDER), listingObject.getTestsDirectory(), "Get Mocha tests Directory (FILE)");
    }

    @Test
    void getList() {
        assertEquals(testsList, listingObject.getReportsName_filter(), "Get test list: 1 tests (JSON).");
    }

}
