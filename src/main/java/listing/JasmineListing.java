package listing;


public class JasmineListing extends AbstractListing{

    private static final String TESTS_FOLDER = "/spec/";
    private static final String TESTS_EXTENSION = "js";

    public JasmineListing(String project_path){
        super(project_path, TESTS_FOLDER, TESTS_EXTENSION);
    }


}