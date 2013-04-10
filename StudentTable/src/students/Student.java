package students;

/**
 * @author grisha_angelov
 */
public class Student {
    private String name;
    private String major;
    private String studentID;

    public Student(String name, String major, String studentID) {
        this.name = name;
        this.major = major;
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getStudentID() {
        return studentID;
    }
}
