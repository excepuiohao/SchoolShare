package com.zhaohao.schoolshare.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaohao.schoolshare.bean.Notice;
import com.zhaohao.schoolshare.service.AdminService;
import com.zhaohao.schoolshare.service.UserService;
import com.zhaohao.schoolshare.service.impl.AdminServiceImpl;
import com.zhaohao.schoolshare.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserSeeNotice
 */
@WebServlet("/UserSeeNotice")
public class UserSeeNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSeeNotice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Notice> list= new ArrayList<Notice>();
	
	try {
		UserService us=new UserServiceImpl();
		list=us.findNotice();
		request.getSession().setAttribute("allNotice", list);
		response.sendRedirect("UserSeeNotice.jsp");
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
