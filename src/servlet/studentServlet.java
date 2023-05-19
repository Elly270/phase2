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

import Dao.StudentDao;
import pojos.Student;
import pojos.Subject;

/**
 * Servlet implementation class subjectServlet
 */
@WebServlet("/subjectServlet")
public class studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;

    public void init() {
    	studentDao = new StudentDao();
    }
    
int id = 0;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentServlet() {
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
                	listStudent(request, response);
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
       Student student = studentDao.getStudent(id);
        request.setAttribute("student",student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
        dispatcher.forward(request, response);
    }
	
	 private void listStudent(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Student > listStudent = studentDao.getAllStudent();
			        request.setAttribute("listStudent", listStudent);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
			        dispatcher.forward(request, response);
			    }
}
