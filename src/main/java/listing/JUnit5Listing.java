package listing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 * Created by nexmaniosis on 12/10/17.
 */
public class JUnit5Listing extends AbstractListing{

    private static final String TESTS_FOLDER = "/target/surefire-reports/";
    private static final String TESTS_EXTENSION = "xml";

    public JUnit5Listing(String project_path){
        super(project_path, TESTS_FOLDER, TESTS_EXTENSION);
    }

}
