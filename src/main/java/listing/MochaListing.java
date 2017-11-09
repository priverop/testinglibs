package listing;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MochaListing{

    private final String TESTS_FOLDER = "/test/"; // Mocha tests directory by default

    private File testsDirectory;

    public MochaListing(String project_path){
        testsDirectory = new File( project_path + TESTS_FOLDER);
    }

    public File getReportsDirectory() {
        return testsDirectory;
    }

    public File[] getReports_no_filter(File reportsFolder) {
        return reportsFolder.listFiles();
    }

    public List getReportsName_filter() {

        List testList = new ArrayList<String>();

        for(File f: this.getReports_no_filter(this.getReportsDirectory())){
            if(isJSON(f)) testList.add(filterName(extractName(f)));
        }

        return testList;
    }

    private static String extractName(File f){
        return f.getName();
    }
    private static Boolean isJSON(File f){ return FilenameUtils.getExtension(f.getName()).equals("js"); }
    private static String filterName(String n){ return FilenameUtils.removeExtension(n); }
}
