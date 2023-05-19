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

import Dao.ClassDao;
import pojos.Teacher;

/**
 * Servlet implementation class subjectServlet
 */
@WebServlet("/classServlet")
public class classServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassDao classDao;

    public void init() {
    	classDao = new ClassDao();
    }
    
int id = 0;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public classServlet() {
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
                	listClass(request, response);
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
        Class className= classDao.getClass(id);
        request.setAttribute("className",className);
        RequestDispatcher dispatcher = request.getRequestDispatcher("class.jsp");
        dispatcher.forward(request, response);
    }
	
	 private void listClass(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Class> listClass = classDao.getAllClass();
			        request.setAttribute("listClass", listClass);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("class-list.jsp");
			        dispatcher.forward(request, response);
			    }
}
