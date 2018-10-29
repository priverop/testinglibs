package listing;

public class TapeListing extends AbstractListing{

    private static final String TESTS_FOLDER = "/test/";
    private static final String TESTS_EXTENSION = "js";

    public TapeListing(String projectPath){
        super(projectPath, TESTS_FOLDER, TESTS_EXTENSION);
    }
    
}