package listing;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class PythonListing extends AbstractListing {

    private static final String TESTS_FOLDER = "/testList/";
    private static final String TESTS_EXTENSION = "txt";
    private static final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/python/";
    private static final String SCRIPT_NAME = "discover.py";

    public PythonListing(String projectPath){
        super(projectPath, TESTS_FOLDER, TESTS_EXTENSION);
    }

    public void executeListingScript(){
        ProcessBuilder pb = new ProcessBuilder("python3", SCRIPT_NAME);
        pb.directory(new File(PROJECT_ABS_PATH));
        try {
            pb.start();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

}
