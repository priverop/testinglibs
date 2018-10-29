package listing;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;
import java.util.logging.Logger;
import java.util.logging.Level;

public abstract class AbstractListing {

    static final Logger LOGGER = Logger.getLogger( AbstractListing.class.getName() );

    private File testsDirectory;
    private String testsExtension;

    AbstractListing(String projectPath, String testFolder, String testsExtension){
        this.testsExtension = testsExtension;
        testsDirectory = new File (projectPath + File.separator + testFolder);
    }

    public File getTestsDirectory(){ return testsDirectory; }

    private Collection<File> getFiles(File folder){
        return FileUtils.listFiles(folder, null, true);
    }

    public List getFilteredReports(boolean uniqueFile) {

        List<String> testList = new ArrayList<>();

        for (File f : this.getFiles(this.getTestsDirectory())) {
            if(uniqueFile)
                testList = this.getReportsNamesFromFile(extractName(f));
            else if (hasExtension(f, this.testsExtension))
                testList.add(filterName(extractName(f)));
        }

        return testList;
    }

    public List<String> getReportsNamesFromFile(String fileName){
        List lines = Collections.emptyList();
        try
        {
            lines = Files.readAllLines(Paths.get(getTestsDirectory()+"/"+fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return lines;
    }

    private static String extractName(File f){
        return f.getName();
    }
    private static String filterName(String n){ return FilenameUtils.removeExtension(n); }
    private static Boolean hasExtension(File f, String extension){ return FilenameUtils.getExtension(f.getName()).equals(extension); }
}
