package listing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 * Created by nexmaniosis on 12/10/17.
 */
public class JUnit5Listing {

    private final String REPORTS_FOLDER = "/target/surefire-reports/";

    private File reportsDirectory;

    public JUnit5Listing(String project_path){
        reportsDirectory = new File( project_path + REPORTS_FOLDER);
    }

    public File getReportsDirectory() {
        return reportsDirectory;
    }

    public File[] getReports_no_filter(File reportsFolder) {
        return reportsFolder.listFiles();
    }

    public List getReportsName_filter() {

        List testList = new ArrayList<String>();

        for(File f: this.getReports_no_filter(this.getReportsDirectory())){
            if(isXML(f)) testList.add(filterName(extractName(f)));
        }

        return testList;
    }

    private static String extractName(File f){
        return f.getName();
    }
    private static Boolean isXML(File f){ return FilenameUtils.getExtension(f.getName()).equals("xml"); }
    private static String filterName(String n){ return FilenameUtils.removeExtension(n); }
}
