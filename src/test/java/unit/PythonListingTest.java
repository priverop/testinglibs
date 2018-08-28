package unit;

import listing.PythonListing;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PythonListingTest {

    private static final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/python/";
    private final String REPORTS_FOLDER = "/testList/";

    private final String TESTNAME1 = "test_isupper (test.TestStringMethods)";
    private final String TESTNAME2 = "test_split (test.TestStringMethods)";
    private final String TESTNAME3 = "test_upper (test.TestStringMethods)";
    private final String TESTNAME4 = "test_isupper (test2.TestStringMethods)";
    private final String TESTNAME5 = "test_split (test2.TestStringMethods)";
    private final String TESTNAME6 = "test_upper (test2.TestStringMethods)";

    private static PythonListing listingObject;

    @BeforeAll
    static void init(){
        listingObject = new PythonListing(PROJECT_ABS_PATH);
        listingObject.executeListingScript();
    }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(PROJECT_ABS_PATH + REPORTS_FOLDER), listingObject.getTestsDirectory(), "Get TestList Directory (FILE)");
    }

    @Test
    void getListFromFile(){
        List listFromFile = new ArrayList<String>();
        listFromFile.add(TESTNAME1);
        listFromFile.add(TESTNAME2);
        listFromFile.add(TESTNAME3);
        listFromFile.add(TESTNAME4);
        listFromFile.add(TESTNAME5);
        listFromFile.add(TESTNAME6);
        assertEquals(listFromFile, listingObject.getReportsNamesFromFile("/testList.txt"), "Get test list: 4 tests (TXT).");

    }

    @Test
    void getList() {
        List testList = new ArrayList<String>();
        testList.add(TESTNAME1);
        testList.add(TESTNAME2);
        testList.add(TESTNAME3);
        testList.add(TESTNAME4);
        testList.add(TESTNAME5);
        testList.add(TESTNAME6);
        assertEquals(testList, listingObject.getReportsName_filter(true), "Get test list: 4 tests (TXT).");
    }
}
