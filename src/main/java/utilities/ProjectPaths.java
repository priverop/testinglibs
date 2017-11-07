package utilities;

public class ProjectPaths {

    private String project_path;

    public ProjectPaths(){
        project_path = System.getProperty("user.dir");
    }

    public String getProject_path() {
        return project_path;
    }
}
