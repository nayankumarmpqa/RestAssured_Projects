package pojo;

public class GetCourseResponsePojoClass {


    private String url;
    private String services;
    private String expertise;
    private String instructor;
    private String linkedin;

    private CoursesChildJsonClass Courses;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public CoursesChildJsonClass getCourses() {
        return Courses;
    }

    public void setCourses(CoursesChildJsonClass courses) {
        Courses = courses;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }


}
