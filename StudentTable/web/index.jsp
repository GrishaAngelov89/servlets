<%@ page import="java.util.List" %>
<%@ page import="students.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Student Table</title>
  </head>
  <body>
        <form method="get" action="StudentInfoServlet">
            <input type="submit" value="Generate Table">
        </form>

        <%
            if(request.getAttribute("studentList") != null){
        %>
                <table border="1px solid" style="text-align: center">
                <tr>
                    <th>Name</th>
                    <th>Major</th>
                    <th>Student ID</th>
                </tr>
        <%
                List<Student> students = (List<Student>) request.getAttribute("studentList");
                for(Student student : students){
        %>
                <tr>
                  <td><%=student.getName()%></td>
                  <td><%=student.getMajor()%></td>
                  <td><%=student.getStudentID()%></td>
                </tr>
        <%
                }
        %>
                </table>

                    <br/><br/><br/>

                    <%--print using JSTL--%>
                    <table border="1px solid" style="text-align: center">
                        <tr>
                            <th>Name</th>
                            <th>Major</th>
                            <th>Student ID</th>
                        </tr>
                        <c:forEach var="student" items="${studentList}">
                            <tr>
                                <td>${student.name}</td>
                                <td>${student.major}</td>
                                <td>${student.studentID}</td>
                            </tr>

                        </c:forEach>
                    </table>
         <%
              }
         %>
  </body>
</html>