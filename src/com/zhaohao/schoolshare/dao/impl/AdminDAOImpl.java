package com.zhaohao.schoolshare.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zhaohao.schoolshare.bean.Admin;
import com.zhaohao.schoolshare.bean.Notice;
import com.zhaohao.schoolshare.bean.Order;
import com.zhaohao.schoolshare.bean.User;
import com.zhaohao.schoolshare.dao.AdminDAO;

public class AdminDAOImpl implements AdminDAO {

	private Connection conn = null;

	public AdminDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Admin> findAlladmin() throws Exception {
		List<Admin> all = new ArrayList<Admin>();
		String sql = "select * from admin";
		try {
			Statement sm = this.conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				Admin admin =new Admin();
				admin.setAdminId(rs.getString(1));
				admin.setAdminName(rs.getString(2));
				admin.setAdminPassword(rs.getString(3));
				all.add(admin);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return all;
	}
	

	@Override
	public boolean checkAdmin(String adminId, String adminPassword) throws Exception {
		List<Admin> all = new ArrayList<Admin>();
		all = findAlladmin();
		boolean flag = false;
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i).getAdminId().equals(adminId) && all.get(i).getAdminPassword().equals(adminPassword)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public boolean deleteUser(String userId) throws Exception {
		boolean flag=false;
		String sql = "delete from user where user.userid="+userId;
		try {
			PreparedStatement pstmt= this.conn.prepareStatement(sql);
			if (pstmt.executeUpdate() > 0) {// 至少已经更新了一行
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public User findUserByUserId(String userId) throws Exception {
		String sql = "select user.* from user where user.userid="+userId;
		User user=new User();
		try {
			Statement sm = this.conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				user.setUserId(rs.getString(1));
				user.setUserPassword(rs.getString(2));
				user.setUserCredit(rs.getInt(3));
				user.setUserIntegral(rs.getInt(4));
				user.setUserName(rs.getString(5));
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return user;
	
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "UPDATE user set userid=?, userpassword=?,usercredit=?,userintegral=?,username=? where userid=? ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserId()); // 所有的内容从user类中取出
			pstmt.setString(2, user.getUserPassword());
			pstmt.setInt(3, user.getUserCredit());
			pstmt.setInt(4, user.getUserIntegral());
			pstmt.setString(5, user.getUserName());
			pstmt.setString(6, user.getUserId());
			if (pstmt.executeUpdate() > 0) {// 至少已经更新了一行
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally { // 不管如何抛出，最终肯定是要进行数据库的关闭操作的
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e1) {

				}
			}
		}
		return flag;
	}

	@Override
	public boolean insertNotice(Notice notice) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO notice VALUES ("+"'" +  notice.getNoticetime() + "'" + "," + "'"
				+ notice.getNoticeId() + "'" + "," + "'" +notice.getNoticeContext() + "'"+")";
		PreparedStatement pstmt = null;
		try {
			pstmt = this.conn.prepareStatement(sql);
			if (pstmt.executeUpdate() > 0) {// 至少已经更新了一行
				flag = true;
			}
		} catch (Exception e) {

		} finally { // 不管如何抛出，最终肯定是要进行数据库的关闭操作的
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e1) {

				}
			}
		}
		return flag;
	}

	@Override
	public ResultSet findUserLease(String userId) throws Exception {
		ResultSet rs =null;
		String sql = "select school.order.*,school.goods.goodsname from school.order,school.goods where order.userId="+userId+" and order.goodsid=goods.goodsid";
		try {
			Statement sm = this.conn.createStatement();
			 rs = sm.executeQuery(sql);
			
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	@Override
	public ResultSet findGoodsByType(String categoryName) throws Exception {
		ResultSet rs =null;
		System.out.println(1111);
		String sql = "select school.goods.*,school.category.categoryname from school.goods,school.category where category.categoryname='"+categoryName+"' and category.categoryid=goods.goodstypeid";
		System.out.println(sql);
		try {
			Statement sm = this.conn.createStatement();
			 rs = sm.executeQuery(sql);
			
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	@Override
	public ResultSet findGoodsByName(String goodsName) throws Exception {
		ResultSet rs =null;
		String sql = "select school.goods.*,school.category.categoryname from school.goods,school.category where goods.goodsName like "+"'%"+goodsName+"%' and category.categoryid=goods.goodstypeid";
		System.out.println(sql);
		try {
			Statement sm = this.conn.createStatement();
			 rs = sm.executeQuery(sql);
			
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

}
