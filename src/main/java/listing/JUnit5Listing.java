package listing;

/**
 * Created by nexmaniosis on 12/10/17.
 */
public class JUnit5Listing extends AbstractListing{

    private static final String TESTS_FOLDER = "/target/surefire-reports/";
    private static final String TESTS_EXTENSION = "xml";

    public JUnit5Listing(String projectPath){
        super(projectPath, TESTS_FOLDER, TESTS_EXTENSION);
    }

}
