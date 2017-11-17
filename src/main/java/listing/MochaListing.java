package listing;


public class MochaListing extends AbstractListing{

    private static final String TESTS_FOLDER = "/test/";
    private static final String TESTS_EXTENSION = "js";

    public MochaListing(String project_path){
        super(project_path, TESTS_FOLDER, TESTS_EXTENSION);
    }


}
