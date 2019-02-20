package com.zhaohao.schoolshare.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaohao.schoolshare.service.AdminService;
import com.zhaohao.schoolshare.service.UserService;
import com.zhaohao.schoolshare.service.impl.AdminServiceImpl;
import com.zhaohao.schoolshare.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		 try {
				AdminService as=new AdminServiceImpl();
				if(as.deleteUser(userId)){
					String seccuss="<script>alert('É¾³ý³É¹¦')</script>";
					response.getWriter().print(seccuss);
					response.sendRedirect("AdminIndex.jsp");
				}else{
					String error="<script>alert('É¾³ýÊ§°Ü')</script>";
					response.getWriter().print(error);
					response.sendRedirect("AdminIndex.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
