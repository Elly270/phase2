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

import Dao.SubjectsDao;
import pojos.Subject;

/**
 * Servlet implementation class subjectServlet
 */
@WebServlet("/subjectServlet")
public class subjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SubjectsDao subjectDao;

    public void init() {
    	subjectDao = new SubjectsDao();
    }
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subjectServlet() {
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
                	listSubject(request, response);
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
		Subject subject = subjectDao.getSubject(id);
        request.setAttribute("subject",subject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("subject.jsp");
        dispatcher.forward(request, response);
    }
	
	 private void listSubject(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Subject > listSubject = subjectDao.getAllSubject();
			        request.setAttribute("listSubject", listSubject);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("subject-list.jsp");
			        dispatcher.forward(request, response);
			    }
}
