package jspservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")

public class SignupController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			int result=crud.signUp(student);
//			PrintWriter out=res.getWriter();
			
			if (result!=0) {
//				out.print("Registration Successful");
				req.setAttribute("message", "SignUp Successful. Please Login");
				req.getRequestDispatcher("Login.jsp").forward(req, res);
				
			} else {
//				out.print("Registration Failed");
				req.getRequestDispatcher("Signup.jsp").forward(req, res);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

