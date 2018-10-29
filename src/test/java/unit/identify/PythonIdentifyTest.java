package unit.identify;

import identify.PythonIdentify;
import unit.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PythonIdentifyTest {

    private static final String PY_FILE = "discover.py";
    private static final String PY_EXTENSION = ".py";

    private static PythonIdentify identifyObject;

    @BeforeAll
    static void init(){
        TestUtils.setProjectAbsPath(PY_FILE);
        identifyObject = new PythonIdentify(TestUtils.getProjectAbsPath());
    }

    @Test
    void getDir() {
        assertEquals(new File(TestUtils.getProjectAbsPath()), identifyObject.getDir(), "Get python dir");
    }

    @Test
    void getExtension() {
        assertEquals(PY_EXTENSION, identifyObject.getExtension(), "PY extension");
    }

    @Test
    void checkPython() {
        assertEquals(true, identifyObject.checkPython(), "checkPython returns true");
    }

}
