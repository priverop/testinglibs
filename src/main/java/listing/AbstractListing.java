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

public abstract class AbstractListing {

    protected static String testsFolder;
    protected static File testsDirectory;
    protected static String testsExtension;

    public AbstractListing(String project_path, String test_folder, String tests_extension){
        testsFolder = test_folder;
        testsExtension = tests_extension;
        testsDirectory = new File (project_path + testsFolder);
    }

    public File getTestsDirectory(){ return testsDirectory; }

    public Collection<File> getFiles_no_filter(File folder){
        return FileUtils.listFiles(folder, null, true);
    }

    public List getReportsName_filter(boolean uniqueFile) {

        List testList = new ArrayList<String>();

        for (File f : this.getFiles_no_filter(this.getTestsDirectory())) {
            if(uniqueFile)
                testList = this.getReportsNamesFromFile(extractName(f));
            else if (hasExtension(f, testsExtension))
                testList.add(filterName(extractName(f)));
        }

        return testList;
    }

    public List getReportsNamesFromFile(String fileName){
        List lines = Collections.emptyList();
        try
        {
            lines = Files.readAllLines(Paths.get(getTestsDirectory()+"/"+fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return lines;
    }

    private static String extractName(File f){
        return f.getName();
    }
    private static String filterName(String n){ return FilenameUtils.removeExtension(n); }
    private static Boolean hasExtension(File f, String extension){ return FilenameUtils.getExtension(f.getName()).equals(extension); }
}
