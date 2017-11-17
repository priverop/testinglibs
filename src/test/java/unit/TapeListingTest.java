package unit;

// JUNIT

import listing.TapeListing;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// JAVA

public class TapeListingTest {

    private static final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/tape/";
    private static final String CURRENT_PROJECT_ABS_PATH = "/Users/nexmaniosis/testinglibs";
    private final String TESTS_FOLDER = "/test/";

    private final String TESTNAME1 = "array";

    private static TapeListing listingObject;

    @BeforeAll
    static void init(){ listingObject = new TapeListing(PROJECT_ABS_PATH); }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(PROJECT_ABS_PATH + TESTS_FOLDER), listingObject.getTestsDirectory(), "Get Mocha tests Directory (FILE)");
    }

    @Test
    void getList() {
        List testList = new ArrayList<String>();
        testList.add(TESTNAME1);
        assertEquals(testList, listingObject.getReportsName_filter(), "Get test list: 1 tests (JSON).");
    }

}
