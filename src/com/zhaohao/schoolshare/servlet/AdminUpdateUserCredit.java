package com.zhaohao.schoolshare.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaohao.schoolshare.bean.User;
import com.zhaohao.schoolshare.service.AdminService;
import com.zhaohao.schoolshare.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminUpdateUserCredit
 */
@WebServlet("/AdminUpdateUserCredit")
public class AdminUpdateUserCredit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUpdateUserCredit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		int userCredit = Integer.parseInt(request.getParameter("userCredit"));
		int userIntegral = Integer.parseInt(request.getParameter("userIntegral"));
		String userName = request.getParameter("userName");
		User user = new User();
		user.setUserId(userId);
		user.setUserIntegral(userIntegral);
		user.setUserCredit(userCredit);
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		boolean flag=false;
		try {
				AdminService as = new AdminServiceImpl();
				flag=as.updateUser(user);
				if(flag==true){
					String seccuss="<script>alert('更新成功')</script>";
					response.getWriter().print(seccuss);
					response.sendRedirect("AdminIndex.jsp");
				}else{
					String error="<script>alert('更新失败')</script>";
					response.getWriter().print(error);
					response.sendRedirect("AdminIndex.jsp");
				}
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
