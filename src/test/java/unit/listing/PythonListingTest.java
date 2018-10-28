package unit.listing;

import listing.PythonListing;
import unit.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PythonListingTest {

    private static final String PROJECT_FOLDER = "python";
    private static final String TESTS_FOLDER = "testList";

    private final int NUM_TESTS = 6;

    private static PythonListing listingObject;

    @BeforeAll
    static void init(){
        TestUtils.setProjectAbsPath(PROJECT_FOLDER);
        listingObject = new PythonListing(TestUtils.getProjectAbsPath());
    }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(TestUtils.getProjectAbsPath() + File.separator + TESTS_FOLDER), listingObject.getTestsDirectory(), "Get TestList Directory (FILE)");
    }

    @Test
    void getListFromFile(){
        assertEquals(NUM_TESTS, listingObject.getReportsNamesFromFile("/testList.txt").size(), "Get test list: 6 tests (TXT).");

    }

    @Test
    void getList() {
        assertEquals(NUM_TESTS, listingObject.getReportsName_filter(true).size(), "Get test list: 6 tests (TXT).");
    }
}
