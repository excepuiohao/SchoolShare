package com.zhaohao.schoolshare.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaohao.schoolshare.bean.Notice;
import com.zhaohao.schoolshare.service.AdminService;
import com.zhaohao.schoolshare.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminNotice
 */
@WebServlet("/AdminNotice")
public class AdminNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNotice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String noticeContext=request.getParameter("noticeContext");
		String noticeid=String.valueOf((int)(Math.random()*100+1));
		Date date=new Date();
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date dateTrans=null;
		String a=format2.format(date);
		try {
			dateTrans = format2.parse(a);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		Notice notice=new Notice();
		notice.setNoticeContext(noticeContext);
		notice.setNoticeId(noticeid);
		notice.setNoticetime(a);
		boolean flag=false;
		try {
			AdminService as= new AdminServiceImpl();
			flag=as.insertNotice(notice);
			if(flag==true){
			String success="<script>alert('发布成功')</script>";
			response.getWriter().print(success);
			response.sendRedirect("AdminIndex.jsp");
			}else{
				String error="<script>alert('发布失败')</script>";
				response.getWriter().print(error);
				response.sendRedirect("AdminIndex.jsp");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
