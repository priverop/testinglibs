package unit.listing;

// JUNIT

import listing.JasmineListing;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// JAVA

public class JasmineListingTest {

    private static final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/jasmine/";
    private static final String CURRENT_PROJECT_ABS_PATH = "/Users/nexmaniosis/testinglibs";
    private final String TESTS_FOLDER = "/spec/";

    private final String TESTNAME1 = "SpecHelper";
    private final String TESTNAME2 = "PlayerSpec";

    private static JasmineListing listingObject;

    @BeforeAll
    static void init(){ listingObject = new JasmineListing(PROJECT_ABS_PATH); }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(PROJECT_ABS_PATH + TESTS_FOLDER), listingObject.getTestsDirectory(), "Get Jasmine tests Directory (FILE)");
    }

    @Test
    void getList() {
        List testList = new ArrayList<String>();
        testList.add(TESTNAME1);
        testList.add(TESTNAME2);
        assertEquals(testList, listingObject.getReportsName_filter(false), "Get test list: 1 tests (JSON).");
    }

}
