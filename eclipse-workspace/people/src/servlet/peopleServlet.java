package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.People;
import service.PeopleService;
import service.impl.PeopleServiceImpl;

/**
 * Servlet implementation class peopleServlet
 */
@WebServlet("/p")
public class peopleServlet extends HttpServlet {
	private PeopleService peopleService=new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<People> list=peopleService.show();
		req.setAttribute("list", list);
		System.out.println("list value"+list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
	
}
