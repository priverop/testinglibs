package listing;

import utilities.ResourceManager;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class PythonListing extends AbstractListing {

    private static final String TESTS_FOLDER = "/testList/";
    private static final String TESTS_EXTENSION = "txt";
    private static final String SCRIPT_NAME = "discover.py";

    public PythonListing(String projectPath){
        super(projectPath, TESTS_FOLDER, TESTS_EXTENSION);
    }

    public void createListingScript(){
        String scriptPath = ResourceManager.getResourcePath(SCRIPT_NAME) + File.separator + SCRIPT_NAME;
        try {
            FileUtils.copyFileToDirectory(new File(scriptPath),
                    new File(this.getProjectPath()));
        }
        catch (IOException e){
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    public void executeListingScript(){
        ProcessBuilder pb = new ProcessBuilder("python3", SCRIPT_NAME);
        pb.directory(this.getTestsDirectory());
        try {
            pb.start();
        }
        catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

}
