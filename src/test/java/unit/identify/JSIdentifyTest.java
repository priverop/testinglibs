package unit.identify;

import identify.JSIdentify;
import unit.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSIdentifyTest {

    private static final String JSON_FILE = "package.json";

    private static JSIdentify identifyObject;

    @BeforeAll
    static void init(){
        TestUtils.setProjectAbsPath(JSON_FILE);

        identifyObject = new JSIdentify(TestUtils.getProjectAbsPath());
    }

    @Test
    void getJson() {
        assertEquals(new File(TestUtils.getProjectAbsPath() + File.separator + JSON_FILE), identifyObject.getKeyFile(), "Get package.json");
    }

    @Test
    void getMocha() {
        assertEquals("mocha", identifyObject.getMochaArtefactID(), "Find name: mocha");
    }

    @Test
    void checkJson() {
        assertEquals(true, identifyObject.checkKeyFile(), "CheckJson returns true");
    }

    @Test
    void checkMocha() {
        assertEquals(true, identifyObject.checkMocha(), "CheckMocha returns true");
    }
}
