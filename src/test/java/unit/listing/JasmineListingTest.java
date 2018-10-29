package unit.listing;

import listing.JasmineListing;
import unit.TestUtils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JasmineListingTest {

    private static final String PROJECT_FOLDER = "jasmine";
    private static final String TESTS_FOLDER = "spec";

    private final int NUM_TESTS = 2;

    private static JasmineListing listingObject;

    @BeforeAll
    static void init(){
        TestUtils.setProjectAbsPath(PROJECT_FOLDER);

        listingObject = new JasmineListing(TestUtils.getProjectAbsPath());
    }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(TestUtils.getProjectAbsPath() + File.separator + TESTS_FOLDER), listingObject.getTestsDirectory(), "Get Jasmine tests Directory (FILE)");
    }

    @Test
    void getList() {
        assertEquals(NUM_TESTS, listingObject.getFilteredReports(false).size(), "Get test list: 1 tests (JSON).");
    }

}
