package com.zhaohao.schoolshare.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaohao.schoolshare.bean.Goods;
import com.zhaohao.schoolshare.service.UserService;
import com.zhaohao.schoolshare.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserUpdateGoods
 */
@WebServlet("/UserUpdateGoods")
public class UserUpdateGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateGoods() {
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
		String goodsId = request.getParameter("goodsId");
		String goodsName = request.getParameter("goodsName");
		String goodsStatus = request.getParameter("goodsStatus");
		String userId = request.getParameter("userId");
		String goodsTypeId = request.getParameter("goodsTypeId");
		int goodsCredit = Integer.parseInt(request.getParameter("goodsCredit"));
		int goodsIntegral = Integer.parseInt(request.getParameter("goodsIntegral"));
		Goods goods = new Goods();
		goods.setGoodsId(goodsId);
		goods.setGoodsName(goodsName);
		goods.setGoodsCredit(goodsCredit);
		goods.setGoodsIntegral(goodsIntegral);
		goods.setGoodsStatus(goodsStatus);
		goods.setGoodsTypeId(goodsTypeId);
		goods.setUserId(userId);
		boolean flag=false;
		try {
			UserService us=new UserServiceImpl();
			flag=us.UserUpdateGoods(goods);
			if(flag==true){
				String seccuss="<script>alert('更新成功')</script>";
				response.getWriter().print(seccuss);
				response.sendRedirect("UserIndex.jsp");
			}else{
				String error="<script>alert('更新失败')</script>";
				response.getWriter().print(error);
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
