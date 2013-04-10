package students;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author grisha_angelov
 */
public class StudentInformationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Student> students = getStudentsFromFile("WEB-INF/students.txt");
        request.setAttribute("studentList", students);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private List<Student> getStudentsFromFile(String file) throws FileNotFoundException {
        List<Student> studentList = new ArrayList<Student>();
        String realPath = getServletContext().getRealPath(file);
        File studentFile = new File(realPath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(studentFile);
            while (scanner.hasNext()) {
                String[] studentData = scanner.nextLine().split(",");
                String name = studentData[0];
                String major = studentData[1];
                String id = studentData[2];
                studentList.add(new Student(name, major, id));
            }
        } finally {
            scanner.close();
        }
        return studentList;
    }
}
