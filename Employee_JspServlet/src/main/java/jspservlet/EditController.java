package jspservlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String branch=req.getParameter("branch");
		long phone= Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setBranch(branch);
		student.setPhone(phone);
		student.setEmail(email);
		student.setPassword(password);
		
		StudentCrud crud=new StudentCrud();
		try {
			int result=crud.updateStudent(student);
			if(result!=0) {
				List<Student> students=crud.getAllData();
				req.setAttribute("list", students);
				req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
