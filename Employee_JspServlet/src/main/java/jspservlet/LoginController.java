package jspservlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		StudentCrud crud=new StudentCrud();
		try {
			String dbPassword=crud.login(email);
//			PrintWriter out=res.getWriter();
			if(dbPassword!=null) {
				if (dbPassword.equals(password)) {
//					out.print("Login Success");
					List<Student> student=crud.getAllData();
					req.setAttribute("list", student);
					req.getRequestDispatcher("HomePage.jsp").forward(req, res);
				} else {
//					out.print("Invalid password");
					req.setAttribute("invalid", "Invalid Password");
					RequestDispatcher dispatcher= req.getRequestDispatcher("login.jsp");
					dispatcher.forward(req, res);
				}
			}
			else {
//				out.print("Invalid Mail");
				req.setAttribute("register", "User is not registered. Please register");
				RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
				dispatcher.forward(req, res);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

