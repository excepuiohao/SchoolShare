package com.zhaohao.schoolshare.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaohao.schoolshare.service.UserService;
import com.zhaohao.schoolshare.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserLeaseGoodsByGoodsId
 */
@WebServlet("/UserLeaseGoodsByGoodsId")
public class UserLeaseGoodsByGoodsId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLeaseGoodsByGoodsId() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = (String) request.getSession().getAttribute("userId");
		String goodsId = request.getParameter("goodsid");
		boolean flag;
		int userCredit = 0;
		int userIntegral = 0;
		int goodsCredit = 0;
		int goodsIntegral = 0;
		try {
			UserService us = new UserServiceImpl();
			userCredit = us.findCredit(userId);
			userIntegral = us.findIntegral(userId);
			goodsCredit = us.findGoodsCredit(goodsId);
			goodsIntegral = us.findGoodsIntegral(goodsId);
			System.out.println(userCredit+";"+userIntegral+";"+goodsCredit+";"+goodsIntegral);
			if (userCredit < goodsCredit) {
				String message = "<script>alert('你的信用不足，租赁失败')</script>";
				System.out.println(message);
				response.getWriter().print(message);
				response.sendRedirect("UserIndex.jsp");
			} else if (userIntegral < goodsIntegral) {
				String message = "<script>alert('你的积分不足，租赁失败')</script>";
				System.out.println(message);
				response.getWriter().print(message);
				response.sendRedirect("UserIndex.jsp");
			} else {
				us.UpdateGoodsStatus(goodsId, "Y");
				us.UpdateUsersIntegral(userId, goodsIntegral);
				us.InsertOrder(userId, goodsId);
				String message = "<script>alert('租赁成功')</script>";
				System.out.println(message);
				response.getWriter().print(message);
				response.sendRedirect("UserIndex.jsp");

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
