package in.co.rays.ctl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.dto.UserDTO;
import in.co.rays.model.UserModel;
@WebServlet ("/UserCtl")
public class UserCtl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int id=Integer.parseInt(req.getParameter("edit"));
	System.out.println(id);
	UserModel  model=new UserModel();
	UserDTO userData =model.findByPk(id);
	RequestDispatcher rd=req.getRequestDispatcher("UserView.jsp");
	req.setAttribute("userData", userData);
	rd.forward(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDTO dto=new UserDTO();
		dto.setId(Integer.parseInt(req.getParameter("id")));
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String loginId=req.getParameter("loginId");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLoginId(loginId);
		dto.setPassword(password);
		dto.setDob(new Date());
		dto.setAddress(address);
		UserModel model=new UserModel();
		model.update(dto);
	
		RequestDispatcher rd=req.getRequestDispatcher("UserView.jsp");
		req.setAttribute("userData", dto);
		req.setAttribute("updateMsg", "User Updated Successfully");
		rd.forward(req, resp);
	}

}
