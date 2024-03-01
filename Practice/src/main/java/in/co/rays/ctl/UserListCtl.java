package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.dto.UserDTO;
import in.co.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int pageNo=1;
    int pageSize=10;
    UserDTO dto=new UserDTO();
    UserModel model=new UserModel();
    List list=model.search(dto, pageNo, pageSize);
	RequestDispatcher rd=req.getRequestDispatcher("UserListView.jsp");
	req.setAttribute("List", list);
	rd.forward(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int pageNo=1;
	int pageSize=10;
	String op=req.getParameter("operation");
	UserDTO dto=new UserDTO();
	dto.setFirstName((req.getParameter("firstName")));
	
	System.out.println(op);
		
		UserModel model=new UserModel();
		if(op.equalsIgnoreCase("delete")) {
			String ids[]=req.getParameterValues("ids");
			for (String id : ids) {
				dto.setId(Integer.parseInt(id));
				try {
					model.delete(dto);
				
					RequestDispatcher rd=req.getRequestDispatcher("UserListView.jsp");
					rd.forward(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		if(op.equalsIgnoreCase(op)) {
			pageNo=1;
			
		}
		List list=model.search(dto, pageNo, pageSize);
		RequestDispatcher rd=req.getRequestDispatcher("UserListView.jsp");
		req.setAttribute("List", list);
		req.setAttribute("deleteMsg", "id deleted Successfully");
		rd.forward(req, resp);

		
	}

}
