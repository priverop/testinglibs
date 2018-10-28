package unit.listing;

import listing.MochaListing;
import unit.TestUtils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class MochaListingTest {

    private static final String PROJECT_FOLDER = "mocha";
    private static final String TESTS_FOLDER = "test";

    private final String TESTNAME1 = "array";

    private static MochaListing listingObject;

    @BeforeAll
    static void init(){
        TestUtils.setProjectAbsPath(PROJECT_FOLDER);

        listingObject = new MochaListing(TestUtils.getProjectAbsPath());
    }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(TestUtils.getProjectAbsPath() + File.separator + TESTS_FOLDER), listingObject.getTestsDirectory(), "Get Mocha tests Directory (FILE)");
    }

    @Test
    void getList() {
        List testList = new ArrayList<String>();
        testList.add(TESTNAME1);
        assertEquals(testList, listingObject.getReportsName_filter(false), "Get test list: 1 tests (JSON).");
    }

}
