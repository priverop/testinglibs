package listing;

public class TestNGListing extends AbstractListing{

    private static final String TESTS_FOLDER = "/target/surefire-reports/junitreports/";
    private static final String TESTS_EXTENSION = "xml";

    public TestNGListing(String project_path){
        super(project_path, TESTS_FOLDER, TESTS_EXTENSION);
    }
}
