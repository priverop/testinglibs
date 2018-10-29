package utilities;

public class ProjectPaths {

    private String projectPath;

    public ProjectPaths(){
        projectPath = System.getProperty("user.dir");
    }

    public String getProjectPath() {
        return projectPath;
    }
}
