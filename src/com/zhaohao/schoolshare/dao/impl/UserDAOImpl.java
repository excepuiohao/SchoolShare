package com.zhaohao.schoolshare.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zhaohao.schoolshare.bean.Goods;
import com.zhaohao.schoolshare.bean.Notice;
import com.zhaohao.schoolshare.bean.User;
import com.zhaohao.schoolshare.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	private Connection conn = null;

	public UserDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<User> findAllUser() throws Exception {
		List<User> all = new ArrayList<User>();
		String sql = "select * from user";
		try {
			Statement sm = this.conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString(1));
				user.setUserPassword(rs.getString(2));
				user.setUserCredit(rs.getInt(3));
				user.setUserIntegral(rs.getInt(4));
				user.setUserName(rs.getString(5));
				all.add(user);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return all;
	}

	@Override
	public boolean checkUser(String userId, String password) throws Exception {
		List<User> all = new ArrayList<User>();
		all = findAllUser();
		boolean flag = false;
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i).getUserId().equals(userId) && all.get(i).getUserPassword().equals(password)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public boolean insertUser(User user) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO user VALUES (" + "'" + user.getUserId() + "'" + "," + "'" + user.getUserPassword()
				+ "'" + "," + "'" + 10 + "'" + "," + "'" + 10 + "'" + "," + "'" + user.getUserName() + "'" + ")";
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
	public String findUserPassword(String userId, String userName) throws Exception {
		List<User> all = new ArrayList<User>();
		String sql = "select * from user";
		String userPassword = null;
		all = findAllUser();
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i).getUserId().equals(userId) && all.get(i).getUserName().equals(userName)) {
				userPassword = all.get(i).getUserPassword();
				break;
			}
		}
		return userPassword;
	}

	@Override
	public List<Notice> findNotice() throws Exception {
		List<Notice> all = new ArrayList<Notice>();
		String sql = "select * from notice";
		try {
			Statement sm = this.conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				Notice notice = new Notice();
				notice.setNoticetime(rs.getString(1));
				notice.setNoticeId(rs.getString(2));
				notice.setNoticeContext(rs.getString(3));
				all.add(notice);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return all;
	}

	@Override
	public ResultSet findgoods(String userId) throws Exception {
		ResultSet rs = null;
		String sql = "select school.goods.* from school.goods where goods.userid='" + userId + "'";
		try {
			Statement sm = this.conn.createStatement();
			rs = sm.executeQuery(sql);

		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	@Override
	public int findCredit(String userId) throws Exception {
		int credit = 0;
		String sql = "select school.user.usercredit from school.user where user.userid='" + userId + "'";

		try {
			Statement sm = this.conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				credit = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return credit;
	}

	@Override
	public ResultSet findGoodsByGoodsId(String goodsId) throws Exception {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		String sql = "select school.goods.* from school.goods where goods.goodsid='" + goodsId + "'";
		try {
			Statement sm = this.conn.createStatement();
			rs = sm.executeQuery(sql);

		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	@Override
	public boolean UserUpdateGoods(Goods goods) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "UPDATE school.goods set goodsid=?, goodsname=?,goodscredit=?,goodsintegral=?,goodstypeid=?,goodsstatus=?,userid=? where goodsid=? ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGoodsId()); // 所有的内容从user类中取出
			pstmt.setString(2, goods.getGoodsName());
			pstmt.setInt(3, goods.getGoodsCredit());
			pstmt.setInt(4, goods.getGoodsIntegral());
			pstmt.setString(5, goods.getGoodsTypeId());
			pstmt.setString(6, goods.getGoodsStatus());
			pstmt.setString(7, goods.getUserId());
			pstmt.setString(8, goods.getGoodsId());
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
	public int findGoodsCount() throws Exception {
		int count = 0;
		String sql = "select count(*) from goods";

		try {
			Statement sm = this.conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return count;
	}

	@Override
	public boolean insertGoods(Goods goods) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "insert into school.goods values(" + goods.getGoodsId() + ",'" + goods.getGoodsName() + "'," 
				+ goods.getGoodsCredit() + "," + goods.getGoodsIntegral() + "," + goods.getGoodsTypeId() + ",'"
				+ goods.getGoodsStatus() + "'," + goods.getUserId() + ");";
		try {
			pstmt = this.conn.prepareStatement(sql);
			try {
				if (pstmt.execute(sql)) {// 至少已经更新了一行
					flag = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public boolean UserUpdateIntegral(String userId) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		int userIntegral=findIntegral(userId)+3;
		String sql = "UPDATE school.user set userintegral="+userIntegral+"  where userid="+userId;
		try {
			pstmt = this.conn.prepareStatement(sql);
			try {
				if (pstmt.execute(sql)) {// 至少已经更新了一行
					flag = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public int findIntegral(String userId) throws Exception {
		int integral = 0;
		String sql = "select school.user.userintegral from school.user where user.userid='" + userId + "'";

		try {
			Statement sm = this.conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				integral = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return integral;
	}

	@Override
	public int findGoodsIntegral(String goodsId) throws Exception {
		int integral = 0;
		String sql = "select school.goods.goodsintegral from school.goods where goods.goodsid='" + goodsId + "'";

		try {
			Statement sm = this.conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				integral = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return integral;
	}

	@Override
	public int findGoodsCredit(String goodsId) throws Exception {
		int credit = 0;
		String sql = "select school.goods.goodscredit from school.goods where goods.goodsid='" + goodsId + "'";

		try {
			Statement sm = this.conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				credit = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return credit;
	}

	@Override
	public boolean UpdateGoodsStatus(String goodsId,String goodsStatus) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "UPDATE school.goods set goodsstatus='"+goodsStatus+"'  where goodsid="+goodsId;
		try {
			pstmt = this.conn.prepareStatement(sql);
			try {
				if (pstmt.execute(sql)) {// 至少已经更新了一行
					flag = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public boolean UpdateUsersIntegral(String userId, int integral) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		int userIntegral=findIntegral(userId)-integral;
		String sql = "UPDATE school.user set userintegral="+userIntegral+"  where userid="+userId;
		try {
			pstmt = this.conn.prepareStatement(sql);
			try {
				if (pstmt.execute(sql)) {// 至少已经更新了一行
					flag = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public boolean InsertOrder(String userId,  String goodsId) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "insert into school.order values(" + String.valueOf(findOrdersCount()+1) + ",'" + userId + "'," 
				+ goodsId + "," + "'F')" ;
		try {
			pstmt = this.conn.prepareStatement(sql);
			try {
				if (pstmt.execute(sql)) {// 至少已经更新了一行
					flag = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public int findOrdersCount() throws Exception {
		int count = 0;
		String sql = "select count(*) from school.order";

		try {
			Statement sm = this.conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return count;
	}

	@Override
	public boolean UpdateOrder(String goodsId) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "UPDATE school.order set goodsstatus ='Y'  where goodsid="+goodsId;
		try {
			pstmt = this.conn.prepareStatement(sql);
			try {
				if (pstmt.execute(sql)) {// 至少已经更新了一行
					flag = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public boolean UpdateGoods(String goodsId) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "UPDATE school.goods set goodsstatus ='F'  where goodsid="+goodsId;
		try {
			pstmt = this.conn.prepareStatement(sql);
			try {
				if (pstmt.execute(sql)) {// 至少已经更新了一行
					flag = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

}
