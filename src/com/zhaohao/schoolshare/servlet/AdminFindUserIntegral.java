package com.zhaohao.schoolshare.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaohao.schoolshare.bean.User;
import com.zhaohao.schoolshare.service.AdminService;
import com.zhaohao.schoolshare.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminFindUserIntegral
 */
@WebServlet("/AdminFindUserIntegral")
public class AdminFindUserIntegral extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFindUserIntegral() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String userId=request.getParameter("userId");
				User user=null;
				try {
					AdminService us=new AdminServiceImpl();
					user=us.findUserByUserId(userId);
					if(user!=null){
						request.getSession().setAttribute("user", user);
						response.sendRedirect("UserIntegral.jsp");
					}else{
						String error="<script>alert('输入错误，请检查你的信息')</script>";
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
