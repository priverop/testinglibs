package unit.identify;

import identify.PythonIdentify;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PythonIdentifyTest {

    private final String EXTENSION = ".py";
    private static final String PROJECT_ABS_PATH ="/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/python/";

    private static PythonIdentify identifyObject;

    @BeforeAll
    static void init(){
        identifyObject = new PythonIdentify(PROJECT_ABS_PATH);
    }

    @Test
    void getJson() {
        assertEquals(new File(PROJECT_ABS_PATH), identifyObject.getDir(), "Get python dir");
    }

    @Test
    void getExtension() {
        assertEquals(EXTENSION, identifyObject.getExtension(), "PY extension");
    }

    @Test
    void checkPython() {
        assertEquals(true, identifyObject.checkPython(), "checkPython returns true");
    }

}
