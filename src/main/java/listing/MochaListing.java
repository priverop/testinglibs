package listing;

import java.io.File;

public class MochaListing extends AbstractListing{

    private static final String TESTS_FOLDER = "/test/"; // Mocha tests directory by default
    private static final String TESTS_EXTENSION = "js";

    private File testsDirectory;

    public MochaListing(String project_path){
        super(project_path, TESTS_FOLDER, TESTS_EXTENSION);
    }


}
