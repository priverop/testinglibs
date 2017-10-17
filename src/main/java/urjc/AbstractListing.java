package urjc;

import java.io.File;
import java.util.List;

public abstract class AbstractListing {

    public abstract File getDirectory();

    public abstract File[] getFiles(File folder);

    public abstract List getTestList();

    protected abstract String extractName(File f);

}
