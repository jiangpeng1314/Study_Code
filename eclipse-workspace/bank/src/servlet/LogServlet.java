package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LogService;
import service.impl.LogServiceImpl;

/**
 * Servlet implementation class LogServlet
 */
@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
	private LogService logservice=new LogServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageSize=3;
		int pageNumber=1;
		String pageNumberStr=req.getParameter("pageNumber");
		if(pageNumberStr!=null&&pageNumberStr!="") {
			pageNumber=Integer.parseInt(pageNumberStr);
		}
		req.setAttribute("pageInfo", logservice.show(pageNumber, pageSize));
		req.getRequestDispatcher("/log.jsp").forward(req, resp);
	}
}
