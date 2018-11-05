package listing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

public class PythonListing extends AbstractListing {

    private static final String TESTS_FOLDER = "/testList/";
    private static final String TESTS_EXTENSION = "txt";
    private static final String SCRIPT_NAME = "discover.py";

    public PythonListing(String projectPath){
        super(projectPath, TESTS_FOLDER, TESTS_EXTENSION);
    }

    public void createListingScript(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.getProjectPath()+SCRIPT_NAME))){
            writer.write("import unittest");
            writer.newLine();
            writer.write("import sys");
            writer.newLine();
            writer.write("import os.path");
            writer.newLine();
            writer.newLine();

            writer.write("testsObject = unittest.TestLoader().discover(\'.\')");
            writer.newLine();
            writer.newLine();

            writer.write("testListFile = (\'./testList/testList.txt\')");
            writer.newLine();
            writer.write("os.makedirs(os.path.dirname(testListFile), exist_ok=True)");
            writer.newLine();
            writer.write("sys.stdout = open(testListFile, \'w\')");
            writer.newLine();
            writer.write("for i in testsObject:");
            writer.newLine();
            writer.write("  list = i._tests");
            writer.newLine();
            writer.write("  for e in list:");
            writer.newLine();
            writer.write("    testsName = e._tests");
            writer.newLine();
            writer.write("    for t in testsName:");
            writer.newLine();
            writer.write("    print(t)");
            writer.newLine();

            writer.write("sys.stdout.close()");
            writer.newLine();

        }
        catch(IOException e){
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    public void executeListingScript(){
        ProcessBuilder pb = new ProcessBuilder("python3", SCRIPT_NAME);
        pb.directory(this.getTestsDirectory());
        try {
            pb.start();
        }
        catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

}
