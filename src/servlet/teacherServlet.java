package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TeacherDao;
import pojos.Student;
import pojos.Teacher;

/**
 * Servlet implementation class subjectServlet
 */
@WebServlet("/teacherServlet")
public class teacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao;

    public void init() {
    	teacherDao = new TeacherDao();
    }
    
int id = 0;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                
                case "/get":
                	getById(request, response);
                    break;
                default:
                	listTeacher(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void getById(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Teacher teacher= teacherDao.getTeacher(id);
        request.setAttribute("teacher",teacher);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher.jsp");
        dispatcher.forward(request, response);
    }
	
	 private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Teacher> listTeacher = teacherDao.getAllTeacher();
			        request.setAttribute("listTeacher", listTeacher);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-list.jsp");
			        dispatcher.forward(request, response);
			    }
}
