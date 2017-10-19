package urjc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nexmaniosis on 12/10/17.
 */
public class JUnitListing {

    private final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/junit5-vanilla-maven/";
    private final String REPORTS_FOLDER = "target/surefire-reports/";

    private File reportsDirectory;

    private File[] reports_nofilter;

    private File[] reports_filter;

    private List reports_filter_name;

    /*

     */
    private void setReportsDirectory(String path){
        reportsDirectory = new File(path);
    }

    /*
        Get every file on the folder. No filter.
     */

    private void setFiles(File folder){
        reports_nofilter = folder.listFiles();
    }

    public File getReportsDirectory() {
        return reportsDirectory;
    }

    public File[] getReportsNoFilter() {
        return reports_nofilter;
    }

    /*

    */

    private void setTestList(){

        List testList = new ArrayList<String>();

        for(File f: getReportsNoFilter()){
            testList.add(extractName(f));
        }

        reports_filter_name = testList;

    }

    public List getReports_filter_name() {
        return reports_filter_name;
    }

    private String extractName(File f){
        return f.getName();
    }
}
