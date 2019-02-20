package com.zhaohao.schoolshare.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaohao.schoolshare.service.UserService;
import com.zhaohao.schoolshare.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserFindPasswordServlet
 */
@WebServlet("/UserFindPasswordServlet")
public class UserFindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFindPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPassword=null;
        try {
			UserService us=new UserServiceImpl();
			userPassword=us.findUserPassword(userId, userName);
			if(userPassword!=null){
				String seccuss="<script>alert('"+"你的密码是"+userPassword+"')</script>";
				response.getWriter().print(seccuss);
				response.sendRedirect("UserLogin.jsp");
			}else{
				String error="<script>alert('输入错误，请检查你的信息')</script>";
				response.getWriter().print(error);
				response.sendRedirect("UserLogin.jsp");
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
