package com.zhaohao.schoolshare.servlet;

import java.io.IOException;
import java.sql.ResultSet;

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
 * Servlet implementation class UserFindGoods
 */
@WebServlet("/UserFindGoods")
public class UserFindGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFindGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId= (String) request.getSession().getAttribute("userId");
		ResultSet rs=null;
		try {
			UserService as=new UserServiceImpl();
			rs=as.findgoods(userId);
			request.getSession().setAttribute("userGoods", rs);
			response.sendRedirect("UserGoods.jsp");
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
