package jspservlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int id=Integer.parseInt(req.getParameter("id"));
	StudentCrud crud=new StudentCrud();
	try {
		int result=(int)crud.delete(id);
		if(result!=0) {
			
			List<Student> student=crud.getAllData();
			req.setAttribute("list", student);
			req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
		;
		}
		else {
			req.setAttribute("msg", "Id is not present in the database");
			req.getRequestDispatcher("delete.jsp").forward(req, resp);
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
