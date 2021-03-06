package identify;

import java.io.File;

/**
 * AbstractIdentify is the father class of the Identify
 * feature of testinglibs. Which allows to identify which
 * language is your project using by finding the key file:
 * POM.XML (Java), PACKAGE.JSON (JS)...
 *
 * An AbstractIdentify object has two attributes:
 * <ul>
 * <li>File: Key file path.
 * <li>String: Key file name.
 * </ul>
 *
 * @author      Priverop
 */

public abstract class AbstractIdentify {

    private File keyFile;

    /**
     * Class constructor.
     * @param projectPath - will be used to compose the Key File path.
     * @param fileName - Name of the Key File.
     */

    AbstractIdentify(String projectPath, String fileName){
        keyFile = new File(projectPath + fileName);
    }

    /**
     * @return File key File
     */

    public File getKeyFile(){
        return keyFile;
    }

    /**
     * @return Boolean <code>true</code> if Key File exists and is not a directory.
     * <code>false</code> otherwise.
     */

    public Boolean checkKeyFile(){
        return getKeyFile().exists() && !getKeyFile().isDirectory();
    }

}
