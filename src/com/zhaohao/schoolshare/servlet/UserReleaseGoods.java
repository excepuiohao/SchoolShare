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
 * Servlet implementation class UserReleaseGoods
 */
@WebServlet("/UserReleaseGoods")
public class UserReleaseGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReleaseGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsName=request.getParameter("goodsName");
		int goodsCredit =Integer.parseInt(request.getParameter("goodsCredit"));
		int goodsIntegral =Integer.parseInt(request.getParameter("goodsIntegral"));
		String goodsTypeId=request.getParameter("goodsTypeId");
		int goodsId=0;
		String goodsStatus="F";
		String userId=(String) request.getSession().getAttribute("userId");
		Goods goods=new Goods();
		boolean flag=false;
		try {
			UserService us = new UserServiceImpl();
			goodsId = us.findGoodsCount() + 1;
			goods.setGoodsId(String.valueOf(goodsId));
			goods.setGoodsName(goodsName);
			goods.setGoodsCredit(goodsCredit);
			goods.setGoodsIntegral(goodsIntegral);
			goods.setGoodsStatus(goodsStatus);
			goods.setGoodsTypeId(goodsTypeId);
			goods.setUserId(userId);
			flag=us.insertGoods(goods);
			us.UserUpdateIntegral(userId);
			if(flag==true){
				String seccuss="<script>alert('发布成功')</script>";
				response.getWriter().print(seccuss);
				response.sendRedirect("UserIndex.jsp");
			}else{
				String error="<script>alert('发布失败')</script>";
				response.getWriter().print(error);
				response.sendRedirect("UserIndex.jsp");
			}
		}  catch (Exception e) {
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
