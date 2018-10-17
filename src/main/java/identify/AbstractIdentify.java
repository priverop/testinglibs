package identify;

import com.sun.org.apache.xpath.internal.operations.Bool;

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

    protected static File keyFile;
    protected static String KEYFILENAME;

    /**
     * Class constructor.
     * @param project_path - will be used to compose the Key File path
     * @param keyFileName
     */

    public AbstractIdentify(String project_path, String keyFileName){
        KEYFILENAME = keyFileName;
        keyFile = new File(project_path + KEYFILENAME);
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
